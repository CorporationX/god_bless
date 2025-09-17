package bjs2_91259;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Лучники
        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(30));

        // Мечники
        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(40));
        swordsmen.addUnit(new Swordsman(35));

        // Маги
        Squad mages = new Squad();
        mages.addUnit(new Mage(50));
        mages.addUnit(new Mage(45));

        // Добавляем в армию
        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        // Вычисляем общую силу
        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}