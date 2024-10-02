package school.faang.usersgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        List<Users> students = List.of(
        new Users("Den", 22, "Amazon", "Manshen street"),
        new Users("Ben", 23, "Sber", "Lenin street"),
        new Users("Ivan", 21, "Okko", "Degin street"),
        new Users("Petr", 18, "Uber", "Mira street"),
        new Users("Nadia", 26, "Diksi", "Akademik street"),
        new Users("Masha", 17, "Mebel", "Korolev street"),
        new Users("Daria", 17, "Google", "Baiker street"),
        new Users("Саша", 26, "EPAM", "Gorki street"));

        Map<Integer, ArrayList<Users>> studentsHasMap = Users.groupUsers(students);
        for (Map.Entry<Integer, ArrayList<Users>> student : studentsHasMap.entrySet()) {
            System.out.println("Ключ " + student.getKey() + " Значение: " + student.getValue());
        }
    }

}
