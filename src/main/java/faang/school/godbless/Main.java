package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        Warior warior = new Warior("War");
        Archer archer = new Archer("Arch");

        System.out.println(warior.getName() + " = " + warior.getHealth());
        System.out.println(archer.getName() + " = " + archer.getHealth());

        warior.attack(archer);
        archer.attack(warior);

        System.out.println(warior.getName() + " = " + warior.getHealth());
        System.out.println(archer.getName() + " = " + archer.getHealth());
    }
}
