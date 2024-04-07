package faang.school.godbless.bjs2_4526;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Data {

    private int id;
    private String value;
    private LocalDateTime timestamp;
}
