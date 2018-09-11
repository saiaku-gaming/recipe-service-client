package com.valhallagame.recipeserviceclient;

import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;

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
}
