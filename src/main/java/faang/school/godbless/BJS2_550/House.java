package faang.school.godbless.BJS2_550;

import lombok.Getter;

@Getter
public class House {
    private String name;
    private String sigil;
    public House (String name, String sigil) {
        this.name=name;
        this.sigil=sigil;
    }
    public String toString(){
        return getName()+", "+getSigil();
    }
}

