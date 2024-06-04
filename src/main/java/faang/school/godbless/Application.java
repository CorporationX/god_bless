package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Gimly");
        Archer archer = new Archer("Legolas");
        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
    }
}