package com.example.a160418133_advnativeuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418133_advnativeuts.model.Users

class ProfileDetailViewModel:ViewModel() {
    val profile = MutableLiveData<Users>()

    fun fetch(id:String) {
        val user = Users(id,"Roby Firmansyah"," 29 November 1999","081330946701","https://media.discordapp.net/attachments/823023798730096660/896006487787311124/1.jpg")
        profile.value = user
    }
}