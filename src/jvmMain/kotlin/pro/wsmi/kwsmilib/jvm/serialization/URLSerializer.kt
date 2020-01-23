package pro.wsmi.kwsmilib.jvm.serialization

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import java.net.URL

@Serializer(forClass = URL::class)
object URLSerializer : KSerializer<URL>
{
    override val descriptor: SerialDescriptor = StringDescriptor.withName("URL")

    override fun serialize(encoder: Encoder, obj: URL) {
        encoder.encodeString(obj.toString())
    }

    override fun deserialize(decoder: Decoder): URL = URL(decoder.decodeString())
}