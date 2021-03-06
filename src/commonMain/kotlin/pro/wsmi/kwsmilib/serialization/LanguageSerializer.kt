/*
 * Copyright 2020 William Smith
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package pro.wsmi.kwsmilib.serialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import pro.wsmi.kwsmilib.language.Language

@ExperimentalSerializationApi
@Serializer(forClass = Language::class)
object LanguageSerializer : KSerializer<Language>
{
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Language", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Language) {
        encoder.encodeString(value.name.toLowerCase())
    }

    override fun deserialize(decoder: Decoder): Language = Language.valueOf(decoder.decodeString().toUpperCase())
}