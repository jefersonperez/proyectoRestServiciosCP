package co.com.apirest.project.models.builders;

public class UpdateBookingDatesModels {
    private String checkin;
    private String checkout;

    public UpdateBookingDatesModels(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    // Getters and Setters
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
