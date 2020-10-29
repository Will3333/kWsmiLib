/*
 * Copyright 2020 William Smith
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package pro.wsmi.kwsmilib


data class BoundedValue<T: Comparable<T>>(val value: T, val upperLimitExceeded: Boolean, val lowerLimitExceeded: Boolean, val upperLimit: T?, val lowerLimit: T?)

@Suppress("unused")
fun <T: Comparable<T>> T.limit(upperLimit: T? = null, lowerLimit: T? = null) : BoundedValue<T>
{
    val upperLimitExceeded = upperLimit != null && this > upperLimit
    val lowerLimitExceeded = lowerLimit != null && this < lowerLimit

    return BoundedValue (
        when {
            upperLimitExceeded -> upperLimit!!
            lowerLimitExceeded -> lowerLimit!!
            else -> this
        },
        upperLimitExceeded,
        lowerLimitExceeded,
        upperLimit,
        lowerLimit
    )
}