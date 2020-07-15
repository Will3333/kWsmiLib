package pro.wsmi.kwsmilib.jvm.serialization

import kotlinx.serialization.*
import java.net.InetSocketAddress

@ImplicitReflectionSerializer
@Serializer(forClass = InetSocketAddress::class)
object InetSocketAddressSerializer : KSerializer<InetSocketAddress>
{
    override val descriptor: SerialDescriptor = SerialDescriptor("InetSocketAddress") {
        element<String>("host")
        element<Int>("port")
    }

    override fun serialize(encoder: Encoder, value: InetSocketAddress) {
        val compositeEncoder = encoder.beginStructure(this.descriptor)
        compositeEncoder.encodeStringElement(this.descriptor, 0, value.hostString)
        compositeEncoder.encodeIntElement(this.descriptor, 1, value.port)
        compositeEncoder.endStructure(this.descriptor)
    }

    override fun deserialize(decoder: Decoder): InetSocketAddress
    {
        val compositeDecoder = decoder.beginStructure(this.descriptor)

        var host : String? = null
        var port : Int? = null

        loop@ while (true) {
            when (val i = compositeDecoder.decodeElementIndex(this.descriptor))
            {
                CompositeDecoder.READ_DONE -> break@loop
                0 -> host = compositeDecoder.decodeStringElement(this.descriptor, i)
                1 -> port = compositeDecoder.decodeIntElement(this.descriptor, i)
                else -> throw SerializationException("Unknown index $i")
            }
        }

        compositeDecoder.endStructure(this.descriptor)

        return InetSocketAddress(
            host ?: throw MissingFieldException("host"),
            port ?: throw MissingFieldException("port")
        )
    }
}