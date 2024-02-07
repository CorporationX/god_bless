package faang.school.godbless.hash_map.game_of_thrones;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class House {
    private String name;
    private String sigil;

    @Override
    public String toString() {
        return "Дом: " + name + " | Герб: " + sigil;
    }
}
