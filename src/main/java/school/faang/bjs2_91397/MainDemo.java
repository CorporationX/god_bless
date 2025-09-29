package school.faang.bjs2_91397;

public class MainDemo {
    public static void main(String[] args) {
        Squad<Archer> archers = new Squad<>("Лучники");
        archers.addFighter(new Archer(25));
        archers.addFighter(new Archer(30));

        Squad<Swordsman> swordsman = new Squad<>("Мечники");
        swordsman.addFighter(new Swordsman(40));
        swordsman.addFighter(new Swordsman(35));

        Squad<Mage> mages = new Squad<>("Маги");
        mages.addFighter(new Mage(50));
        mages.addFighter(new Mage(45));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsman);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();

        System.out.println("Общая сила армии: " + totalPower);
    }
}
