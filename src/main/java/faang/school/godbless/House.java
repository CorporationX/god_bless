package faang.school.godbless;

import lombok.Getter;

public class House {
    @Getter
    private String name;
    @Getter
    private String sigil;
    public House(String name, String sigil){
        this.name=name;
        this.sigil=sigil;
    }
    public String toString(){
        return getName()+", "+getSigil();
    }
}
