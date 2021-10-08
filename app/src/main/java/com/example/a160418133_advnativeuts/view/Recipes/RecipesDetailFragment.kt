package com.example.a160418133_advnativeuts.view.Recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.util.loadImage
import com.example.a160418133_advnativeuts.viewmodel.ItemRecipeDetailViewModel
import kotlinx.android.synthetic.main.fragment_recipes_detail.*

class RecipesDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel:ItemRecipeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes_detail, container, false)
    }
    fun observeViewModel() {
        viewModel.recipes.observe(viewLifecycleOwner, Observer {
           txtDetailRecipes.setText(it.name)
            txtPreparationDetail.setText("Preparation:\n"+it.prepataion!!.joinToString(separator = "\n") {it})
            txtIngredientsDetail.setText("Ingredients:\n"+it.ingredients!!.joinToString(separator = "\n") {it})
            imgRecipes.loadImage(it.imgurl,errorImg)
        })
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val name = RecipesDetailFragmentArgs.fromBundle(requireArguments()).nama;
            val bahan = RecipesDetailFragmentArgs.fromBundle(requireArguments()).bahan;
            val cara = RecipesDetailFragmentArgs.fromBundle(requireArguments()).cara;
            val url = RecipesDetailFragmentArgs.fromBundle(requireArguments()).imgurl;
            viewModel = ViewModelProvider(this).get(ItemRecipeDetailViewModel::class.java)
            viewModel.fetch(name!!,bahan!!,cara!!,url!!);
            observeViewModel()
        }
    }
}