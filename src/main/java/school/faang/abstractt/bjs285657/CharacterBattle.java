package school.faang.abstractt.bjs285657;


public class CharacterBattle {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        System.out.println(warrior);
        archer.attack(warrior);
        System.out.println(warrior);

        while (warrior.getHealth() > 0 && archer.getHealth() > 0) {
            archer.attack(warrior);
            System.out.println(warrior);
            warrior.attack(archer);
            System.out.println(archer);
        }

        if (warrior.getHealth() <= 0 && archer.getHealth() <= 0) {
            System.out.println("draw no one won");
        } else if (warrior.getHealth() <= 0) {
            System.out.printf("%s Win", archer.getName());
        } else if (archer.getHealth() <= 0) {
            System.out.printf("%s Win", warrior.getName());
        }
    }



}
