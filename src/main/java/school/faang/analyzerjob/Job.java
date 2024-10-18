package school.faang.analyzerjob;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
@Data
@Builder
public class Job {
    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate datePosted;
}
