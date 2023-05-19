package com.example.myfitnesstoday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var btnForgotPassword: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)

        val btnAcces: Button = findViewById(R.id.btn_access)
        btnAcces.setOnClickListener {
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()
            validateRegisterForm(email, password)

            val i = Intent(this, DashboardActivity::class.java)
            startActivity(i)
        }

        btnRegister = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }

    private fun validateRegisterForm(email: String, password: String) {
        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, R.string.Warning_edit, Toast.LENGTH_SHORT).show()
        }
    }
}