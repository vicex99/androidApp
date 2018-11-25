package com.utad.misapuntesclase.fragments


import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView

import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.models.UserData

class Register2Fragment : Fragment() {


    interface OnFragmentInteractionListener {
        fun onFragmentInteractionEnd()
    }

    private var mCallback: OnFragmentInteractionListener? = null


    companion object {

        /**
         * Create a new instance of Register1Fragment.
         *
         * @return - New instance of Register1Fragment.
         */
        @JvmStatic
        fun newInstance() = Register2Fragment()

    }


    // implement data
    private lateinit var myUserData: UserData

    // Image variables
    private val PICK_IMAGE = 100
    private var imageUri: Uri? = null

    // view elements
    private var foto_gallery: ImageView? = null
    private lateinit var txtName: TextView
    private lateinit var txtSurname1: TextView
    private lateinit var txtSurname2: TextView
    private var tfDescription: TextView? = null

    //TOD: coger estos valores en pantalla
    private lateinit var rbGenderM: RadioButton
    //    private val checkBHobbies: Array<TextView>? = null


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register2, container, false).apply{

            txtName = findViewById(R.id.txtNameUser)
            txtSurname1 = findViewById(R.id.txtSurnameUser)
            txtSurname2 = findViewById(R.id.txtSurnameUser2)

            foto_gallery = findViewById(R.id.imgProfile)

            setData()

            findViewById<FloatingActionButton>(R.id.fab_visitdetail).setOnClickListener {
                setBeforeEnd()
                mCallback?.onFragmentInteractionEnd()
            }
        }
    }

    /**
     * Set object data in view data
     */
    private fun setData() {
        myUserData = UserData.getInstance()

        txtName.text = myUserData.name
        txtSurname1.text = myUserData.surname1
        txtSurname2.text = myUserData.surname2

    }

    /**
     * Set view data in object data
     */
    private fun setBeforeEnd(){
        myUserData.description = tfDescription?.text.toString()

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        // If activity not implements OnFragmentInteractionListener throw exception
        mCallback = context as OnFragmentInteractionListener

    }

    override fun onDetach() {
        super.onDetach()

        // Clean all callbacks listeners
        mCallback = null
    }
}
