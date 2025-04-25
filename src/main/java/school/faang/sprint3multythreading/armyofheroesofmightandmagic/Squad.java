package school.faang.sprint3multythreading.armyofheroesofmightandmagic;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad {
    private String name;
    private List<Charachter> fighters;

    public int calculateSquadPower() {
        return fighters.stream().mapToInt(warrior -> warrior.power).sum();
    }
}