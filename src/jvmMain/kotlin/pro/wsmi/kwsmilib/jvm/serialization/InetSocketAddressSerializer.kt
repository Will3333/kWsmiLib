/*
 * Copyright 2020 William Smith
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package pro.wsmi.kwsmilib.jvm.serialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.*
import java.net.InetSocketAddress


@ExperimentalSerializationApi
@Serializer(forClass = InetSocketAddress::class)
@Suppress("unused")
object InetSocketAddressSerializer : KSerializer<InetSocketAddress>
{
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("InetSocketAddress") {
        element<String>("host")
        element<Int>("port")
    }

    override fun serialize(encoder: Encoder, value: InetSocketAddress) = encoder.encodeStructure(this.descriptor) {

        encodeStringElement(descriptor, 0, value.hostString)
        encodeIntElement(descriptor, 1, value.port)
    }

    override fun deserialize(decoder: Decoder): InetSocketAddress = decoder.decodeStructure(this.descriptor) {

        var host : String? = null
        var port : Int? = null

        while (true) {
            when (val index = decodeElementIndex(descriptor))
            {
                0 -> host = decodeStringElement(descriptor, index)
                1 -> port = decodeIntElement(descriptor, index)
                CompositeDecoder.DECODE_DONE -> break
                else -> error("Unexpected index: $index")
            }
        }
        require(host != null && port != null)
        InetSocketAddress(host, port)
    }
}