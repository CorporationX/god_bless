package faang.school.godbless;

public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return this.name;
    }

    public String getSigil() {
        return this.sigil;
    }
}