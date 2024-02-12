package faang.school.godbless;


import lombok.Getter;
@Getter
public class House {

    private final String name, sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

}
