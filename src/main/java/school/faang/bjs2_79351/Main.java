package school.faang.bjs2_79351;

public class Main {
    public static void main(String[] args) {
        Character Legolas = new Archer("Legolas");
        Character Gimli = new Warrior("Gimli");
        Character Aragorn = new Warrior("Aragorn");

        Legolas.attack(Legolas);
        Aragorn.attack(Gimli);

        System.out.println(Gimli.getHealth());
        System.out.println(Gimli.getHealth());
        System.out.println(Legolas.getHealth());
    }
}
