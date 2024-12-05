package school.faang.Sprint1.task_43956;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Student> studentsMagazine = new ArrayList<>();
        studentsMagazine.add(new Student("Garry", "Griffindor", 14));
        studentsMagazine.add(new Student("Ron", "Griffindor", 14));
        studentsMagazine.add(new Student("Germiona", "Griffindor", 14));
        studentsMagazine.add(new Student("Draco", "Slizerin", 15));
        studentsMagazine.add(new Student("Krap", "Slizerin", 15));
        studentsMagazine.add(new Student("Goil", "Slizerin", 15));
        studentsMagazine.add(new Student("Sedrik", "Puffenduy", 16));
        studentsMagazine.add(new Student("Plumna", "Kogtevran", 17));
        Map<Integer, List<Student>> groupedStudents = Student.groupStudents(studentsMagazine);
        String result = groupedStudents.toString();
        System.out.println(result);


    }
}

