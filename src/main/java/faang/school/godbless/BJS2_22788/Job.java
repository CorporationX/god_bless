package faang.school.godbless.BJS2_22788;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private String position;
    private List<String> requirements;
    private BigDecimal salary;
    private String location;
    private LocalDate datePosted;
}
