package faang.school.godbless.abstraction;

public class Application {
    public static void main(String... args) {
        Character war = new Warrior("Jeka");
        Character arch = new Archer("Jarik");
        System.out.println(war);
        System.out.println(arch);
        war.attack(arch);
        arch.attack(war);
        war.attack(arch);
        System.out.println(war);
        System.out.println(arch);
    }
}
