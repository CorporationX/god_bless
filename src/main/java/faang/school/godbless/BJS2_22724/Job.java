package faang.school.godbless.BJS2_22724;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@Getter
@AllArgsConstructor
public class Job {
    private String position;
    private int Salary;
    private String location;
    private LocalDateTime datePublication;
    private List<String> requirements;
}
