package com.utad.misapuntesclase.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.fragments.Register1Fragment
import com.utad.misapuntesclase.fragments.Register2Fragment
import com.utad.misapuntesclase.models.UserData

class RegisterActivity : AppCompatActivity(), Register1Fragment.OnFragmentInteractionListener, Register2Fragment.OnFragmentInteractionListener {

    // Get the userData instance for use in both of fragments
    lateinit var myUserData: UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        title = "registro"
        loadFragments(savedInstanceState)
    }

    private fun loadFragments(savedInstanceState: Bundle? ){

        // confirm if exists the fragmentManager
        if (findViewById<View>(R.id.fragment_container) != null) {

            // Comprobacion si hay un registro anterior
            if (savedInstanceState != null) {
                return
            }

            val firstFragment = Register1Fragment.newInstance()


            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment_container, firstFragment)
            }.commit()
        }
    }

    /**
     * implement's function in the first register fragment how change the fragment into the second register fragment
     *
     * @param data - user data from the first register fragment
     */
    override fun onFragmentInteractionToSecond() {

        val detailNewFragment = Register2Fragment.newInstance()

        supportFragmentManager.beginTransaction().apply {

            replace(R.id.fragment_container, detailNewFragment)
            addToBackStack(null)
        }.commit()
    }

    /**
     *  Dirige el programa a la pantalla principal
     *
     *  @param data - datos del usuario recogidos en las dos partes del registro
     *  intent - redirige el flujo del programa a "PrincipalActivity"
     */
    override fun onFragmentInteractionEnd() {

       val intent = Intent (this, MainActivity::class.java)
           .apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        }
        startActivity(intent)

    }
}

