package faang.school.godbless.sprint3.environment;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonPropertyOrder({"id", "company", "volume", "date", "type"})
public class EnvironmentalImpact {
    private int id;
    private String company;
    private double volume;
    private LocalDate date;
    private Type type;

    public enum Type {
        ENERGY_CONSUMPTION,
        GAS_EMISSION
    }
}
