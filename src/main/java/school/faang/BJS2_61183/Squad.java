package school.faang.BJS2_61183;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Squad {
    private static final Logger logger = LoggerFactory.getLogger(Squad.class);
    private static final String NULL_ERROR = "This is argument cannot be null!";
    private static final String ADD_SUCCESSFULLY = "The warrior {} has been successfully added to the squad {}.";
    private static final String ADD_ALL_SUCCESSFULLY = "The all warriors has been successfully added to the squad {}.";
    private final String name;
    private final List<Warrior> squad = new ArrayList<>();

    public void addToSquad(Warrior warrior) {
        Objects.requireNonNull(warrior, NULL_ERROR);
        squad.add(warrior);
        logger.info(ADD_SUCCESSFULLY, warrior.getName(), name);
    }

    public void addAllToSquad(List<Warrior> warriors) {
        Objects.requireNonNull(warriors, NULL_ERROR);
        squad.addAll(warriors);
        logger.info(ADD_ALL_SUCCESSFULLY, name);
    }

    public int calculateSquadPower() {
        return squad.stream().mapToInt(Warrior::getPower).sum();
    }
}
