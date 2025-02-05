package school.faang.abstraction;

public class Main {

    public static void main(String[] args) {

        final Character war1 = new Warrior("War1");
        final Character war2 = new Warrior("War2");
        Character war3 = new Warrior("War3");
        war3.setStrength(10);
        war3.setAgility(11);
        war3.setIntellect(12);
        System.out.printf("War3, strength = %d, agility = %d, intellect = %d\n", war3.getStrength(),
                                                                              war3.getAgility(),
                                                                              war3.getIntellect());

        System.out.printf("War1 health before attack: %d\n", war1.getHealth());

        for (int i = 0; i <= 10; i++) {

            try {
                war2.attack(war1);
            } catch (IllegalArgumentException ex) {

                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("War1 health after attack: %d\n", war1.getHealth());

        //*********************************************************************
        final Character arch1 = new Archer("Arch1");
        final Character arch2 = new Archer("Arch2");
        Character arch3 = new Archer("Arch3");
        arch3.setStrength(20);
        arch3.setAgility(21);
        arch3.setIntellect(22);
        System.out.printf("Arch3, strength = %d, agility = %d, intellect = %d\n", arch3.getStrength(),
                                                                                  arch3.getAgility(),
                                                                                  arch3.getIntellect());

        System.out.printf("Arch1 health before attack: %d\n", arch1.getHealth());

        for (int i = 0; i <= 10; i++) {

            try {

                arch2.attack(arch1);
            } catch (IllegalArgumentException ex) {

                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("Arch1 health after attack: %d\n", arch1.getHealth());
    }
}
