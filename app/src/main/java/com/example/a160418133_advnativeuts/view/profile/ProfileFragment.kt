package com.example.a160418133_advnativeuts.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.util.loadImage
import com.example.a160418133_advnativeuts.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.fetch("");
        observeViewModel()

        btnDetailProfile.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfilFragmentToProfilDetailFragment("roby")
            Navigation.findNavController(it).navigate(action)
        }
        btnLogout.setOnClickListener {
            val action= ProfileFragmentDirections.actionItemProfilToLogin()
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun observeViewModel() {
        viewModel.profile.observe(viewLifecycleOwner, Observer {
            txtName.setText(it.name)
            imgProfile.loadImage(it.imgurl,loadImgProfile)
        })
    }
}