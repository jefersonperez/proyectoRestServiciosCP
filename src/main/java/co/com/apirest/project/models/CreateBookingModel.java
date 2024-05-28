package co.com.apirest.project.models;

import co.com.apirest.project.models.builders.CreateBookingBuilder;
import co.com.apirest.project.models.builders.CreateBookingDatesModels;

public class CreateBookingModel {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private CreateBookingDatesModels bookingdates;
    private String additionalneeds;

    public CreateBookingModel(CreateBookingBuilder bookingBuilder) {
        this.firstname = bookingBuilder.getFirstname();
        this.lastname = bookingBuilder.getLastname();
        this.totalprice = bookingBuilder.getTotalprice();
        this.depositpaid = bookingBuilder.isDepositpaid();
        this.bookingdates = bookingBuilder.getBookingdates();
        this.additionalneeds = bookingBuilder.getAdditionalneeds();
    }

    // Getters and Setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public CreateBookingDatesModels getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(CreateBookingDatesModels bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
