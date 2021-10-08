package com.example.a160418133_advnativeuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418133_advnativeuts.model.Recipes

class MyRecipesViewModel:ViewModel() {
    val recipes = MutableLiveData<List<Recipes>>()
    val recipesLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        var recipes1 = Recipes("recipes#1","Chicken Teriyaki Fried Rice", arrayOf("2 boneless","1 cup teriyaki sauce (240 mL)","1 cup broccoli floret (150 g)"),
            arrayOf("1. Marinate the chicken in teriyaki sauce in the refrigerator for at least an hour. 2. In a wok or deep skillet, add the chicken in the teriyaki marinade and cook thoroughly over high heat. Set aside. 3. In the same pan, add the oil and cook onions, garlic, and carrots until onions are translucent."),"https://img.buzzfeed.com/thumbnailer-prod-us-east-1/19983b4a5a7643e4be6471e8012b18ca/BFV24904_FriedRice4Ways_FB1080SQ.jpg")

        var recipes2 = Recipes("recipes#2","Easy Chicken Miso Ramen", arrayOf("1 tablespoon butter","1 cup corn (175 g)","2 eggs, soft-boiled","2 cups fresh spinach (80 g)","1 tablespoon fresh parsley"),
            arrayOf("1. Heat butter in a saucepan, fry corn until warm. Set aside. 2. Soft-boil 2 eggs and set aside. Blanch the spinach and set aside. 3. Bring chicken stock, garlic, ginger and scallions to a boil. Boil for 30 minutes. 4. Add the chicken, simmer for 20 minutes. Remove, and set aside."),"https://img.buzzfeed.com/video-api-prod/assets/9fcbbf1c8b974116bbca85dfccb7e066/BMP5726_Easy_Chicken_Miso_Ramen_Thumb.jpg")

        val recipelist:ArrayList<Recipes> = arrayListOf(recipes1,recipes2);

        recipes.value=recipelist
        recipesLoadError.value=false;
        loading.value=false
    }
}