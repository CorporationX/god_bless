package faang.school.godbless.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Job {

    private String position;
    private List<String> requirements;
    private double salary;
    private String location;
    private LocalDateTime addedDate;
}
