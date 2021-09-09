package com.demo.sampler2dbc.sample.service.impl

import com.demo.sampler2dbc.sample.GetSampleListRes
import com.demo.sampler2dbc.sample.repository.ReactiveSampleRepository
import com.demo.sampler2dbc.sample.service.SampleService
import kotlinx.coroutines.reactor.awaitSingleOrNull
import mu.KotlinLogging
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException
import javax.transaction.Transactional

private val log = KotlinLogging.logger {}

@Service
class SampleServiceImpl(
    private val reactiveSampleRepository: ReactiveSampleRepository,
    //TODO CorountineRepository
    //private val customCoroutineRepository: CustomCoroutineRepository
) : SampleService {
    @Transactional
    override suspend fun list(sampleId: Long): GetSampleListRes {
        /*reactiveSampleRepository.findAllByName("11").let {
            log.debug { it }
            log.info { it }
        }*/
        return reactiveSampleRepository.findById(sampleId).awaitSingleOrNull()
            ?.let {
                GetSampleListRes(
                    id = it.id!!,
                    name = it.name,
                    description = it.desciption
                )
            }
            ?: throw EntityNotFoundException("not found Sample Entity")

        /*customCoroutineRepository.findById(1.toLong()).let {
            log.debug { it }
            log.info { it }
            println("custom  ${it!!.name}")
        }*/
    }
}