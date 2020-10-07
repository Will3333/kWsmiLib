/*
 * Copyright 2020 William Smith
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package pro.wsmi.kwsmilib.geo

import kotlinx.serialization.Serializable

@Serializable
enum class GeographicRegion(val bcp47 : String)
{
    BE("BE"),
    BR("BR"),
    CA("CA"),
    CH("CH"),
    CN("CN"),
    ES("ES"),
    FR("FR"),
    GB("GB"),
    IE("IE"),
    IN("IN"),
    MX("MX"),
    PT("PT"),
    RU("RU"),
    SA("SA"),
    TW("TW"),
    US("US")
}