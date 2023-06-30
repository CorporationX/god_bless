package faang.school.godbless.kxnvg.jobanalizer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Job {

    private String name;
    private double salary;
    private String location;
    private LocalDate dateAdded;
    private List<String> candidatesRequirements;
}
