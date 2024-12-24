package school.faang.sprint3.bjs248085;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        army.addWarrior(Archer.builder().power(25).build());
        army.addWarrior(Swordsman.builder().power(35).build());
        army.addWarrior(Swordsman.builder().power(40).build());
        army.addWarrior(Mage.builder().power(50).build());
        army.addWarrior(Mage.builder().power(100).build());

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила воинов в армии: " + totalPower);
    }
}