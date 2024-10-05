package Abstraction_BJS2_31397;

public class Main {
 public static void main(String[] args) {
     Warrior warrior = new Warrior("Konan");
     Archer archer = new Archer("Robinhood");

     warrior.attack(archer);
     archer.attack(warrior);

    }
}
