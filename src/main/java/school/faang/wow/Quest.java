package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
