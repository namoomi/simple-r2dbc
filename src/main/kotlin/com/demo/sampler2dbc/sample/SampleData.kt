package com.demo.sampler2dbc.sample

data class GetSampleListRes2(
    var contents: MutableList<GetSampleListRes>
)


data class GetSampleListRes(
    var id: Long,
    var name: String?=null,
    var description: String?=null
)

