package faang.school.godbless;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class Job {
    private String positionName;
    private List<String> candidateRequirements;
    private double salary;
    private String location;
    private Date dateAdded;

    public Job() {

    }
}
