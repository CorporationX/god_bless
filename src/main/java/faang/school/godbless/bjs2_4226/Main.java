package faang.school.godbless.bjs2_4226;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Aragorn");
        Character archer = new Archer("Legolaz");

        System.out.println("Archer attacks warrior");
        archer.attack(warrior);
        System.out.println("Warrior health after archer's attack: " + warrior.getHealth());
        System.out.println("Warrior attacks archer");
        warrior.attack(archer);
        System.out.println("Archer health after warrior's attack: " + archer.getHealth());
    }
}
