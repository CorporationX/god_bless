package faang.school.godbless.BJS2_23005;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class EnvironmentalImpact {

    private int id;
    private Company company;
    private double volume;
    private LocalDate date;
    private TypeEnvironmentalImpact factor;

    @JsonCreator
    public EnvironmentalImpact(
            @JsonProperty("id") int id,
            @JsonProperty("company.id") int companyId,
            @JsonProperty("company.name") String companyName,
            @JsonProperty("company.totalEmployees") int totalEmployees,
            @JsonProperty("volume") double volume,
            @JsonProperty("date") LocalDate date,
            @JsonProperty("factor") TypeEnvironmentalImpact factor) {

        this.id = id;
        this.company = new Company(companyId, companyName, totalEmployees);
        this.volume = volume;
        this.date = date;
        this.factor = factor;
    }
}
