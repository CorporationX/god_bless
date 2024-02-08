package faang.school.godbless.game_of_thrones;

public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", sigil='" + sigil + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }
}
