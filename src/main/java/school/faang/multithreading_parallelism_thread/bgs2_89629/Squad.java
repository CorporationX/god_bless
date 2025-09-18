package school.faang.multithreading_parallelism_thread.bgs2_89629;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Squad {
    private String typeFighter;
    private List<Fighter> listOfFighters;

    public Integer calculateSquadPower() {
        return listOfFighters.stream().mapToInt(Fighter::getPower).sum();
    }
}