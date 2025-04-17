package school.faang.rpg;

public class Test {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Adolf");
        Archer archer = new Archer("Eva");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
