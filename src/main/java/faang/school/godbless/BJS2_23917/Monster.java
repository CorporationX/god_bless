package faang.school.godbless.BJS2_23917;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Monster {
    private String name;
    private Pair location;
    private int timeToKill;

    @Override
    public String toString() {
        return "Monster name: " + name + '\n' + "location: " + location +
                '\n' + "timeToKill: " + timeToKill + '\n';
    }
}
