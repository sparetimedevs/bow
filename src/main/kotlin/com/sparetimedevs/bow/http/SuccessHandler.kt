/*
 * Copyright (c) 2020 sparetimedevs and respective authors and developers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sparetimedevs.bow.http

import arrow.fx.IO
import com.microsoft.azure.functions.ExecutionContext
import com.microsoft.azure.functions.HttpRequestMessage
import com.microsoft.azure.functions.HttpResponseMessage
import com.microsoft.azure.functions.HttpStatus

@Suppress("UNUSED_PARAMETER")
fun <A> handleSuccessWithDefaultHandler(
    request: HttpRequestMessage<String?>,
    context: ExecutionContext,
    a: A
): IO<Nothing, HttpResponseMessage> =
    IO { request.createResponse(a) }

private fun <A> HttpRequestMessage<String?>.createResponse(a: A): HttpResponseMessage =
    this.createResponseBuilder(HttpStatus.OK)
        .body(a)
        .header(CONTENT_TYPE, CONTENT_TYPE_APPLICATION_JSON)
        .build()
