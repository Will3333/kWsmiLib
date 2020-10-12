/*
 * Copyright 2020 William Smith
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package pro.wsmi.kwsmilib.net.http

import kotlinx.serialization.ExperimentalSerializationApi
import pro.wsmi.kwsmilib.language.BCP47LanguageTag
import pro.wsmi.kwsmilib.language.Language
import pro.wsmi.kwsmilib.geo.GeographicRegion

@ExperimentalSerializationApi
@Suppress("unused")
fun convertRawAcceptLanguageHeaderToBCP47LanguageTags(rawHeader : String) : List<BCP47LanguageTag>
{
    val rawTags = rawHeader.split(",")

    val tags = mutableListOf<BCP47LanguageTag>()

    rawTags.forEach { rawTag ->

        val langStr = rawTag.substringBefore(";").substringBefore("-")
        var tagLang : Language? = null

        for (lang in Language.values())
        {
            if (lang.bcp47.equals(langStr, ignoreCase = true)) {
                tagLang = lang
                break
            }
        }

        if (tagLang != null)
        {
            val regionStr = rawTag.substringBefore(";").substringAfter("-", "")
            var tagRegion : GeographicRegion? = null

            for (region in GeographicRegion.values())
            {
                if (region.bcp47.equals(regionStr, ignoreCase = true)) {
                    tagRegion = region
                    break
                }
            }

            if (tagRegion != null)
                tags.add(BCP47LanguageTag(tagLang, tagRegion))
            else
                tags.add(BCP47LanguageTag(tagLang))
        }
    }

    return tags.toList()
}