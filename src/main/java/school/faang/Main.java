package school.faang;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Abzalkhan");
        Archer archer = new Archer("Olzhas");
        warrior.attack(archer);
        warrior.attack(archer);
        warrior.attack(archer);
        System.out.println(archer.getHealth());
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println(warrior.getHealth());
    }
}
