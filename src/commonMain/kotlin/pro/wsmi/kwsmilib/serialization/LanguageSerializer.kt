package pro.wsmi.kwsmilib.serialization

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import pro.wsmi.kwsmilib.language.Language

@Serializer(forClass = Language::class)
object LanguageSerializer : KSerializer<Language>
{
    override val descriptor: SerialDescriptor
        get() = StringDescriptor

    override fun serialize(encoder: Encoder, obj: Language) {
        encoder.encodeString(obj.name.toLowerCase())
    }

    override fun deserialize(decoder: Decoder): Language = Language.valueOf(decoder.decodeString().toUpperCase())
}