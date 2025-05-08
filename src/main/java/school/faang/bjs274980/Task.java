package school.faang.bjs274980;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private String name;
    private int difficulty;
    private int reward;
}
