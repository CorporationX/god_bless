package school.faang.bjs2_91294;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Squad extends Thread {
    private String name;
    private List<Character> characters = new ArrayList<Character>();

    public int calculateSquadPower() {
        return characters.stream()
                .mapToInt(Character::getPower)
                .sum();
    }
}
