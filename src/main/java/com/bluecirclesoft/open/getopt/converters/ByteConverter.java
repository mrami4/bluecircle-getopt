/*
 * Copyright 2015 Blue Circle Software, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.bluecirclesoft.open.getopt.converters;

import com.bluecirclesoft.open.getopt.CommandLineProcessingException;
import com.bluecirclesoft.open.getopt.GetOpt;
import com.bluecirclesoft.open.getopt.OptionSpecification;
import com.bluecirclesoft.open.getopt.TypeConverter;

/**
 * Converter to parse parameter strings into Bytes. This converter uses  {@code Byte.parseByte()},
 * so look there for all its peccadilloes.
 *
 * @see Byte#parseByte(String)
 */
public class ByteConverter implements TypeConverter<Byte> {

	/**
	 * Convert a string into a Byte or null.
	 *
	 * @param input the input string
	 * @return {@code null} if {@code input} is null or blank, or a Byte if the string is parseable
	 * @throws CommandLineProcessingException if the parse fails
	 * @see Byte#parseByte(String)
	 */
	@Override
	public Byte convert(String input, GetOpt options, OptionSpecification option) {
		if (ConverterUtil.isEmpty(input)) {
			return null;
		} else {
			try {
				return Byte.parseByte(input.trim());
			} catch (NumberFormatException e) {
				throw new CommandLineProcessingException("Option " + option.makeOptionDescriptor() + ": the value '" + input + "' must be" +
						" a number between " + Byte.MIN_VALUE + " and " + Byte.MAX_VALUE, options);
			}
		}
	}
}
