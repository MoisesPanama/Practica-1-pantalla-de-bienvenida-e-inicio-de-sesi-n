package com.example.practica1

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private var passwordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tilCorreo = findViewById<TextInputLayout>(R.id.tilCorreo)
        val txtCorreo = findViewById<TextInputEditText>(R.id.txtCorreo)
        val tilPassword = findViewById<TextInputLayout>(R.id.tilPassword)
        val txtPassword = findViewById<TextInputEditText>(R.id.textPassword)
        val btnIngresar = findViewById<Button>(R.id.btnIngresarLogin)

        tilPassword.setEndIconOnClickListener {
            passwordVisible = !passwordVisible
            val cursorPosition = txtPassword.selectionEnd

            txtPassword.inputType = if (passwordVisible) {
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            txtPassword.setSelection(cursorPosition.coerceAtMost(txtPassword.text?.length ?: 0))

            tilPassword.setEndIconDrawable(
                if (passwordVisible) R.drawable.visibility_off else R.drawable.visibility
            )
            tilPassword.endIconContentDescription = getString(
                if (passwordVisible) R.string.hide_password else R.string.show_password
            )
        }

        btnIngresar.setOnClickListener {
            val correo = txtCorreo.text?.toString()?.trim().orEmpty()
            val password = txtPassword.text?.toString().orEmpty()
            var formularioValido = true

            if (correo.isEmpty()) {
                tilCorreo.error = getString(R.string.email_required)
                formularioValido = false
            } else {
                tilCorreo.error = null
            }

            if (password.isEmpty()) {
                tilPassword.error = getString(R.string.password_required)
                formularioValido = false
            } else {
                tilPassword.error = null
            }

            if (formularioValido) {
                Toast.makeText(this, R.string.login_success, Toast.LENGTH_SHORT).show()
            }
        }

        txtCorreo.doAfterTextChanged { tilCorreo.error = null }
        txtPassword.doAfterTextChanged { tilPassword.error = null }
    }
}
