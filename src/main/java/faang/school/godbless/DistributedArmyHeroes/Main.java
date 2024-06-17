package faang.school.godbless.DistributedArmyHeroes;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addCharacter(new Archer(23));
        army.addCharacter(new Swordsman(44));
        army.addCharacter(new Swordsman(20));
        army.addCharacter(new Mage(25));

        int sumPower = army.calculateTotalPower();
        System.out.println("Общая сила - " + sumPower);
    }
}
