package model;

public class Feedback {
    private String customerName;
    private int rating;
    private String comment;

    public Feedback(String customerName, int rating, String comment) {
        this.customerName = customerName;
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return customerName + " (" + rating + "★): " + comment;
    }
}
