package faang.school.godbless.TaskBJS2_4294;

public class Main {
    public static void main(String[] args) {
        try {
            RegistrationtUser user1 = new RegistrationtUser("Ivan", 18, "Pyaterochka", "London");
            RegistrationtUser user2 = new RegistrationtUser("Yan", 16, "Uber", "Amsterdam");
            RegistrationtUser user3 = new RegistrationtUser("Anna", 20, "Google", "London");

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
        } catch (IllegalAccessError e) {
            System.out.println("Возникла ошибка: " + e.getMessage());
        }


    }
}
