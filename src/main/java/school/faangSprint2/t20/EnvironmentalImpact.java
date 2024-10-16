package school.faangSprint2.t20;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnvironmentalImpact {
    private String id;
    private String companyId;
    private double volume;
    private LocalDate date;
    private String type;

    public EnvironmentalImpact(String id, String companyId, double volume, LocalDate date) {
        this.id = id;
        this.companyId = companyId;
        this.volume = volume;
        this.date = date;
        this.type = "GAS_EMISSION";
    }
}