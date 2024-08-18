package faang.school.godbless.BJS2_22852;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Job {
    private String title;
    private int salary;
    private String location;
    private LocalDate datePosted;
    private List<String> requirements;
}
