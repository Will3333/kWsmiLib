package pro.wsmi.kwsmilib.jvm.serialization

import kotlinx.serialization.*
import java.net.URL

@Serializer(forClass = URL::class)
object URLSerializer : KSerializer<URL>
{
    override val descriptor: SerialDescriptor = PrimitiveDescriptor("URLSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: URL) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): URL = URL(decoder.decodeString())
}