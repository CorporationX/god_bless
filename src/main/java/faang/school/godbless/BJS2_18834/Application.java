package faang.school.godbless.BJS2_18834;

public class Application {
    public static void main(String[] args) {
        var archer = new Archer("Alan");
        var warrior = new Warrior("Nick");

        warrior.attack(archer);
        warrior.attack(archer);
        warrior.attack(archer);

        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
    }
}