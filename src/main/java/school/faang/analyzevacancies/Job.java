package school.faang.analyzevacancies;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class Job {
    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate datePosted;
}
