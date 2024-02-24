package faang.school.godbless.vacancyanalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    private String name;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate date;
}
