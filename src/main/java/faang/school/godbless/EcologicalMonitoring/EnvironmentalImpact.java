package faang.school.godbless.EcologicalMonitoring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private double volume;
    private Date date;
    private EType type;

//Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)), Double.parseDouble(list.get(2)), DateFor.parse(list.get(3), EType.valueOf(list.get(4))))


    public EnvironmentalImpact(String id, String companyId, String volume, String date, String type) {
        SimpleDateFormat pattern = new SimpleDateFormat("yyyy.MM.dd");
        try {
            this.id = Integer.parseInt(id);
            this.companyId = Integer.parseInt(companyId);
            this.volume = Double.parseDouble(volume);
            this.date = pattern.parse(date);
            this.type = EType.valueOf(type);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException("Wrong csv");
        }
    }
}
