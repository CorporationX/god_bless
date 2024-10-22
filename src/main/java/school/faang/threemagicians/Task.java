package school.faang.threemagicians;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String name;
    private Integer difficulty;
    private Integer reward;
}
