package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player {
    private String name;
    private int level;
    private int experience;

}
