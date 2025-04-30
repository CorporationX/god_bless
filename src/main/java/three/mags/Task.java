package three.mags;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
