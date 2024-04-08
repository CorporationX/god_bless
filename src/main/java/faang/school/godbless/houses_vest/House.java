package faang.school.godbless.houses_vest;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
@EqualsAndHashCode
@Getter
public class House {
    protected String name;
    protected String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }
}
