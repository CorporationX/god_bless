package school.faang.task_43908;

public class Main {
    public static void main(String[] args) {

        Warrior orc = new Warrior("Uruk-hai");
        Archer elf = new Archer("Legolas");

        orc.attack(elf);
        elf.attack(orc);

    }
}
