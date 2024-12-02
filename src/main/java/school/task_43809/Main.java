package school.task_43809;

public class Main {
    public static void main(String[] args) {
        Archer ork = new Archer("Ork");
        Archer demon = new Archer("Demon");
        ork.attack(demon);
        ork.attack(demon);
        ork.attack(demon);
        System.out.println("After attack Demon is " + demon);

        Warrior dualist = new Warrior("Dualist");
        Warrior elf = new Warrior("Elf");
        dualist.attack(elf);
        dualist.attack(elf);
        System.out.println("After attack Elf is " + elf);
    }
}
