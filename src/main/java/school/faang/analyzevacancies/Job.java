package school.faang.analyzevacancies;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Job {
    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate datePosted;
}
