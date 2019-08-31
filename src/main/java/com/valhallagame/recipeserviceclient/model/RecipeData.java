package com.valhallagame.recipeserviceclient.model;


import com.valhallagame.common.validation.CheckLowercase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeData {
    @CheckLowercase
    String characterName;
    @NotBlank
    String recipeName;
    boolean claimed;
}
