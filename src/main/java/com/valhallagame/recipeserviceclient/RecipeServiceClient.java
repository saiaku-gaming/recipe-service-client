package com.valhallagame.recipeserviceclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.recipeserviceclient.message.*;
import com.valhallagame.recipeserviceclient.model.RecipeType;

import java.io.IOException;
import java.util.List;

public class RecipeServiceClient {
	private static RecipeServiceClient recipeServiceClient;

	private String recipeServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.CHAT_SERVICE_PORT;
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

	public RestResponse<RecipeResult> addRecipe(String characterName, RecipeType recipeType, int amount)
			throws IOException {
		AddRecipeParameter input = new AddRecipeParameter(characterName, recipeType, amount);
		return restCaller.postCall(recipeServiceServerUrl + "/v1/recipe/add-recipe", input,
				RecipeResult.class);
	}

	public RestResponse<RecipeResult> subtractRecipe(String characterName, RecipeType recipeType, int amount)
			throws IOException {
		SubtractRecipeParameter input = new SubtractRecipeParameter(characterName, recipeType, amount);
		return restCaller.postCall(recipeServiceServerUrl + "/v1/recipe/subtract-recipe", input,
				RecipeResult.class);
	}

	public RestResponse<RecipeResult> getRecipe(String characterName, RecipeType recipeType)
			throws IOException {
		GetRecipeParameter input = new GetRecipeParameter(characterName, recipeType);
		return restCaller.postCall(recipeServiceServerUrl + "/v1/recipe/get-recipe", input,
				RecipeResult.class);
	}

	public RestResponse<List<RecipeResult>> getCurrencies(String characterName)
			throws IOException {
		GetCurrenciesParameter input = new GetCurrenciesParameter(characterName);
		return restCaller.postCall(recipeServiceServerUrl + "/v1/recipe/get-currencies", input,
				new TypeReference<List<RecipeResult>>() {});
	}
}
