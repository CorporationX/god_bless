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

    public class House(){
        this.name=name;
        this.sigil=sigil;
    }
}
