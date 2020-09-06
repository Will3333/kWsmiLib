/*
 * Copyright 2020 William Smith
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package pro.wsmi.kwsmilib.language

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import pro.wsmi.kwsmilib.serialization.LanguageSerializer

@ExperimentalSerializationApi
@Serializable(with = LanguageSerializer::class)
enum class Language(val nativeName : String, val bcp47 : String, val iso639_1 : String, val iso639_3 : String)
{
    ENG("English", "en", "en", "eng"),
    FRA("français", "fr", "fr", "fra"),
    RUS("Русский", "ru", "ru", "rus")
}