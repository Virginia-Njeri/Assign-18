package com.naburi.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.naburi.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }
    fun displayContacts(){
        var contact = Contact("Anne", "anne@gmail.com", "0758862979","Box 1 Funyula", "")
        var contact2 = Contact("Benadine", "benadine@gmail.com", "0756679089","Box 616 Nairobi", "")
        var contact3 = Contact("Charles", "charles@gmail.com", "0733445566","Box 102 Rio De Jenairo", "")
        var contact4 = Contact("Dyon", "dyon@gmail.com", "0711223344","Box 1 Korea", "")
        var contact5 = Contact("Ethan", "ethan@gmail.com", "0755667788","Box 3 Amsterdan", "")
        var contact6 = Contact("Luis", "luis@gmail.com", "0755667788","Box 3 Amsterdan", "")
        var contact7 = Contact("Loise", "loise@gmail.com", "0755667788","Box 3 Amsterdan", "")
        var contact8 = Contact("Happiness", "james@gmail.com", "0755667788","Box 3 Amsterdan", "")


        var contactList = listOf(contact,contact2,contact3, contact4,contact5,contact6,contact7,contact8)

        var contactsAdapter = ContactRVAdapter(contactList)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactsAdapter
    }
}