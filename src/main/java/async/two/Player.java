package async.two;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private String name;
    private int level;
    private int experience;

    @Setter(AccessLevel.NONE)
    protected final static int EXPERIENCE_TO_LEVEL_UP = 500;
}
