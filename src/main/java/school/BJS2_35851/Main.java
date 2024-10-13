package school.BJS2_35851;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addCharacter(new Archer(25));   // считаем в потоке 1
        army.addCharacter(new Swordsman(40)); // считаем в потоке 2
        army.addCharacter(new Mage(50));     // считаем в потоке 3
        army.addCharacter(new Mage(20));     // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}