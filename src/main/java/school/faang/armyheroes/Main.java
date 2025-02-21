package school.faang.armyheroes;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad<Archer> archers = new Squad<>();
        archers.addHeroes(new Archer("Arch"));
        archers.addHeroes(new Archer("Arch2"));

        Squad<Swordsman> swordsmen = new Squad<>();
        swordsmen.addHeroes(new Swordsman("RealMen"));
        swordsmen.addHeroes(new Swordsman("RealMen2"));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }

}
