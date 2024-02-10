package faang.school.godbless.GameOfThrones;

public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String toString() {
        return sigil;
    }
}
