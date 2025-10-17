package school.faang.bjs2_85525;

public class BattleDemo {
    public static void main(String[] args) {
        Warrior conan = new Warrior("Conan");
        Archer robin = new Archer("Robin");

        System.out.println("Начало боя. Здоровье Conan = " + conan.getHealth()
                + ", Robin = " + robin.getHealth());

        conan.attack(robin);
        System.out.println("Здоровье Robin, после 1 удара Conan: "
                + robin.getHealth());

        robin.attack(conan);
        System.out.println("Здоровье Conan, после 1 удара Robin: "
                + conan.getHealth());
    }
}
