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
public class Army {
    private static final Logger logger = LoggerFactory.getLogger(Army.class);
    private static final String NULL_ERROR = "This is argument cannot be null!";
    private static final String ADD_SUCCESSFULLY = "The squad {} has been successfully added to the army {}.";
    private final String name;
    private final List<Squad> army = new ArrayList<>();

    public void addSquad(Squad squad) {
        Objects.requireNonNull(squad, NULL_ERROR);
        army.add(squad);
        logger.info(ADD_SUCCESSFULLY, squad.getName(), name);
    }

    public int calculateTotalPower() {
        return army.stream().mapToInt(Squad::calculateSquadPower).sum();
    }
}
