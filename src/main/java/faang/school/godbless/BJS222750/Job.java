package faang.school.godbless.BJS222750;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String jobTitle;
    private List<String> requirements;
    private double salary;
    private String location;
    private LocalDate postingDate;
}
