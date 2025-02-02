package school.faang.bjs250134;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Player {
    private String name;
    private int level;
    private int experience;
}
