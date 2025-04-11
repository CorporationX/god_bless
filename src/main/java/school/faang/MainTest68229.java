package school.faang;

public class MainTest68229 {

    public static void main(String[] args) {
        Warrior firstWarrior = new Warrior("Zdorovyak");
        Warrior secondWarrior = new Warrior("Gromila");
        Archer firstArcher = new Archer("Elf");

        firstWarrior.attack(secondWarrior);
        firstArcher.attack(secondWarrior);
        secondWarrior.attack(firstWarrior);

        System.out.println(firstArcher.getHealth());
        System.out.println(firstWarrior.getHealth());
        System.out.println(secondWarrior.getHealth());

    }

}
