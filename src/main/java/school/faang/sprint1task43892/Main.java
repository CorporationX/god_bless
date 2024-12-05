package school.faang.sprint1task43892;

public class Main {

    public static void main(String[] args) {
        Character warrior = new Warrior("Dragon");
        Character archer = new Archer("Elephant");
        warrior.attack(archer);
        archer.attack(warrior);
    }

}
