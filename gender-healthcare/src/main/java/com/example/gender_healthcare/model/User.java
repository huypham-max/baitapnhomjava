package com.example.genderhealthcare.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String fullName;
    private String email;
    private String phone;

    private String gender;
    private String birthday;

    // Để quản lý theo dõi chu kỳ sinh sản
    private String menstrualCycleStart;  // ngày bắt đầu
    private int cycleLength;             // số ngày 1 chu kỳ
    private boolean birthControlReminder;

    // Relationships (optional)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TestRequest> requests;

    // Constructors
    public User() {}

    public User(String username, String fullName, String email, String phone, String gender, String birthday) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthday = birthday;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getMenstrualCycleStart() { return menstrualCycleStart; }
    public void setMenstrualCycleStart(String start) { this.menstrualCycleStart = start; }

    public int getCycleLength() { return cycleLength; }
    public void setCycleLength(int cycleLength) { this.cycleLength = cycleLength; }

    public boolean isBirthControlReminder() { return birthControlReminder; }
    public void setBirthControlReminder(boolean reminder) { this.birthControlReminder = reminder; }

    public List<TestRequest> getRequests() { return requests; }
    public void setRequests(List<TestRequest> requests) { this.requests = requests; }
}
