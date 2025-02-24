package school.faang.sprint1.task43844abstract;

public class Main {
    public static void main(String[] args) {
        Character warrior1 = new Warrior("Axe");
        Character archer1 = new Archer("Wind Ranger");
        archer1.attack(warrior1);
        warrior1.attack(warrior1);
        System.out.println(archer1.health);
        System.out.println(warrior1.health);

    }
}
