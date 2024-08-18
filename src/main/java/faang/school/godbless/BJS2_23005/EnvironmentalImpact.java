package faang.school.godbless.BJS2_23005;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class EnvironmentalImpact {

    @JsonProperty("id")
    private int id;

    @JsonProperty("companyId")
    private int companyId;

    @JsonProperty("volume")
    private double volume;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("factor")
    private TypeEnvironmentalImpact factor;
}
