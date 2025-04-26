package school.faang.bjs2_72404;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad<T extends Warrior> {

    List<T> squadMembers;

    public int calculateSquadPower() {
        return squadMembers.stream().map(Warrior::getPower).reduce(Integer::sum).orElse(0);
    }
}
