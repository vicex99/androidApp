package com.utad.misapuntesclase.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import com.utad.misapuntesclase.R

import android.text.TextWatcher

class LoginActivity : AppCompatActivity() {

    // conexions with view

    // TODO("set data in sigleton")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    /*
     *
     */
    fun onGoNext(view: View){
        Intent(this, RegisterActivity::class.java).apply {

            // TODO("set data in sigleton")

            startActivity(this)
        }
    }

    fun txtWatch(txt:EditText){
        txt.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}
