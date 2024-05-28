package co.com.apirest.project.task;

import co.com.apirest.project.models.JsonAuth;
import co.com.apirest.project.models.builders.JsonAuthBuilder;
import com.google.gson.Gson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class StructJson implements Task {
    List<Map<String, Object>> table;

    public static StructJson withData() {
        return Tasks.instrumented(StructJson.class);
    }

    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        table = actor.recall("table");

        JsonAuth jsonAuth = new JsonAuthBuilder()
                .withUsername(table.get(0).get("username").toString())
                .andPassword(table.get(0).get("password").toString())
                .build();

        String xcVariable = gson.toJson(jsonAuth);
        System.out.println(xcVariable);
        actor.remember("json", xcVariable);
    }
}
