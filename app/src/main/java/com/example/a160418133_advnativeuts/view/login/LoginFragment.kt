package com.example.a160418133_advnativeuts.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.a160418133_advnativeuts.R
import kotlinx.android.synthetic.main.fragment_login.*

class Login : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin.setOnClickListener {
            if(txtUsername.text.toString()!=""){
                var act=LoginDirections.actionLoginToItemHome()
                Navigation.findNavController(it).navigate(act)
            }else{
            }
        }
    }
}