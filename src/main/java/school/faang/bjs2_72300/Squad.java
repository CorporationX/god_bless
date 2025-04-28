package school.faang.bjs2_72300;

import java.util.List;


public record Squad(String name, List<Character> list) {

    public int calculateSquadPower() {
        return list.stream().reduce(0,
                (partialPowerResult, user) -> partialPowerResult + user.getPower(), Integer::sum);
    }
}
