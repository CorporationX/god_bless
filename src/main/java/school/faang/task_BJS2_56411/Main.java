package school.faang.task_BJS2_56411;

public class Main {

    public static void main(String[] args) {
        Warrior anton = new Warrior("Anton");
        System.out.println(anton);
        Warrior petr = new Warrior("Petr", 200, 20, 20);
        anton.getDamage(petr);
        System.out.println(anton);

        System.out.println("==================================");

        Archer vova = new Archer("Vova");
        System.out.println(vova);
        Archer vasya = new Archer("Vasya", 20, 200, 20);
        vova.getDamage(vasya);
        System.out.println(vova);
    }
}