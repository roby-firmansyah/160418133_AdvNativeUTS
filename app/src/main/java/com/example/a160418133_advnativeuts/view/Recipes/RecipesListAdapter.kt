package com.example.a160418133_advnativeuts.view.Recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418133_advnativeuts.R
import com.example.a160418133_advnativeuts.model.Recipes
import com.example.a160418133_advnativeuts.util.loadImage
import kotlinx.android.synthetic.main.recipes_list_item.view.*

class RecipesListAdapter(val recipesList:ArrayList<Recipes>):
    RecyclerView.Adapter<RecipesListAdapter.RecipeViewHolder>() {
    class RecipeViewHolder(var view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.recipes_list_item,parent,false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.view.txtListRecipesName.text=recipesList[position].name
        holder.view.imgRecipesList.loadImage(recipesList[position].imgurl,holder.view.errorRecipesList)

        holder.view.btnDetailRecipes.setOnClickListener {
            val action= RecipesListFragmentDirections.actionResepDetail(recipesList[position].name,recipesList[position].ingredients,recipesList[position].prepataion,recipesList[position].imgurl);
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
       // TODO("Not yet implemented")
        return recipesList.size
    }
    fun updateRecipes(newReipes:List<Recipes>){
        recipesList.clear()
        recipesList.addAll(newReipes)
        notifyDataSetChanged()
    }
}