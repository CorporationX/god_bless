package faang.school.godbless.Mathew;

public class Main {
    public static void main(String[] args) {
        Character warior = new Warior("Waluev");
        Character archer = new Archer("Joe");
        warior.attack(archer);
        System.out.println(archer);
        archer.attack(warior);
        System.out.println(warior);
    }
}
