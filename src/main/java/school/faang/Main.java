package school.faang;

public class Main {
    public static void main(String[] args) {

        User Andrey = new User("Andrey", 25, "Uber", "London");

        System.out.println("Имя пользователя - " + Andrey.getName() + "\n"
                            + "Возраст пользователя - " + Andrey.getAge() + " лет" + "\n"
                            + "Место работы пользователя - " + Andrey.getJob() + "\n"
                            + "Адрес пользователя - " + Andrey.getAddress());

        User Dasha = new User("Dasha", 24, "Amazon", "Moscow");
    }
}
