package game.of.thrones;

public class House {

    String name;
    String sigil;

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
    @Override
    public String toString(){
        return "Дом: " + name + ", Герб: " + sigil;
    }
}
