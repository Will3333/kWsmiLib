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

/**
 * Regex pattern of ipv4 format
 */
val ipv4Regex = Regex(pattern = "((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])")

/**
 * Regex pattern of ipv6 format
 */
val ipv6Regex = Regex(pattern = """
    (
    ([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|
    ([0-9a-fA-F]{1,4}:){1,7}:|
    ([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|
    ([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|
    ([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|
    ([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|
    ([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|
    [0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|
    :((:[0-9a-fA-F]{1,4}){1,7}|:)|
    fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|
    ::(ffff(:0{1,4}){0,1}:){0,1}
    ((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\.){3,3}
    (25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|
    ([0-9a-fA-F]{1,4}:){1,4}:
    ((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\.){3,3}
    (25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])
    )
""".trimIndent())

/**
 * Regex pattern of domain name format
 */
val domainRegex = Regex(pattern = "[a-zA-Z0-9](-?[a-zA-Z0-9]){1,63}\\.[a-zA-Z]{2,6}")

/**
 * Regex pattern of email address format
 */
val emailAddressRegex = Regex(pattern = "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")

/**
 * Regex pattern of international phone number
 */
val internationalPhoneNumberRegex = Regex(pattern = "^\\+[1-9] ?(\\d{1,3})? ?\\(?\\d[0-9 \\(\\)-]{3,}[0-9\\)]\$")

/**
 * Regex pattern of absolute URL format
 */
val URLRegex = Regex(pattern = "^(?<protocol>[a-zA-Z0-9][a-zA-Z0-9\\-]{1,19}):\\/\\/((?<username>[a-zA-Z0-9_-]+)(:(?<password>[a-zA-Z0-9&#@<>°\$£%*µ§?=+_-]+))?@)?(?<host>(([a-zA-Z0-9](-?[a-zA-Z0-9]){0,63}\\.)*[a-zA-Z0-9](-?[a-zA-Z0-9]){1,63}\\.[a-zA-Z]{2,6})|(${ipv4Regex.pattern})|(\\[${ipv6Regex.pattern}\\]))(:(?<port>[1-9][0-9]{1,4}))?(?<path>\\/[a-zA-Z0-9%\\/.?=&#]*)?\$")