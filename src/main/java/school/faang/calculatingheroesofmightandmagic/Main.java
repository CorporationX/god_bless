package school.faang.calculatingheroesofmightandmagic;

public class Main {
    public static void main(String[] args) {
        Army<Hero> army = new Army<>();


        army.addHeroToList(new Archer(25));
        army.addHeroToList(new Swordsman(40));
        army.addHeroToList(new Mage(50));
        army.addHeroToList(new Mage(20));
        army.addHeroToList(new Swordsman(30));
        army.addHeroToList(new Swordsman(15));
        army.addHeroToList(new Swordsman(25));


        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}