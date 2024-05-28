package co.com.apirest.project.models.builders;

import co.com.apirest.project.models.UpdateBookingModel;
import lombok.Getter;

@Getter
public class UpdateBookingBuilder {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private UpdateBookingDatesModels bookingdates;
    private String additionalneeds;

    public UpdateBookingBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UpdateBookingBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UpdateBookingBuilder withTotalprice(int totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public UpdateBookingBuilder withDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
        return this;
    }

    public UpdateBookingBuilder withBookingdates(UpdateBookingDatesModels bookingdates) {
        this.bookingdates = bookingdates;
        return this;
    }

    public UpdateBookingBuilder withAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
        return this;
    }

    public UpdateBookingModel build() {
        return new UpdateBookingModel(this);
    }
}
