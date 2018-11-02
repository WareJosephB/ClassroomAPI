package com.qa.util;

import com.google.gson.Gson;

public class JSONTools {

	public JSONTools() {
		JSON = new Gson();
	}

	private static Gson JSON = new Gson();

	public static String JSONfromObject(Object obj) {
		return JSON.toJson(obj);

	}

	public static <T> T ObjectFromJSON(String jsonString, Class<T> clazz) {
		return JSON.fromJson(jsonString, clazz);

	}
}
