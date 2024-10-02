package school.faang.usersgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        List<Users> students = new ArrayList<>();
        students.add(new Users("Den", 22, "Amazon", "Manshen street"));
        students.add(new Users("Ben", 23, "Sber", "Lenin street"));
        students.add(new Users("Ivan", 21, "Okko", "Degin street"));
        students.add(new Users("Petr", 18, "Uber", "Mira street"));
        students.add(new Users("Nadia", 26, "Diksi", "Akademik street"));
        students.add(new Users("Masha", 17, "Mebel", "Korolev street"));
        students.add(new Users("Daria", 17, "Google", "Baiker street"));
        students.add(new Users("Саша", 26, "EPAM", "Gorki street"));

        Map<Integer, ArrayList<Users>> studentsHasMap = Users.groupUsers(students);
        for (Map.Entry<Integer, ArrayList<Users>> student : studentsHasMap.entrySet()) {
            System.out.println("Ключ " + student.getKey() + " Значение: " + student.getValue());
        }
    }

}
