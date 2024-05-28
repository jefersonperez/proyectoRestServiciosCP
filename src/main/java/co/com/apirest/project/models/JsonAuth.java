package co.com.apirest.project.models;

import co.com.apirest.project.models.builders.JsonAuthBuilder;

public class JsonAuth {
    String username;
    String password;

    public JsonAuth(JsonAuthBuilder jsonAuthBuilder) {
        this.username = jsonAuthBuilder.getUsername();
        this.password = jsonAuthBuilder.getPassword();
    }
}
