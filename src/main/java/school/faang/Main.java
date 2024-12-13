package school.faang;

public class Main {
    public static void main(String[] args) {

        Warrior paladin = new Warrior("Paladin");
        Archer legolas = new Archer("Legolas");

        legolas.attack(paladin);
        paladin.attack(legolas);

        System.out.println(legolas.health);
        System.out.println(paladin.health);
    }

}
