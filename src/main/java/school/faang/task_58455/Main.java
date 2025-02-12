package school.faang.task_58455;

public class Main {
    public static void main(String[] args) {
        Warrior orc = new Warrior("Орк");
        Archer elf = new Archer("Эльф");

        orc.attack(elf);
        elf.attack(orc);

        orc.setStrength(100);
        orc.attack(elf);
    }
}
