package faang.school.godbless.BJS2_22757;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class Job {
    private String jobName;
    private int salary;
    private String location;
    private LocalDate postingDate;
    private List<String> skills;
}
