package school.faang.heroesofmightandmagic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Squad {
    private final String squadName;
    private List<Character> squad;

    public int calculateSquadPower() {
        Objects.requireNonNull(this.squad, "Squad is empty");
        return this.squad.stream().map(Character::getPower).reduce(0, Integer::sum);
    }
}
