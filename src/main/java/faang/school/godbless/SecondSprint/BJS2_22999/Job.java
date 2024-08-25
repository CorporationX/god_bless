package faang.school.godbless.SecondSprint.BJS2_22999;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Job {
    private String title;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate date;

}
