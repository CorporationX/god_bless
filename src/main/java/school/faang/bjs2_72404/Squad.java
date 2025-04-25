package school.faang.bjs2_72404;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad<T extends Hero> {

    List<T> squadMembers;

    public int calculateSquadPower() {
        return squadMembers.stream().map(Hero::getPower).reduce(Integer::sum).orElse(0);
    }
}
