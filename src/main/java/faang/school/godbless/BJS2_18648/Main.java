package faang.school.godbless.BJS2_18648;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Pudge");
        Character archer = new Archer("Lovelas");

        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
