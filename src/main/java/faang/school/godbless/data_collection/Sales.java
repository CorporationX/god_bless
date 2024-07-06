package faang.school.godbless.data_collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Sales {
    private int id;
    private LocalDateTime timestamp;
    private int quantity;
}
