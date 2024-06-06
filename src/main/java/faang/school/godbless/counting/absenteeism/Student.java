package faang.school.godbless.counting.absenteeism;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;
    private String faculty;
    private LocalDate year;

}
