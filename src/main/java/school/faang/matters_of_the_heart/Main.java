package school.faang.matters_of_the_heart;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> messagesList = messages();

        UserList userList = new UserList();
        userList.addUser(new User("Sam"));
        userList.addUser(new User("Bob"));
        userList.addUser(new User("Garry"));
        userList.addUser(new User("Germiona"));
        userList.addUser(new User("Jinny"));
        userList.addUser(new User("Ron"));
    }

    public static List<String> messages() {
        return List.of("Привет", "Как дела?", "что делаешь?", "окей", ":)",
                "хД", ";)", ":(", "няшка", "печалька",
                "тролль", "добрый день", "всем привет", "сколько лет", "где учишься ?", "как настроение ?",
                "Кто откуда ?", "Давай, познакомимся ?");
    }
}
