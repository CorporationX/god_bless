package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Воин ");
        Archer archer = new Archer("Лучник ");
        System.out.println("До атаки");
        System.out.println("Warrior: " + warrior.health);
        System.out.println("Archer: " + archer.health);

        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("После атаки");
        System.out.println("Warrior: " + warrior.health);
        System.out.println("Archer: " + archer.health);


    }
}
