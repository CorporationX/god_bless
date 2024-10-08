package abstractiontask;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior.health);
        System.out.println(archer.health);
    }
}
