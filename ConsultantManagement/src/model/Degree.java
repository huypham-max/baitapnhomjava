package model;

public class Degree {
    private String title;
    private String university;
    private int year;

    public Degree(String title, String university, int year) {
        this.title = title;
        this.university = university;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " - " + university + " (" + year + ")";
    }
}
