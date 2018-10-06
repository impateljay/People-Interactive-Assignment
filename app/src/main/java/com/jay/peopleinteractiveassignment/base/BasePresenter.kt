package com.jay.peopleinteractiveassignment.base

interface BasePresenter<in T : BaseView> {
    fun onAttach(view: T)
    fun onDetach()
}