package com.valhallagame.recipeserviceclient.model;


import com.valhallagame.wardrobeserviceclient.message.WardrobeItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeData {
    String characterName;
    WardrobeItem recipeName;
    boolean claimed;
}
