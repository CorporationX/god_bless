package faang.school.godbless.gameOfThrones;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class House {
    String name;
    String sigil;

    @Override
    public String toString() {
        return name + " (" +  sigil + ")";
    }
}
