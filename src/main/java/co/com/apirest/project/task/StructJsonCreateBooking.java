package co.com.apirest.project.task;

import co.com.apirest.project.models.CreateBookingModel;
import co.com.apirest.project.models.builders.CreateBookingBuilder;
import co.com.apirest.project.models.builders.CreateBookingDatesModels;
import com.google.gson.Gson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;
import java.util.Map;

public class StructJsonCreateBooking implements Task {
    private final List<Map<String, Object>> table;

    public StructJsonCreateBooking(List<Map<String, Object>> table) {
        this.table = table;
    }

    public static StructJsonCreateBooking withData(List<Map<String, Object>> table) {
        return Tasks.instrumented(StructJsonCreateBooking.class, table);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();

        for (Map<String, Object> row : table) {
            CreateBookingDatesModels bookingDates = new CreateBookingDatesModels(
                    row.get("checkin").toString(),
                    row.get("checkout").toString()
            );

            CreateBookingModel booking = new CreateBookingBuilder()
                    .withFirstname(row.get("firstname").toString())
                    .withLastname(row.get("lastname").toString())
                    .withTotalprice(Integer.parseInt(row.get("totalprice").toString()))
                    .withDepositpaid(Boolean.parseBoolean(row.get("depositpaid").toString()))
                    .withBookingdates(bookingDates)
                    .withAdditionalneeds(row.get("additionalneeds").toString())
                    .build();

            String bookingJson = gson.toJson(booking);
            System.out.println(bookingJson);
            actor.remember("jsonBooking", bookingJson);
        }
    }
}
