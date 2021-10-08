package com.example.a160418133_advnativeuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418133_advnativeuts.model.Recipes

class ItemRecipeDetailViewModel:ViewModel() {
    val recipes = MutableLiveData<Recipes>()

    fun fetch(name:String,ingredients:Array<String>,preparation:Array<String>,urlimg:String) {
        val recipe = Recipes("recipes",name,ingredients,preparation,urlimg)
        recipes.value = recipe
    }

}