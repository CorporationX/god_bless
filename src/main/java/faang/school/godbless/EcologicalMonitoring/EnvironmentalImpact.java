package faang.school.godbless.EcologicalMonitoring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private double volume;
    private LocalDate date;
    private EType type;

    public EnvironmentalImpact(String id, String companyId, String volume, String date, String type) {
        this.id = Integer.parseInt(id);
        this.companyId = Integer.parseInt(companyId);
        this.volume = Double.parseDouble(volume);
        String[] dateValues = date.split("\\.");
        this.date = LocalDate.of(Integer.parseInt(dateValues[0]), Integer.parseInt(dateValues[1]), Integer.parseInt(dateValues[2]));
        this.type = EType.valueOf(type);
    }
}
