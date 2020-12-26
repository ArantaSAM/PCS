package com.pcs78.ui.auth

import android.content.Context
import android.print.PrintDocumentAdapter
import com.pcs78.data.model.ActionState
import com.pcs78.data.repository.AuthRepository
import kotlinx.coroutines.*

object AuthObject {
    fun logout(context: Context, callback: ((ActionState<Boolean>)->Unit)? = null) {
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main) {
                callback?.invoke(resp)
            }
        }
    }
}