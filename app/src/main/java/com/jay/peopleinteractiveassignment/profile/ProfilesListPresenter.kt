package com.jay.peopleinteractiveassignment.profile

import android.view.View
import android.widget.Toast
import com.jay.peopleinteractiveassignment.base.BasePresenter
import com.jay.peopleinteractiveassignment.model.Results
import com.jay.peopleinteractiveassignment.network.ApiInterface
import com.jay.peopleinteractiveassignment.utility.Constants
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilesListPresenter : BasePresenter<ProfilesListView> {

    private var profilesListView: ProfilesListView? = null

    override fun onAttach(view: ProfilesListView) {
        profilesListView = view
    }

    override fun onDetach() {
        profilesListView = null
    }

    fun getProfiles() {
        doAsync {
            val apiService = ApiInterface.create()
            val profilesCall = apiService.getProfiles()
            profilesCall.enqueue(object : Callback<Results> {
                override fun onFailure(call: Call<Results>, t: Throwable) {
                    profilesListView?.showToast(Constants.FAILURE_MESSAGE, Toast.LENGTH_SHORT)
                }

                override fun onResponse(call: Call<Results>, response: Response<Results>) {
                    if (response.isSuccessful) {
                        profilesListView?.addProfiles(response.body()?.results)
                        profilesListView?.changeProgressBarVisibility(View.GONE)
                    } else {
                        profilesListView?.showToast(Constants.FAILURE_MESSAGE, Toast.LENGTH_SHORT)
                    }
                }

            })

        }
    }

}