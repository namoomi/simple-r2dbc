package com.demo.sampler2dbc.config

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories


@Configuration
@EnableR2dbcRepositories("com.demo.sampler2dbc.sample.repository")
class R2dbcConfig(
    private val r2dbcProps: R2dbcProperties
) : AbstractR2dbcConfiguration() {
    override fun connectionFactory(
    ): ConnectionFactory {
        val host = r2dbcProps.properties.getValue("host")
        val port = r2dbcProps.properties.getValue("port").toInt()
        return ConnectionFactories.get(
            builder()
                .option(PROTOCOL, "mysql")
                .option(DRIVER, "pool")
                .option(DATABASE, r2dbcProps.name)
                .option(HOST, host)
                .option(PORT, port)
                .option(USER, r2dbcProps.username)
                .option(PASSWORD, r2dbcProps.password)
                .build()
        )
    }
}


