package com.example.practica1

import android.os.Bundle
import android.text.InputType
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val tilPassword = findViewById<TextInputLayout>(R.id.tilPassword)
        val txtPassword = findViewById<TextInputEditText>(R.id.textPassword)

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
    }
}
