package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character qwe = new Warrior("senja");
        Character zxc = new Archer("monstar");
        System.out.println(zxc.getHealth());
        System.out.println("ныыыа");
        qwe.attack(zxc);
        System.out.println(zxc.getHealth());
    }
}
