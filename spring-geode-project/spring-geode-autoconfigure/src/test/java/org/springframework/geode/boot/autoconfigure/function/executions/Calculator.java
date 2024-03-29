/*
 * Copyright 2017-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.springframework.geode.boot.autoconfigure.function.executions;

import org.springframework.data.gemfire.function.annotation.OnMember;

/**
 * The {@link Calculator} interface defines Apache Geode Functions.
 *
 * @author John Blum
 * @see org.springframework.data.gemfire.function.annotation.OnRegion
 * @see org.springframework.data.gemfire.function.annotation.OnMember
 * @since 1.0.0
 */
// TODO change Function returns type when SDG properly handles Function method return types/values
@OnMember(groups = "test")
public interface Calculator {

	Object add(double operandOne, double operandTwo);

	Object divide(double numerator, double divisor);

	Object factorial(long number);

	Object multiply(double operandOne, double operandTwo);

	Object squareRoot(double number);

	Object squared(double number);

	Object subtract(double operandOne, double operandTwo);

}
