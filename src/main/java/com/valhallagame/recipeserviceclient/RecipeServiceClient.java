package com.valhallagame.recipeserviceclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.AbstractServiceClient;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestResponse;
import com.valhallagame.currencyserviceclient.message.LockCurrencyParameter;
import com.valhallagame.recipeserviceclient.message.AddRecipeParameter;
import com.valhallagame.recipeserviceclient.message.ClaimRecipeParameter;
import com.valhallagame.recipeserviceclient.message.GetRecipesParameter;
import com.valhallagame.recipeserviceclient.model.RecipeData;
import com.valhallagame.wardrobeserviceclient.message.WardrobeItem;

import java.io.IOException;
import java.util.List;

public class RecipeServiceClient extends AbstractServiceClient {
	private static RecipeServiceClient recipeServiceClient;

	private RecipeServiceClient() {
		serviceServerUrl = "http://localhost:" + DefaultServicePortMappings.RECIPE_SERVICE_PORT;
	}

	public static void init(String serviceServerUrl) {
		RecipeServiceClient client = get();
		client.serviceServerUrl = serviceServerUrl;
	}

	public static RecipeServiceClient get() {
		if (recipeServiceClient == null) {
			recipeServiceClient = new RecipeServiceClient();
		}
		return recipeServiceClient;
	}

    public RestResponse<List<RecipeData>> getRecipes(String username) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/recipe/get",
                new GetRecipesParameter(username), new TypeReference<List<RecipeData>>() {
				});
	}

	public RestResponse<String> addRecipe(String characterName, WardrobeItem recipe) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/recipe/add",
				new AddRecipeParameter(characterName, recipe), String.class);
	}

    public RestResponse<String> claimRecipe(String characterName, WardrobeItem recipe, List<LockCurrencyParameter.Currency> currencies) throws IOException {
		ClaimRecipeParameter claimRecipeParameter = new ClaimRecipeParameter(characterName, recipe, currencies);
		return restCaller.postCall(serviceServerUrl + "/v1/recipe/claim",
				claimRecipeParameter, String.class);
	}
}
