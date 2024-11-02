package school.faang.threadasync;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quest {
    String name;
    int difficulty;
    int reward;
}
