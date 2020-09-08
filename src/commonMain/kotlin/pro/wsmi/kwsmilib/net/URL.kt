/*
 * Copyright 2020 William Smith
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package pro.wsmi.kwsmilib.net

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import pro.wsmi.kwsmilib.serialization.URLSerializer

@ExperimentalSerializationApi
@Serializable(with = URLSerializer::class)
data class URL (
    val protocol: String,
    val username: String? = null,
    val password: String? = null,
    val host: String,
    val port: Int? = null,
    val absolutePath: String? = null
)
{
    companion object {
        fun parseURL(urlStr: String) : URL?
        {
            val matchGroups = URLRegex.matchEntire(urlStr)?.groups as MatchNamedGroupCollection?

            val protocol = matchGroups?.get("protocol")?.value
            val host = matchGroups?.get("host")?.value
            val port = matchGroups?.get("port")?.value?.toInt()
            val path = matchGroups?.get("path")?.value
            val username = matchGroups?.get("username")?.value
            val password = matchGroups?.get("password")?.value

            return if (protocol != null && host != null)
                URL (protocol, host = host, port = port, absolutePath = path, username = username, password = password)
            else
                null
        }
    }

    override fun toString(): String = (
        this.protocol + "://"
                + if (this.username != null) "${this.username}:${this.password}@" else ""
                + this.host
                + if (this.port != null) ":${this.port}" else ""
                + (this.absolutePath ?: "")
    )
}