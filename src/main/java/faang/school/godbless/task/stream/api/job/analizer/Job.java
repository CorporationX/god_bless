package faang.school.godbless.task.stream.api.job.analizer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private String position;
    private List<String> requirements;
    private double salary;
    private String location;
    private LocalDateTime dateOfCreation;
}
