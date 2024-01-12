package faang.school.godbless.multithreading.async.WOW;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    @Setter
    private int experience;
}
