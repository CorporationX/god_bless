package abstractionAbstraction;

public class Main {
    public static void main(String[] args) {
        Warrior w = new Warrior("Дамский угодник 217");
        Archer a = new Archer("Джарвис");
        w.attack(a);
        System.out.println(a.getHealth());
        a.attack(w);
        System.out.println(w.getHealth());
    }
}
