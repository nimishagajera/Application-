package com.app.test.app.network.exception

import android.content.Context
import android.content.res.Resources
import com.app.test.R
import guru.jini.ilf.app.network.exception.InternalServerError
import java.io.IOException
import java.net.SocketException

open class GenericException(context:Context, e: Exception): IOException() {

    private var errorMessage: String

    init {
        errorMessage = context.getString(R.string.str_internet_connection_error)

        if (e is SocketException)
            errorMessage = context.getString(R.string.str_internet_connection_error)

        if (e is InternalServerError)
            errorMessage = context.getString(R.string.str_internal_server_error)

        if (e is Resources.NotFoundException)
            errorMessage = context.getString(R.string.error_not_found)

    }

    override val message: String?
        get() = errorMessage
}