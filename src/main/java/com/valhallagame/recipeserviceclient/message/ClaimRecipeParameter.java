package com.valhallagame.recipeserviceclient.message;

import com.valhallagame.common.validation.CheckLowercase;
import com.valhallagame.currencyserviceclient.message.LockCurrencyParameter;
import com.valhallagame.wardrobeserviceclient.message.WardrobeItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimRecipeParameter {
    @NotBlank
    @CheckLowercase
    private String characterName;

    @NotNull
    private WardrobeItem recipe;

    @NotNull
    private List<LockCurrencyParameter.Currency> currencies;
}
