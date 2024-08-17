package faang.school.godbless.BJS2_23000;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
public class Difference {
    private LocalDate date;
    private int salary;

    public Difference(LocalDate date) {
        this.date = date;
        this.salary = 0;
    }
}
