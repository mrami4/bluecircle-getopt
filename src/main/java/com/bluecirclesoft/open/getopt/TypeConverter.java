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

package com.bluecirclesoft.open.getopt;

/**
 * Defines a converter that converts the given string to the desired type.  Used for the parameter
 * -&gt; object annotations.
 */
@FunctionalInterface
public interface TypeConverter<T> {

	/**
	 * Convert the given string into an object of the specified type
	 *
	 * @param input   the input string
	 * @param options the options set in use (you'll want this for the usage())
	 * @param option  the specific option whose argument we're trying to parse
	 * @return the object, or {@code null} if appropriate
	 */
	T convert(String input, GetOpt options, OptionSpecification option);
}
