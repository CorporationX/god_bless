package faang.school.godbless.sprint3.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Quest {

    private String name;
    private int difficulty;
    private int reward;
}
