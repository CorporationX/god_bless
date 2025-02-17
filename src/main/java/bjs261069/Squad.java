package bjs261069;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class Squad {
    private String name;
    private List<Fighter> fighters = new ArrayList<>();

    public int calculateSquadPower(List<Fighter> fighters) {
        return Objects.requireNonNull(fighters).stream().mapToInt(Fighter::getPower).sum();
    }

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }
}
