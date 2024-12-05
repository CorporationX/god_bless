package school.faang.bjs243816;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Bulbo");
        Archer archer = new Archer("Lagovaz");

        System.out.println(warrior.getName() + "'s health:" + warrior.getHealth());
        System.out.println(archer.getName() + "'s health:" + archer.getHealth());

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior.getName() + "'s health:" + warrior.getHealth());
        System.out.println(archer.getName() + "'s health:" + archer.getHealth());
    }
}
