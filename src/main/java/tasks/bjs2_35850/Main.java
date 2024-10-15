package tasks.bjs2_35850;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        army.addCharacter(new Archer(52));
        army.addCharacter(new Warrior(25));
        army.addCharacter(new Mage(22));
        army.addCharacter(new Swordsman(33));
        System.out.println("Общая сила бойцов : " + army.calculateTotalPower());
    }
}
