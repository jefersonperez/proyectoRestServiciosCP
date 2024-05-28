package co.com.apirest.project.models;

import co.com.apirest.project.models.builders.UpdateBookingBuilder;
import co.com.apirest.project.models.builders.UpdateBookingDatesModels;

public class UpdateBookingModel {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private UpdateBookingDatesModels bookingdates;
    private String additionalneeds;

    public UpdateBookingModel(UpdateBookingBuilder bookingBuilder) {
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

    public UpdateBookingDatesModels getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(UpdateBookingDatesModels bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
