package school.faang;

public class Main {


    public static void main(String[] args) {
        Character warrior = new Warrior("Vitas");
        Character archer = new Archer("Legolas");

        warrior.attack(archer);
        System.out.println(archer.getHealth());
    }
}
