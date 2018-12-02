package com.utad.misapuntesclase.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.utad.misapuntesclase.R
import com.utad.misapuntesclase.adapters.CommunityAdapter
import com.utad.misapuntesclase.adapters.NotificationsAdapter
import com.utad.misapuntesclase.adapters.SubjectAdapter
import com.utad.misapuntesclase.adapters.TeacherAdapter
import com.utad.misapuntesclase.fragments.*
import com.utad.misapuntesclase.modelsEntity.*
import com.utad.misapuntesclase.modelsEntity.UserData
import com.utad.misapuntesclase.adapters.GradeAdapter
import com.utad.misapuntesclase.modelsEntity.Community
import com.utad.misapuntesclase.modelsEntity.Subject

/**
 * donde se verán el menu desplegable y las listas
 */

class MainActivity : AppCompatActivity(), SubjectAdapter.OnClickedItemListener, TeacherAdapter.OnClickedItemListener, CommunityAdapter.OnClickedItemListener, GradeAdapter.OnClickedItemListener,
    NotificationsAdapter.OnClickedItemListener {


    override fun onItemSelected(notifications: Notifications) {
        Toast.makeText(this, "User: " + notifications.username, Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(grade: Grades) {
        Toast.makeText(this, "Nota: " + grade.grade, Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(community: Community) {
        val bundle = Bundle()
        bundle.putString(SubjectDialog.NAME, community.name)
        bundle.putString(SubjectDialog.BELOW_NAME, community.cordinator)
        bundle.putInt(SubjectDialog.IMAGE, community.imageID)
        bundle.putString(SubjectDialog.DESCRIPTION, community.description)
        bundle.putParcelableArrayList(SubjectDialog.RECYCLERVIEW_DATA, community.recyclerViewDataArrayList)
        val newFragment = SubjectDialog()
        newFragment.arguments = bundle
        newFragment.show(supportFragmentManager, "community")
    }

    // Here I implement the interface from the TeacherAdapter, so when you click on a item of that recyclerView, the dialog opens up
    override fun onItemSelected(teacher: Teacher) {
        val bundle = Bundle()
        bundle.putString(SubjectDialog.NAME, teacher.name)
        bundle.putString(SubjectDialog.BELOW_NAME, teacher.surname)
        bundle.putInt(SubjectDialog.IMAGE, teacher.imageID)
        bundle.putString(SubjectDialog.DESCRIPTION, "Awesome teacher")
        bundle.putParcelableArrayList(SubjectDialog.RECYCLERVIEW_DATA, teacher.recyclerViewDataArrayList)
        val newFragment = SubjectDialog()
        newFragment.arguments = bundle
        newFragment.show(supportFragmentManager, "teacher")
    }


    // Here I implement the interface from the SubjectAdapter, so when you click on a item of that recyclerView, the dialog opens up
    override fun onItemSelected(subject: Subject) {
        val bundle = Bundle()
        bundle.putString(SubjectDialog.NAME, subject.name)
        bundle.putString(SubjectDialog.BELOW_NAME, "2019")
        bundle.putInt(SubjectDialog.IMAGE, subject.imageID)
        bundle.putString(SubjectDialog.DESCRIPTION, subject.description)
        bundle.putParcelableArrayList(SubjectDialog.RECYCLERVIEW_DATA, subject.recyclerViewDataArrayList)
        val newFragment = SubjectDialog()
        newFragment.arguments = bundle
        newFragment.show(supportFragmentManager, "subject")
    }
    // Things needed for the navigation drawer
    private lateinit var dl: DrawerLayout
    private lateinit var t: ActionBarDrawerToggle
    private lateinit var nv: NavigationView

    // Create values of view navigation header
    private lateinit var name: TextView
    private lateinit var surname: TextView
    private lateinit var mail: TextView
    private lateinit var imgUser: ImageView

    private lateinit var myUserData: UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Again navigation drawer things
        dl = findViewById(R.id.activity_principal)
        t = ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close)
        dl.addDrawerListener(t)
        t.syncState()
        nv = findViewById(R.id.nv)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title= "Subjects"
        if (findViewById<FrameLayout>(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return
            }

            // Create a new Fragment to be placed in the activity grade_rv_item
            val firstFragment = SubjectFragment()

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.arguments = intent.extras

            // Add the fragment to the 'fragment_container' FrameLayout
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment_container, firstFragment)
            }.commit()
        }
        setListeners()
    }

    //This inflate the option menu with the logout option
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).apply {
            this.inflate(R.menu.dots_menu, menu).apply {
                // Set serializable
                myUserData = UserData.getInstance()
                // setDataNavHeader
                name = findViewById(R.id.txtName)
                surname = findViewById(R.id.txtSurname)
                mail = findViewById(R.id.txtEmail)
                imgUser = findViewById(R.id.imgUser)

                setData()
            }

        }
        return super.onCreateOptionsMenu(menu)
    }

    // Set the data in the view
    private fun setData() {
        val surnames: String = myUserData.surname1 + " " + myUserData.surname2

        name.text = myUserData.name
        surname.text = surnames
        mail.text = myUserData.email
        myUserData.imgUser?.let {
            imgUser.setImageURI(myUserData.imgUser)
        } ?: kotlin.run {
            imgUser.setImageResource(R.drawable.ic_user_example)
        }
    }

    //I always create a function that set the listeners, It helps in organization
    private fun setListeners(){

        //In this listener sets what the navigation drawer options do
        nv.setNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.subjects -> {
                    supportActionBar?.title = "Subject"
                    val newFragment = SubjectFragment()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_container, newFragment)
                        addToBackStack(null)
                    }.commit()
                    dl.closeDrawers()
                    true
                }
                R.id.notifications -> {
                    supportActionBar?.title = "Notifications"
                    val newFragment = NotificationsFragment()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_container, newFragment)
                        addToBackStack(null)
                    }.commit()
                    dl.closeDrawers()
                    true
                }
                R.id.grades -> {
                    supportActionBar?.title = "Grades"
                    val newFragment = GradesFragment()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_container, newFragment)
                        addToBackStack(null)
                    }.commit()
                    dl.closeDrawers()
                    true
                }
                R.id.teachers -> {
                    supportActionBar?.title = "Teachers"
                    val newFragment = TeachersFragment()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_container, newFragment)
                        addToBackStack(null)
                    }.commit()
                    dl.closeDrawers()
                    true
                }
                R.id.communities -> {
                    supportActionBar?.title = "Communities"
                    val newFragment = CommunitiesFragment()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_container, newFragment)
                        addToBackStack(null)
                    }.commit()
                    dl.closeDrawers()
                    true
                }

                else -> true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        //In this listener sets what the option menu options do
        when (id) {
            R.id.logout -> {
                val intent = Intent(this, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
            }
        }

        return if (t.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }
}
