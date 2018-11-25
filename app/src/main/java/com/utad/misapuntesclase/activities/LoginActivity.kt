package com.utad.misapuntesclase.activities

import android.content.Intent
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import com.utad.misapuntesclase.R

import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    // conexions with view
    lateinit var txtEmail: EditText
    lateinit var txtPsw: EditText
    lateinit var btnNext: Button
    val mailPattern = Patterns.EMAIL_ADDRESS

    // TODO("set data in sigleton")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtPsw = findViewById(R.id.passwordLogin)
        txtEmail = findViewById(R.id.mailLogin)
        btnNext = findViewById(R.id.btnLogin)

        btnNext.setTextColor(resources.getColor(R.color.grey))
        title="U-Tad Blackboard"
        txtWatch(txtEmail)
        txtWatch(txtPsw)
    }

    fun onGoNext(view: View){
        Intent(this, RegisterActivity::class.java).apply {

            // TODO("set data in sigleton")

            startActivity(this)
        }
    }

    fun txtWatch(txt:EditText){
        txt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (mailPattern.matcher(txtEmail.text.toString()).matches()) {
                    btnNext.isEnabled = !txtPsw.text.toString().equals("") && txtPsw.text.length > 6
                    btnNext.setTextColor(resources.getColor(android.R.color.white))
                } else {
                    txtEmail.error = "Is not a valid email"
                    btnNext.isEnabled = false
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (mailPattern.matcher(txtEmail.text.toString()).matches()) {
                    btnNext.isEnabled = !txtPsw.text.toString().equals("") && txtPsw.text.length > 6
                    btnNext.setTextColor(resources.getColor(android.R.color.white))
                } else {
                    txtEmail.error = "Is not a valid email"
                    btnNext.isEnabled = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
        })
    }
}
