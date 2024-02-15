package EkologyMonitor;

import java.time.LocalDate;

public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private double volume;
    private LocalDate date;
    private ImpactType type;

    public EnvironmentalImpact(int id, int companyId, double volume, LocalDate date, ImpactType type) {
        this.id = id;
        this.companyId = companyId;
        this.volume = volume;
        this.date = date;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public double getVolume() {
        return volume;
    }

    public LocalDate getDate() {
        return date;
    }

    public ImpactType getType() {
        return type;
    }

    public enum ImpactType {
        ENERGY_CONSUMPTION,
        GAS_EMISSION
    }
}