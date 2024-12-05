package ru.task_43860;

public class Main {
    public static void main(String[] args) {
        Warrior knight = new Warrior();
        Archer samurai = new Archer();

        int result = knight.attack(samurai);
        System.out.println("Результат атаки " + result);
    }

}
