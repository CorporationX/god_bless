package school.faang.a_distributed_army_of_sword_and_magic_heroes.BJS2_61166;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad {
    private static final Logger LOGGER = LoggerFactory.getLogger(Squad.class);

    private final String name;
    private List<Fighter> fighters;

    public int calculateSquadPower() {
        LOGGER.info("Calculating squad power");

        return fighters.stream().mapToInt(Fighter::getPower).sum();
    }
}
