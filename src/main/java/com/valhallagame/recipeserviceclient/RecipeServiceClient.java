package com.valhallagame.recipeserviceclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.currencyserviceclient.message.LockCurrencyParameter;
import com.valhallagame.recipeserviceclient.message.AddRecipeParameter;
import com.valhallagame.recipeserviceclient.message.ClaimRecipeParameter;
import com.valhallagame.recipeserviceclient.message.GetRecipesParameter;
import com.valhallagame.wardrobeserviceclient.message.WardrobeItem;

import java.io.IOException;
import java.util.List;

public class RecipeServiceClient {
	private static RecipeServiceClient recipeServiceClient;

	private String recipeServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.RECIPE_SERVICE_PORT;
	private RestCaller restCaller;

	private RecipeServiceClient() {
		restCaller = new RestCaller();
	}

	public static void init(String recipeServiceServerUrl) {
		RecipeServiceClient client = get();
		client.recipeServiceServerUrl = recipeServiceServerUrl;
	}

	public static RecipeServiceClient get() {
		if (recipeServiceClient == null) {
			recipeServiceClient = new RecipeServiceClient();
		}

		return recipeServiceClient;
	}

	public RestResponse<List<String>> getRecipes(String username) throws IOException {
		return restCaller.postCall(recipeServiceServerUrl + "/v1/recipe/get",
				new GetRecipesParameter(username), new TypeReference<List<String>>() {
				});
	}

	public RestResponse<String> addRecipe(AddRecipeParameter input) throws IOException {
		return restCaller.postCall(recipeServiceServerUrl + "/v1/recipe/add",
				input, String.class);
	}

    public RestResponse<String> claimRecipe(String characterName, WardrobeItem recipe, List<LockCurrencyParameter.Currency> currencies) throws IOException {
		ClaimRecipeParameter claimRecipeParameter = new ClaimRecipeParameter(characterName, recipe, currencies);
		return restCaller.postCall(recipeServiceServerUrl + "/v1/recipe/claim",
				claimRecipeParameter, String.class);
	}


}
