package com.utad.misapuntesclase.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button

import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.models.UserData

class LoginActivity : AppCompatActivity() {

    // conexions with view
    lateinit var txtEmail: EditText
    lateinit var txtPsw: EditText
    lateinit var btnNext: Button
    val mailPattern = Patterns.EMAIL_ADDRESS

    // Data singleton
    lateinit var myUserData: UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        myUserData = UserData.getInstance()

        txtPsw = findViewById(R.id.passwordLogin)
        txtEmail = findViewById(R.id.mailLogin)
        btnNext = findViewById(R.id.btnLogin)

        btnNext.setTextColor(resources.getColor(R.color.grey))
        title="U-Tad Blackboard"
        txtWatch(txtEmail)
        txtWatch(txtPsw)
    }

    // function who change view to "registerActivity"
    fun onGoNext(view:View){
        Intent(this, RegisterActivity::class.java).apply {
            myUserData.email = txtEmail.text.toString()
            startActivity(this)
        }
    }

    /**
     * listener of textMail o textPassword in the view
     * confirm if email and password have the format after and when you write
     *
     * @mail - ""@"".""
     * @password - has length equals 7 or higher
     *
     */
    fun txtWatch(txt:EditText){
        txt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {


                if (mailPattern.matcher(txtEmail.text.toString()).matches()) {
                    btnNext.isEnabled = txtPsw.text.length > 6
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
