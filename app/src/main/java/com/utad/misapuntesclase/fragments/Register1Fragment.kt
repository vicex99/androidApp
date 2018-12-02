package com.utad.misapuntesclase.fragments


import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.models.UserData
import java.util.*


class Register1Fragment : Fragment(){


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

    // fragmentos
    private lateinit var dateFragment: CalendaryDateFragment

    // datos para implementar en la pantalla
    private lateinit var myUserData: UserData

    // elementos pantalla
    private lateinit var tfName: TextView
    private lateinit var tfSurnameUser: TextView
    private lateinit var tfSurname2User: TextView
    private lateinit var btnBithdate: Button
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

            setElements(this)

            dateFragment = CalendaryDateFragment()

            myUserData = UserData.getInstance()
            this.findViewById<FloatingActionButton>(R.id.btnNext).setOnClickListener {
                Log.d("EnInflateLinstener", "estoy dentro")

                goSecond()
            }
            this.findViewById<Button>(R.id.btnBithdate).setOnClickListener{
                getAge()
            }
        }
    }

    /**
     * Conect element's view with variables
     *
     * @param - the view who you like connect
     */
    fun  setElements(view: View){
        tfName = view.findViewById(R.id.txtName)
        tfSurnameUser = view.findViewById(R.id.txtSurnameUser)
        tfSurname2User = view.findViewById(R.id.txtSurname2User)
        btnBithdate = view.findViewById(R.id.btnBithdate)
        tfAddress = view.findViewById(R.id.txtAddress)
        tfPostalCode = view.findViewById(R.id.txtPostalCode)
        tfCity = view.findViewById(R.id.txtCity)
        tfPhone = view.findViewById(R.id.intPhone)
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


    @SuppressLint("SetTextI18n")
    fun getAge() {
        dateFragment.show(fragmentManager, "date")

        dateFragment.selectedDate.observe(this, Observer <Date> {date ->
            btnBithdate.text = "${date.toString().subSequence(8, 10)} " +
                    "${date.toString().subSequence(4, 7)} " +
                    "${date.toString().subSequence(24, 28)}"

        })
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
