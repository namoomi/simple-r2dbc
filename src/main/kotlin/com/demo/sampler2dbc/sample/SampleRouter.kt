package com.demo.sampler2dbc.sample

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration

class SampleRouter {
    val basePath = "/api/v1/sample"

    @Bean
    @RouterOperations(
        RouterOperation(
            path = "/api/v1/sample/{id}",
            beanClass = SampleHandler::class, beanMethod = "list",
            //method = arrayOf(RequestMethod.GET),
            operation = Operation(
                operationId = "sampleTest",
                parameters = arrayOf(Parameter(name = "id", `in` = ParameterIn.PATH, description = "insert sampleId")),
                responses = arrayOf(
                    ApiResponse(
                        responseCode = "200",
                        content = arrayOf(Content(schema = Schema(implementation = GetSampleListRes::class)))
                    )
                )
            )
        )
    )
    fun sampleRoute(handler: SampleHandler) = coRouter {
        path(basePath).nest {
            accept(MediaType.APPLICATION_JSON).nest {
                GET("/{id}", handler::list)
                /*POST("", handler::create)
                DELETE("", handler::create)*/
            }
        }
    }


}