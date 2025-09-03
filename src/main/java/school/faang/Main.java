package school.faang;

public class Main {

    public static void main(String[] args) {

        Warrior warrior = new Warrior("Громила");
        Archer archer = new Archer("Меткий глаз");

        warrior.attack(archer);
        archer.attack(warrior);
        archer.attack(warrior);

    }

}
