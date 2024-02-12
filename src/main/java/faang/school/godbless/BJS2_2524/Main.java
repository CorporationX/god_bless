package faang.school.godbless.BJS2_2524;

public class Main {
    public static void main(String[] args) {
        var warrior = new Warrior("Bob");
        var archer = new Archer("Sam");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior);
        System.out.println(archer);
    }
}
