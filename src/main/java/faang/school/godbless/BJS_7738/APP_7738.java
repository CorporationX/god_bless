package faang.school.godbless.BJS_7738;

public class APP_7738 {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Gimly");
        Archer archer = new Archer("Legolas");
        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
    }
}