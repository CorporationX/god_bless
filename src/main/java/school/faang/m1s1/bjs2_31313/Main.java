package school.faang.m1s1.bjs2_31313;

public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior("Gimli");
        System.out.printf("Warrior stats: str %d, agi %d, int %d, hp %d\n", warrior.getStrength(),
                warrior.getAgility(), warrior.getIntelligence(), warrior.getHp());

        Character archer = new Archer("Legolas");
        System.out.printf("Archer stats: str %d, agi %d, int %d, hp %d\n", archer.getStrength(),
                archer.getAgility(), archer.getIntelligence(), archer.getHp());

        warrior.attack(archer);
        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(archer.getHp());
        System.out.println(warrior.getHp());

    }
}
