package school.faang;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Dragon Knight");
        Archer archer = new Archer("Wind Ranger");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(archer.getHealth());
        System.out.println(warrior.getHealth());
    }
}

