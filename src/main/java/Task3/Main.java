package Task3;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Sam");
        Character archer = new Archer("Tom");
        warrior.attack(archer);
        System.out.println(archer);
        archer.attack(warrior);
        System.out.println(warrior);
    }
}
