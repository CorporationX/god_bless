package school.faang.extremely_poor;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class WeasleyFamily {
    protected static final List<Chore> chores = new ArrayList<>(Arrays.asList(
            new Chore("Wash dishes"),
            new Chore("Wipe smth"),
            new Chore("Throw a garbage"),
            new Chore("Cook some dinner")
    ));
}
