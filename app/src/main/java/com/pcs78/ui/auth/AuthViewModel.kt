package com.pcs78.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pcs78.data.model.ActionState
import com.pcs78.data.model.AuthUser
import com.pcs78.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(var repo: AuthRepository) : ViewModel() {
    val authUser = repo.authUser
    val isLogin = repo.isLogin
    val authLogin = MutableLiveData<ActionState<AuthUser>>()
    val authRegister = MutableLiveData<ActionState<AuthUser>>()
    val autLogout = MutableLiveData<ActionState<Boolean>>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val fullname = MutableLiveData<String>()

    fun login() {
        viewModelScope.launch {
            val resp = repo.login(email.value ?: "", password.value ?: "")
            authLogin.value = resp
        }
    }

    fun register() {
        viewModelScope.launch {
            val resp = repo.register(
                AuthUser(
                    email = email.value ?: "",
                    password = password.value ?: "",
                    fullname = fullname.value ?: ""
                )
            )
            authRegister.value =resp
        }
    }

    fun logout(){
        viewModelScope.launch {
            val resp = repo.logout()
            autLogout.value = resp

        }
    }
}