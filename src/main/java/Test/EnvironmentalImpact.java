package Test;

import java.time.LocalDate;

class EnvironmentalImpact {
    private static int idCounter = 0;
    private int id;
    private int companyId;
    private double volume;
    private LocalDate date;
    private EnvironmentalImpactType type;
    private String companyName;
    private int employees;

    public EnvironmentalImpact(int companyId, String companyName, int employees, double volume, LocalDate date, EnvironmentalImpactType type) {
        this.id = ++idCounter;
        this.companyId = companyId;
        this.companyName = companyName;
        this.employees = employees;
        this.volume = volume;
        this.date = date;
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getVolume() {
        return volume;
    }

    public LocalDate getDate() {
        return date;
    }

    public EnvironmentalImpactType getType() {
        return type;
    }

    public int getEmployees() {
        return employees;
    }
}