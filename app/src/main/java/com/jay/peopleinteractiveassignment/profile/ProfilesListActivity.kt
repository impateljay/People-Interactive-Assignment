package com.jay.peopleinteractiveassignment.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.jay.peopleinteractiveassignment.R
import com.jay.peopleinteractiveassignment.model.Profile
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import kotlinx.android.synthetic.main.activity_profiles_list.*

class ProfilesListActivity : AppCompatActivity(), ProfilesListView {

    private lateinit var profilesListPresenter: ProfilesListPresenter
    private var mAdapter: ProfilesListAdapter? = null
    private var profilesList: List<Profile>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiles_list)

        profilesListPresenter = ProfilesListPresenter()
        onAttach()

        profilesList = mutableListOf()
        mAdapter = ProfilesListAdapter(this@ProfilesListActivity, profilesList as ArrayList<Profile>)

        recycler_view.layoutManager = LinearLayoutManager(this@ProfilesListActivity)
        recycler_view.itemAnimator = SlideInRightAnimator()
        recycler_view.adapter = mAdapter

        profilesListPresenter.getProfiles()
    }

    override fun showToast(message: String?, length: Int) {
        Toast.makeText(this@ProfilesListActivity, message, length).show()
    }

    override fun onAttach() {
        profilesListPresenter.onAttach(this)
    }

    override fun onDetach() {
        profilesListPresenter.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDestroy()
    }

    override fun changeProgressBarVisibility(visibility: Int) {
        progress_bar.visibility = visibility
    }

    override fun addProfiles(profilesList: List<Profile>?) {
        mAdapter?.addProfiles(profilesList as ArrayList<Profile>)
        mAdapter?.notifyDataSetChanged()
    }
}
