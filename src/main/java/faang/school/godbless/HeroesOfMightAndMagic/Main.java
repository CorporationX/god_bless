package faang.school.godbless.HeroesOfMightAndMagic;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Army.addUnit(new Archer(100));
        Army.addUnit(new Swordsman(50));
        Army.addUnit(new Mage(20));
        Army.addUnit(new Mage(40));

        int totalPower = Army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
