package com.utad.misapuntesclase.fragments


import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView

import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.models.UserData


class Register1Fragment : Fragment() {

    interface OnFragmentInteractionListener {
        fun onFragmentInteractionToSecond()
    }
    private var mCallback: OnFragmentInteractionListener? = null

    companion object {

        /**
         * Create a new instance of Register1Fragment.
         *
         * @return - New instance of Register1Fragment.
         */
        @JvmStatic
        fun newInstance() =
            Register1Fragment()
    }

    // datos para implementar en la pantalla
    private lateinit var myUserData: UserData

    // elementos pantalla
    private lateinit var tfName: TextView
    private lateinit var tfSurnameUser: TextView
    private lateinit var tfSurname2User: TextView
    private var tfAddress: TextView? = null
    private var tfPostalCode: TextView? = null
    private var tfCity: TextView? = null
    private var tfPhone: TextView? = null
    private var spinner: Spinner? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register1, container, false).apply {

            tfName = findViewById(R.id.txtName)
            tfSurnameUser = findViewById(R.id.txtSurnameUser)
            tfSurname2User = findViewById(R.id.txtSurname2User)
            tfAddress = findViewById(R.id.txtAddress)
            tfPostalCode = findViewById(R.id.txtPostalCode)
            tfCity = findViewById(R.id.txtCity)
            tfPhone = findViewById(R.id.intPhone)

            myUserData = UserData.getInstance()
            this.findViewById<FloatingActionButton>(R.id.btnNext).setOnClickListener {
                Log.d("EnInflateLinstener", "estoy dentro")

                goSecond()
            }
        }
    }

    /**
     *  Set view data in the userData object
     */
    private fun goSecond(){
        myUserData.name = tfName.text.toString()
        myUserData.surname1 = tfSurnameUser.text.toString()
        myUserData.surname2 = tfSurname2User.text.toString()
        myUserData.address = tfAddress?.text.toString()
        myUserData.city = tfCity?.text.toString()

        if(tfPostalCode?.text.toString() != "")
            myUserData.postalCode = Integer.parseInt(tfPostalCode?.text.toString())

        if (tfPhone?.text.toString() != "")
            myUserData.phone = Integer.parseInt(tfPhone?.text.toString())

        mCallback?.onFragmentInteractionToSecond()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // If activity not implements OnFragmentInteractionListener throw exception
        if (context is OnFragmentInteractionListener) {
            mCallback = context
        }
        else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()

        // Clean all callbacks listeners
        mCallback = null
    }
}
