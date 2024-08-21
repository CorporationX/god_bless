package job.analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {
    private String name;
    private  List<String> requirements;
    private double salary;
    private String location;
    private LocalDate createdAt;
}
