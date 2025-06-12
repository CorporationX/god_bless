package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User andrey = new User("Andrey", 20, "Sber", "st.Pushkina");
        User vasiliy = new User("Vasiliy", 28, "VTB", "prt.Pobedy");
        User igor = new User("Igor", 20, "Sber", "Pushkina");
        User aleksey = new User("Aleksey", 26, "Sber", "Pushkina");
        User misha = new User("Misha", 20, "Sber", "Pushkina");
        User darya = new User("Darya", 26, "Sber", "Pushkina");
        User danil = new User("Danil", 28, "Sber", "Pushkina");

        List<User> users = List.of(andrey, vasiliy, igor, aleksey, misha, darya, danil);
        System.out.println(User.groupUsers(users));
    }
}
