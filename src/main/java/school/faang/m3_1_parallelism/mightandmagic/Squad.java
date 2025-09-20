package school.faang.m3_1_parallelism.mightandmagic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Squad {
    private final List<Character> members;

    public int calculateSquadPower() {
        return members.stream()
                .mapToInt(Character::getPower)
                .sum();
    }
}
