package com.demo.sampler2dbc.sample

import com.demo.sampler2dbc.sample.service.SampleService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class SampleHandler(
    private val sampleService: SampleService
) {

    suspend fun list(request: ServerRequest): ServerResponse {
        val sampleId = request.pathVariable("id").toLong()
        return sampleService.list(sampleId).let {
            ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValueAndAwait(it)
        }
    }
}