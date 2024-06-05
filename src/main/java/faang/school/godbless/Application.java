package faang.school.godbless;



public class Application {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Воин");
        Archer archer = new Archer("Лучник");




        while (warrior.getHealthPoints() > 0 && archer.getHealthPoints() > 0) {
            warrior.attack(archer);
            archer.attack(warrior);
            System.out.println("Здоровье " + warrior.getName() + ": " + warrior.getHealthPoints());
            System.out.println("Здоровье " + archer.getName() + ": " + archer.getHealthPoints());
        }

    }
}