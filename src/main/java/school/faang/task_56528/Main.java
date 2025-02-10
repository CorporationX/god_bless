package school.faang.task_56528;

public class Main {
    public static void main(String[] args) {
        Warrior warden = new Warrior("Warden");
        Archer windranger = new Archer("Windranger");

        System.out.println(windranger);
        warden.attack(windranger);
        System.out.println(windranger);
    }
}
