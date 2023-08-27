package faang.school.godbless.DataCollectionForTheReport;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Sales {
    private int id;
    private LocalDateTime timestamp;
    private int quantity;
}
