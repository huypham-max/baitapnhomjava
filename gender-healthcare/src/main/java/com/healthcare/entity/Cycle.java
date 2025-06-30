package com.healthcare.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Cycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private int cycleLength;
    private int periodLength;

    private LocalDate ovulationDate;
    private LocalDate fertileStart;
    private LocalDate fertileEnd;

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }

    public int getPeriodLength() {
        return periodLength;
    }

    public void setPeriodLength(int periodLength) {
        this.periodLength = periodLength;
    }

    public LocalDate getOvulationDate() {
        return ovulationDate;
    }

    public LocalDate getFertileStart() {
        return fertileStart;
    }

    public LocalDate getFertileEnd() {
        return fertileEnd;
    }

    public void calculateFertilityWindow() {
        if (startDate != null && cycleLength > 0) {
            this.ovulationDate = startDate.plusDays(cycleLength - 14);
            this.fertileStart = ovulationDate.minusDays(4);
            this.fertileEnd = ovulationDate.plusDays(1);
        }
    }
}
