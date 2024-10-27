package school.faang.BJS2_38731;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Quest {
    private String name;
    private int difficulty;
    private int reward;
}
