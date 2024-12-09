package school.faang.sprint_1.task_43946;

public class Main {
    public static void main(String[] args) {
        Character ork = new Warrior("Ork");
        Character elf = new Archer("Elf");

        ork.attack(elf);
        elf.attack(ork);

        System.out.println(ork.getHealth());
        System.out.println(elf.getHealth());
    }
}
