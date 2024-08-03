package faang.school.godbless.bjs2_19769;

//import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

//@AllArgsConstructor
public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }
}
