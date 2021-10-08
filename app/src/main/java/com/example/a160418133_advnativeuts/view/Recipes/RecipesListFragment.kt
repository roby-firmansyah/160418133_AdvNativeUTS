package com.example.a160418133_advnativeuts.view.Recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.viewmodel.ListRecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipes_list.*

class RecipesListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel:ListRecipeViewModel
    private val recipelistAdapter = RecipesListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListRecipeViewModel::class.java)
        viewModel.refresh()
        recViewResep.layoutManager = LinearLayoutManager(context)
        recViewResep.adapter = recipelistAdapter
        observeViewModel()
        fabAddRecipes.setOnClickListener {
            val action= RecipesListFragmentDirections.actionRecipesListFragmentToRecipesAddFragment();
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun observeViewModel() {
        viewModel.recipes.observe(viewLifecycleOwner, Observer {
            recipelistAdapter.updateRecipes(it)
        })
        viewModel.recipesLoadError.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtErrorRecipesList.visibility = View.VISIBLE
            } else {
                txtErrorRecipesList.visibility = View.GONE
            }
        })
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recViewResep.visibility = View.GONE
                resepLoad.visibility = View.VISIBLE
            } else {
                recViewResep.visibility = View.VISIBLE
                resepLoad.visibility = View.GONE
            }
        })
    }
}