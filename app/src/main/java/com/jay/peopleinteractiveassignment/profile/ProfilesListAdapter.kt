package com.jay.peopleinteractiveassignment.profile

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jay.peopleinteractiveassignment.R
import com.jay.peopleinteractiveassignment.model.Profile
import com.jay.peopleinteractiveassignment.utility.Constants

class ProfilesListAdapter(private val context: Context, private var profilesList: ArrayList<Profile>) : RecyclerView.Adapter<ProfilesListAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.name)
        var details: TextView = view.findViewById(R.id.details)
        var thumbnail: ImageView = view.findViewById(R.id.thumbnail)
        var decline: AppCompatButton = view.findViewById(R.id.decline)
        var accept: AppCompatButton = view.findViewById(R.id.accept)

        init {
            decline.setOnClickListener {
                removeAt(adapterPosition)
            }
            accept.setOnClickListener {
                removeAt(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.profile_row_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val profile = profilesList[position]
        holder.name.text = profile.name.first
        val details = profile.dob.age.toString() + Constants.DETAILS_SEPARATOR + profile.location.city + Constants.DETAILS_SEPARATOR + profile.location.state
        holder.details.text = details
        Glide.with(context)
                .load(profile.picture.large)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.thumbnail)
    }

    override fun getItemCount(): Int {
        return profilesList.size
    }

    fun addProfiles(profilesList: ArrayList<Profile>) {
        this.profilesList = profilesList
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        profilesList.remove(profilesList[position])
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, profilesList.size)
    }
}