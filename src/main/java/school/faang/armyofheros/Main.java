package school.faang.armyofheros;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addCharacter(new Man(25));
        army.addCharacter(new Swordsman(40));
        army.addCharacter(new Mage(50));
        army.addCharacter(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);

    }
}
