package faang.school.godbless.BJS2_23000;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
public class Job {
    private String name;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate dateAddition;
}
