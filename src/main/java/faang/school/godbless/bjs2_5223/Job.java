package faang.school.godbless.bjs2_5223;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String vacancy;
    private int salary;
    private String location;
    private LocalDate createdAt;
    private List<String> requirements;
}
