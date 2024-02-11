package faang.school.godbless;

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

    @Override
    public String toString() {
        return  name + " " + sigil;
    }
}
