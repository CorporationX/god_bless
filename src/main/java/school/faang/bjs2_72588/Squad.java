package school.faang.bjs2_72588;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Squad implements Runnable {
    private final List<Character> characters;
    private int totalPower;

    @Override
    public void run() {
        calculateSquadPower();
    }

    public void calculateSquadPower() {
        totalPower = characters.stream()
            .mapToInt(Character::getPower)
            .sum();
    }
}
