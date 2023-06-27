package faang.school.godbless.sprint3.vacancy_analyzer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Job implements Serializable {
    private String name;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate dateAdded;

}
