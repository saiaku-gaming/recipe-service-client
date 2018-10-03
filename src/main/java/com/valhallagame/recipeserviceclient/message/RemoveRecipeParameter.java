package com.valhallagame.recipeserviceclient.message;

import com.valhallagame.common.validation.CheckLowercase;
import com.valhallagame.wardrobeserviceclient.message.WardrobeItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoveRecipeParameter {
    @NotBlank
    @CheckLowercase
    private String characterName;

    @NotNull
    private WardrobeItem recipe;
}
