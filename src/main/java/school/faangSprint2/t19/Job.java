package school.faangSprint2.t19;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Job {

    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate datePosted;
}