package com.example.a160418133_advnativeuts.view.Recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.viewmodel.MyRecipesViewModel
import kotlinx.android.synthetic.main.fragment_my_recipes.*


class MyRecipesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel: MyRecipesViewModel
    private val myrecipesAdapter = MyRecipesListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MyRecipesViewModel::class.java)
        viewModel.refresh()

        myRecipesRecView.layoutManager = LinearLayoutManager(context)
        myRecipesRecView.adapter = myrecipesAdapter
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.recipes.observe(viewLifecycleOwner, Observer {
            myrecipesAdapter.updateRecipes(it)
        })
        viewModel.recipesLoadError.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                errorPopUp.visibility = View.VISIBLE
            } else {
                errorPopUp.visibility = View.GONE
            }
        })
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                myRecipesRecView.visibility = View.GONE
                loadMyRecipes.visibility = View.VISIBLE
            } else {
                loadMyRecipes.visibility = View.GONE
                myRecipesRecView.visibility = View.VISIBLE
            }
        })
    }
}