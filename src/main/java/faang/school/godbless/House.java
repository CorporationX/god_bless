package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

public class House {
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return  name + " " + sigil;
    }
}
