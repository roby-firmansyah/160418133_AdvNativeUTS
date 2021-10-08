package com.example.a160418133_advnativeuts.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.util.loadImage
import com.example.a160418133_advnativeuts.viewmodel.ProfileDetailViewModel
import kotlinx.android.synthetic.main.fragment_profile_detail.*

class ProfileDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_detail, container, false)
    }

    private lateinit var viewModel: ProfileDetailViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var username="roby";

        viewModel = ViewModelProvider(this).get(ProfileDetailViewModel::class.java)
        viewModel.fetch(username);
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.profile.observe(viewLifecycleOwner, Observer {
            txtNameProfile.setText(it.name)
            imgViewDetailProfile.loadImage(it.imgurl,loadDetailImg)
            txtDetailPhone.setText("Phone: " + it.phone)
            txtDetailBoD.setText("Birth of date:" + it.bod)
        })
    }
}