package com.maks.maxtask5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maks.maxtask5.R
import com.maks.maxtask5.data.ContactsDataSource

class MainActivity : AppCompatActivity() {

    val contacts = ContactsDataSource().getContacts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
              supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, ContactsListFragment.newInstance())
                .commit()
        }
    }
