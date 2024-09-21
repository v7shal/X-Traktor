package com.example.X_traktor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BeautifyJson {
    public static void main(String[] args) {
        String JsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Object jsonObject = gson.fromJson(JsonString, Object.class);
        String prettyJson = gson.toJson(jsonObject);

        System.out.println(prettyJson);
    }
}
