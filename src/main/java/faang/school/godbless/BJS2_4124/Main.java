package faang.school.godbless.BJS2_4124;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        warrior.attack(archer);
        System.out.println("Здоровье Archer после атаки: " + archer.health);

        archer.attack(warrior);
        System.out.println("Здоровье Warrior после атаки: " + warrior.health);
    }
}
