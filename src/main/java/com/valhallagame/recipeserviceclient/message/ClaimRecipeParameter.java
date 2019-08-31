package com.valhallagame.recipeserviceclient.message;

import com.valhallagame.common.validation.CheckLowercase;
import com.valhallagame.currencyserviceclient.model.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimRecipeParameter {
    @NotBlank
    @CheckLowercase
    private String characterName;

    @NotBlank
    private String recipe;

    @NotNull
    private Map<CurrencyType, Integer> currencies;
}
