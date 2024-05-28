package co.com.apirest.project.models.builders;

import co.com.apirest.project.models.CreateBookingModel;
import lombok.Getter;

@Getter
public class CreateBookingBuilder {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private CreateBookingDatesModels bookingdates;
    private String additionalneeds;

    public CreateBookingBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CreateBookingBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CreateBookingBuilder withTotalprice(int totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public CreateBookingBuilder withDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
        return this;
    }

    public CreateBookingBuilder withBookingdates(CreateBookingDatesModels bookingdates) {
        this.bookingdates = bookingdates;
        return this;
    }

    public CreateBookingBuilder withAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
        return this;
    }

    public CreateBookingModel build() {
        return new CreateBookingModel(this);
    }
}
