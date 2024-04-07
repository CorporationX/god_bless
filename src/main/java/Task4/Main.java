package Task4;
public class Main {
    public static void main(String[] args) {
        Warrior soldier1 = new Warrior("Nikita");
        Archer soldier2 = new Archer("Maxim");

        System.out.println(soldier1.getHealth());
        soldier2.attack(soldier1);
        System.out.println(soldier1.getHealth());
        soldier1.attack(soldier2);
        System.out.println(soldier2.getHealth());
    }
}
