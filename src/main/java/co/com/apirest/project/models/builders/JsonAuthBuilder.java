package co.com.apirest.project.models.builders;

import co.com.apirest.project.models.JsonAuth;
import lombok.Getter;

@Getter
public class JsonAuthBuilder {
    private String username;
    private String password;

    public JsonAuthBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public JsonAuthBuilder andPassword(String password) {
        this.password = password;
        return this;
    }

    public JsonAuth build() {
        return new JsonAuth(this);
    }

}