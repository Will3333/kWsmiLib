/*
 * Copyright 2020 William Smith
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package pro.wsmi.kwsmilib.jvm.io

import java.io.File
import kotlin.system.exitProcess

/**
 * Check if the file exists.
 * If it is not, the process is terminated, otherwise the function ends and return the file itself.
 * @param failureExplanation A explanation message to print if the checking fails
 * @param exitCode The status code if the function terminates the currently running process
 * @return The file itself (fluent pattern)
 */
@Suppress("unused")
fun File.checkFileExistsAndExitIfNot(failureExplanation : String? = "The file ${this.canonicalPath} does not exist.", exitCode : Int = 1) : File
{
    if (!this.exists() || !this.isFile) {
        if (failureExplanation !=null)
            println(failureExplanation)
        exitProcess(exitCode)
    }
    return this
}

/**
 * Check if the directory exists.
 * If it is not, the process is terminated, otherwise the function ends and return the directory itself.
 * @param failureExplanation A explanation message to print if the checking fails
 * @param exitCode The status code if the function terminates the currently running process
 * @return The directory itself (fluent pattern)
 */
@Suppress("unused")
fun File.checkDirectoryExistsAndExitIfNot(failureExplanation : String? = "The directory ${this.canonicalPath} does not exist.", exitCode : Int = 1) : File
{
    if (!this.exists() || !this.isDirectory) {
        if (failureExplanation !=null)
            println(failureExplanation)
        exitProcess(exitCode)
    }
    return this
}

/**
 * Check if the file/directory is readable.
 * If it is not, the process is terminated, otherwise the function ends and return the fil/directory itself.
 * @param failureExplanation A explanation message to print if the checking fails
 * @param exitCode The status code if the function terminates the currently running process
 * @return The file/directory itself (fluent pattern)
 */
@Suppress("unused")
fun File.checkIsReadableAndExitIfNot(failureExplanation : String? = "The ${if (this.isDirectory) "directory" else "file"} ${this.canonicalPath} is not readable.", exitCode : Int = 1) : File
{
    if (!this.canRead()) {
        if (failureExplanation !=null)
            println(failureExplanation)
        exitProcess(exitCode)
    }
    return this
}

/**
 * Check if the file/directory is writable.
 * If it is not, the process is terminated, otherwise the function ends and return the fil/directory itself.
 * @param failureExplanation A explanation message to print if the checking fails
 * @param exitCode The status code if the function terminates the currently running process
 * @return The file/directory itself (fluent pattern)
 */
@Suppress("unused")
fun File.checkIsWritableAndExitIfNot(failureExplanation : String? = "The ${if (this.isDirectory) "directory" else "file"} ${this.canonicalPath} is not writable.", exitCode : Int = 1) : File
{
    if (!this.canWrite()) {
        if (failureExplanation !=null)
            println(failureExplanation)
        exitProcess(exitCode)
    }
    return this
}