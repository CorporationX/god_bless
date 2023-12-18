package faang.school.godbless.stream_api.task3vacancies;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Job {
    private String position;
    private List<String> requirements;
    private double salary;
    private String location;
    private String dateAdded;
}
