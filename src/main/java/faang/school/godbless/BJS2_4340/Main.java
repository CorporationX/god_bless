package faang.school.godbless.BJS2_4340;

public class Main {
    public static void main(String[] args){
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        printBattleInformation(warrior, archer);
        System.out.println("=".repeat(20) + " Атака " + "=".repeat(20) + "\n");

        warrior.attack(archer);
        archer.attack(warrior);

        printBattleInformation(warrior, archer);
    }

    public static void printBattleInformation(Warrior warrior, Archer archer){
        System.out.println("Здоровье " + archer.name +": " + archer.health +
                "\nЗдоровье " + warrior.name + ": " + warrior.health + "\n");
    }
}
