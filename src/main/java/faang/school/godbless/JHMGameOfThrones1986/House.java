package faang.school.godbless.JHMGameOfThrones1986;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class House {

    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }
}
