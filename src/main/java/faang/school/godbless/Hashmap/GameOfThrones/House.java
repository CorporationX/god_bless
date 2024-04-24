package faang.school.godbless.Hashmap.GameOfThrones;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class House {
    private final String name;
    private final String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }
}
