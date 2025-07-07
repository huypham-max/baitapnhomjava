package model;

public class Experience {
    private String company;
    private String position;
    private int years;

    public Experience(String company, String position, int years) {
        this.company = company;
        this.position = position;
        this.years = years;
    }

    @Override
    public String toString() {
        return position + " tại " + company + " - " + years + " năm";
    }
}
