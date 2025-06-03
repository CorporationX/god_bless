package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User Andrey = new User("Andrey", 20, "Sber", "st.Pushkina");
        User Vasiliy = new User("Vasiliy", 28, "VTB", "prt.Pobedy");
        User Igor = new User("Igor", 20, "Sber", "Pushkina");
        User Aleksey = new User("Aleksey", 26, "Sber", "Pushkina");
        User Misha = new User("Misha", 20, "Sber", "Pushkina");
        User Darya = new User("Darya", 26, "Sber", "Pushkina");
        User Danil = new User("Danil", 28, "Sber", "Pushkina");

        List<User> users = List.of(Andrey, Vasiliy, Igor, Aleksey, Misha, Danil, Danil);
        User.groupUsers(users);
    }

}
