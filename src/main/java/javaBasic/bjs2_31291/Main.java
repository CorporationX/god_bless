package javaBasic.bjs2_31291;

public class Main {
    public static void main(String[] args) {

        Warrior wari = new Warrior("Вари");
        Character asya = new Archer("Ася");

        wari.attack(asya);
        System.out.println(asya.getName() + " здоровье: " + asya.getHealth());

        asya.attack(wari);
        System.out.println(wari.getName() + " здоровье: " + wari.getHealth());
    }
}


