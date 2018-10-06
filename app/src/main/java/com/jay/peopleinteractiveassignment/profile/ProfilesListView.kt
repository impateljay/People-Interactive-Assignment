package com.jay.peopleinteractiveassignment.profile

import com.jay.peopleinteractiveassignment.base.BaseView
import com.jay.peopleinteractiveassignment.model.Profile

interface ProfilesListView : BaseView {
    fun showToast(message: String?, length: Int)
    fun changeProgressBarVisibility(visibility: Int)
    fun addProfiles(users: List<Profile>?)
}