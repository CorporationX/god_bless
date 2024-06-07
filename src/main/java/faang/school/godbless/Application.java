package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Warrior Ivan = new Warrior("Ivan");
        Archer Oleg = new Archer("Oleg");

        Ivan.atack(Oleg);
        Oleg.atack(Ivan);
    }
}