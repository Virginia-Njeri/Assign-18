package com.naburi.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.naburi.mycontacts.databinding.ActivityMainBinding
import com.naburi.mycontacts.databinding.ActivityViewContactBinding
import com.squareup.picasso.Picasso

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getExtra()
    }
    fun getExtra (){
        var name=intent.extras?.getString("NAME","")
        var phoneNumber=intent.extras?.getString("PHONE_NUMBER","")
        var address=intent.extras?.getString("ADDRESS","")
        var email=intent.extras?.getString("Email","")
        var image=binding.imgPerson

        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
        binding.tvNam.text=name
        binding.tvNumber.text=phoneNumber
        binding.tvEmail2.text=email
        binding.tvAdress.text=address
        Picasso.get().load(intent.getStringExtra("IMAGE"))
            .resize(200,200)
            .centerCrop()
            .into(image)
    }
}
