package faang.school.multithreadingparallelismthread.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private final String name;
    private int lvl;
    private int experience;
}
