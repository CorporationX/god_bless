package faang.school.sprint5.multithreading_conc.task10_report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class Sales {

    private int id;

    private LocalDateTime date;

    private int amount;
}
