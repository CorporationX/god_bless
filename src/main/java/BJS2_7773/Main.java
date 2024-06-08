package BJS2_7773;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);

        System.out.println(warrior.getName() +" "+warrior.health);
        System.out.println(archer.getName() +" "+archer.health);
    }
}
