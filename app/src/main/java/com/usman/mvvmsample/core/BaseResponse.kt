package com.usman.mvvmsample.core

/**
 * Created by Muhammad Usman on 1/31/2019.
 */
class BaseResponse<T>(var status: Status = Status.IDLE,
                      var data: T? = null,
                      var message: String? = null) {

    companion object {

        fun <T> success(data: T): BaseResponse<T> {
            return BaseResponse(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): BaseResponse<T> {
            return BaseResponse(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): BaseResponse<T> {
            return BaseResponse(Status.LOADING, data, null)
        }

    }


}

enum class Status {
    IDLE,
    LOADING,
    SUCCESS,
    ERROR
}