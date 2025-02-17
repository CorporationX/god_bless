package school.faang.HeroesOfMightAndMagic;

public class Main {
    public static void main(String[] args) {
        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(30));
        System.out.println("Мощность отряда лучников: " + archers.calculateSquadPower());

        Squad mages = new Squad();
        mages.addUnit(new Mage(45));
        mages.addUnit(new Mage(48));
        System.out.println("Мощность отряда магов: " + mages.calculateSquadPower());

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(40));
        swordsmen.addUnit(new Swordsman(35));
        System.out.println("Мощность отряда мечников: " + swordsmen.calculateSquadPower());


        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}