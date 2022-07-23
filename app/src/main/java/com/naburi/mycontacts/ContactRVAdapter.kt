package com.naburi.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.naburi.mycontacts.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso

class ContactRVAdapter(var contactList:List<Contact>):
    RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactListItemBinding
            .inflate(LayoutInflater .from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact = contactList.get(position)
        holder.binding.tvName.text = currentContact.name
        holder.binding.tvPhone.text = currentContact.phoneNumber
        holder.binding.tvEmail.text = currentContact.email
        holder.binding.tvAddress.text = currentContact.address
        Picasso.get()
            .load(currentContact.image)
            .resize(300,300)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(holder.binding.ivContact)

        val context=holder.itemView.context
        holder.binding.ivContact.setOnClickListener{
            Toast
                .makeText(context,"You are beautiful",Toast.LENGTH_LONG).show()

        }
        holder.binding.cvContact.setOnClickListener{
            val intent=Intent(context,ViewContactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("Email",currentContact.email)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("PHONE_NUMBER",currentContact.phoneNumber)
            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)


        }
    }
    override fun getItemCount(): Int {
        return contactList.size
    }

}
class ContactViewHolder(val binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root)