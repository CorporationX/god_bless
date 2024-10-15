package school.faang.multithreading.mightandmagic;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addWarrior(new Archer(25));
        army.addWarrior(new Swordsman(40));
        army.addWarrior(new Mage(50));
        army.addWarrior(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
