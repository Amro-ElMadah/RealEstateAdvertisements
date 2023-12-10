package com.avivgroup.realestateadvertisements.data.remote.network.response

sealed class Response<T>(
    var data: T? = null,
    var loading: Boolean? = false,
    var throwable: Throwable? = null,
) {
    class Success<T>(data: T) : Response<T>(data)
    class Loading<T>(loading: Boolean?) : Response<T>(null, loading)
    class Error<T>(throwable: Throwable?) :
        Response<T>(null, false, throwable)
}