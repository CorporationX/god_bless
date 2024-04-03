package faang.school.godbless.javaCore.userRegistration;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("Попытка создать пользователя: User(name=, age=22, job=programmer, address=Somewhere street 21)");
            User user1 = new User("", 22, "programmer", "Somewhere street 21");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try{
            System.out.println("Попытка создать пользователя: User(name=null, age=22, job=programmer, address=Somewhere street 21)");
            User user1 = new User(null, 22, "programmer", "Somewhere street 21");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try{
            System.out.println("Попытка создать пользователя: User(name=Oleg, age=17, job=programmer, address=Somewhere street 21)");
            User user1 = new User("Oleg", 17, "programmer", "Somewhere street 21");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try{
            System.out.println("Попытка создать пользователя: User(name=Oleg, age=22, job=programmer, address=Somewhere street 21)");
            User user1 = new User("Oleg", 22, "programmer", "Somewhere street 21");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try{
            System.out.println("Попытка создать пользователя: User(name=Oleg, age=22, job=Amazon, address=Somewhere street 21)");
            User user1 = new User("Oleg", 22, "Amazon", "Somewhere street 21");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try{
            System.out.println("Попытка создать пользователя: User(name=Oleg, age=22, job=Amazon, address=Amsterdam)");
            User user1 = new User("Oleg", 22, "Amazon", "Amsterdam");

            System.out.println("Пользователь успешно создан!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}
