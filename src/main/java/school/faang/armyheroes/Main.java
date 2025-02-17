package school.faang.armyheroes;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //не понимаю что ему не нравится, так же один раз вышла ошибка uncheced operations
        Squad archers = new Squad();
        archers.addHeroes(new Archer("Arch"));
        archers.addHeroes(new Archer("Arch2"));

        Squad swordsmen = new Squad();
        swordsmen.addHeroes(new Swordsman("RealMen"));
        swordsmen.addHeroes(new Swordsman("RealMen2"));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }

}
