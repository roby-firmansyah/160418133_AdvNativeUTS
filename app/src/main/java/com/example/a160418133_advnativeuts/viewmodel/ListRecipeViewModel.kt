package com.example.a160418133_advnativeuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418133_advnativeuts.model.Recipes

class ListRecipeViewModel: ViewModel() {
    val recipes = MutableLiveData<List<Recipes>>()
    val recipesLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        //List Recipes
        var recipes1 = Recipes("recipes#1","BBQ Chicken Pizza Tacos", arrayOf("2 chicken breasts","2 teaspoons salt","1 teaspoon paprika","1 cup shredded cheese blend (100 g)","1 tablespoon fresh parsley"),
            arrayOf("1.Preheat the oven to 350°F (180°C) and line a baking sheet with parchment paper.","2.Cut the chicken breasts into ¾-inch (2 cm) cubes and transfer to a medium bowl.","3.Heat the oil in a large cast-iron skillet over high heat.","4.Add the chicken and cook for 10 minutes, or until golden and charred on the edges. Remove the pan from the heat."),"https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/160953.jpg")

        var recipes2 = Recipes("recipes#2","Beef Beer Goulash", arrayOf("1 tablespoon butter","2 lb stewing beef (1 kg)","3 teaspoons salt","1 onion"),
            arrayOf("1. Heat half of the butter in large pot or Dutch oven.","2. Add the beef, in batches, browning all sides of the meat.","3.In the same pan, heat remaining butter, then add in the onion, celery, and carrot."),"https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/114453.jpg")

        var recipes3 = Recipes("recipes#3","Eggplant Potato Tomato Stew", arrayOf("2 tablespoon butter","2 lb stewing beef (1 kg)","3 teaspoons salt","1 onion"),
            arrayOf("1. Preheat the oven to 400ºF (200ºC).","2. With a sharp knife, score a ring around each potato.","3. Just deep enough to break the skin."),"https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/177026.jpg")

        var recipes4 = Recipes("recipes#4","Freezer-Prep Protein Packed Chili", arrayOf("2 chicken breasts1 tablespoon butter","4 lb stewing beef (1 kg)","1 teaspoon paprika","3 teaspoons salt"),
            arrayOf("1. In a large pot, heat the oil over medium-high heat.","2. Add onion and cook until translucent.","3. Add the garlic and cook for 1 minute, stirring occasionally.","4. Transfer to a slow cooker."),"https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/129477.jpg")

        val recipelist:ArrayList<Recipes> = arrayListOf(recipes1,recipes2,recipes3,recipes4);
        recipes.value = recipelist
        recipesLoadError.value=false;
        loading.value=false
    }
}