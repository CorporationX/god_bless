package faang.school.godbless.bjs218608;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Jon Snow");
        Character archer = new Archer("Theon Greyjoy");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
