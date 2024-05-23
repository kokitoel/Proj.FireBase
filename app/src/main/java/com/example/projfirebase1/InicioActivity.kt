package com.example.projfirebase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth


class InicioActivity : AppCompatActivity() {
    private val autentication by lazy { FirebaseAuth.getInstance() }
    lateinit var tvUser: TextView
    lateinit var btLogout: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        tvUser = findViewById(R.id.tvUser)
        btLogout = findViewById(R.id.btLogout)
        btLogout.setOnClickListener {
            autentication.signOut()
            finish()
        }
        tvUser.text = autentication.currentUser?.email
    }
}