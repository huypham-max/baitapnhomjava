package model;

import java.util.*;

public class Consultant {
    private int id;
    private String name;
    private String email;
    private String phone;
    private List<Degree> degrees = new ArrayList<>();
    private List<Experience> experiences = new ArrayList<>();
    private List<Feedback> feedbacks = new ArrayList<>();

    public Consultant(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void addDegree(Degree d) { degrees.add(d); }
    public void addExperience(Experience e) { experiences.add(e); }
    public void addFeedback(Feedback f) { feedbacks.add(f); }

    public double getAverageRating() {
        return feedbacks.stream().mapToInt(Feedback::getRating).average().orElse(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tư vấn viên: ").append(name).append("\n")
          .append("Email: ").append(email).append(" | SĐT: ").append(phone).append("\n")
          .append("-- Bằng cấp --\n");
        degrees.forEach(d -> sb.append(d).append("\n"));
        sb.append("-- Kinh nghiệm --\n");
        experiences.forEach(e -> sb.append(e).append("\n"));
        sb.append("-- Đánh giá --\n");
        feedbacks.forEach(f -> sb.append(f).append("\n"));
        sb.append("Trung bình sao: ").append(String.format("%.1f", getAverageRating()));
        return sb.toString();
    }
}
