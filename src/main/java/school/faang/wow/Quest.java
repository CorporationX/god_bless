package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quest {
    private String name;
    private Integer difficulty;
    private Integer reward;
}
