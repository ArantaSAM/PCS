package com.pcs78.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.pcs78.R
import com.pcs78.data.model.AuthUser
import com.pcs78.databinding.ActivityAuthBinding
import com.pcs78.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }
    fun onSuccess(user: AuthUser?){
        val intent = Intent (this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}