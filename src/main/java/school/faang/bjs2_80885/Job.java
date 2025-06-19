package school.faang.bjs2_80885;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private String position;
    private List<String> requirements;
    private double salary;
    private String location;
    private LocalDate datePosted;
}
