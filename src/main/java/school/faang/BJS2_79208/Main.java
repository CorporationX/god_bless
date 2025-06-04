package school.faang.BJS2_79208;

public class Main {
    public static void main(String[] args) {

        User andrey = new User("Andrey", 25, "Uber", "London");

        System.out.println("Имя пользователя - " + andrey.getName() + "\n"
                + "Возраст пользователя - " + andrey.getAge() + " лет" + "\n"
                + "Место работы пользователя - " + andrey.getJob() + "\n"
                + "Адрес пользователя - " + andrey.getAddress());

        User dasha = new User("Dasha ", 24, "Amazon", "Orenburg");
    }
}
