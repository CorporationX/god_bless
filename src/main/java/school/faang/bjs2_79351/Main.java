package school.faang.bjs2_79351;

public class Main {
    public static void main(String[] args) {
        Character legolas = new Archer("Legolas");
        Character gimli = new Warrior("Gimli");
        Character aragorn = new Warrior("Aragorn");

        legolas.attack(legolas);
        aragorn.attack(gimli);

        System.out.println(gimli.getHealth());
        System.out.println(gimli.getHealth());
        System.out.println(legolas.getHealth());
    }
}
