package faang.school.godbless.BJS2_5214;

import lombok.Data;

@Data
public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }
}
