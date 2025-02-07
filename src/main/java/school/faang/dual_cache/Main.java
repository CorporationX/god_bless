package school.faang.dual_cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        final int maxStudentsNumber = 10;

        Random random = new Random();

        var arrStudentNames = new String[] {"Igor", "Pavel", "Maxim", "Ignat", "Egor", "Yuriy",
                "Vladimir", "Valeriy", "Gorg", "Vitaliy", "Anastasia", "Anna", "Lida", "Mary"};

        var arrSubjects = new String[] {"Mathematics", "Physics", "Programming", "Biology",
                "Chemistry", "AI", "Politics", "Computer science", "Linguistics", "Statistics"};

        var lstStudents = new ArrayList<Student>();
        var lstSubjects = new ArrayList<Subject>();

        // Намеренно могут встречаться одинаковые студенты для проверки добавления в Map
        for (int i = 0; i < maxStudentsNumber; i++) {

            lstStudents.add(new Student(arrStudentNames[random.nextInt(0, arrStudentNames.length)]));
        }

        for (int i = 0; i < arrSubjects.length; i++) {

            lstSubjects.add(new Subject(arrSubjects[i]));
        }

        StudentDatabase studentDatabase = new StudentDatabase();

        // Наборы предметов с оценками для каждого студента
        var lstMaps = new ArrayList<HashMap<Subject, Integer>>();

        for (int i = 0; i < lstStudents.size(); i++) {

            var grades = new HashMap<Subject, Integer>();

            for (int j = 0; j < random.nextInt(3, lstSubjects.size()); j++) {

                grades.put(lstSubjects.get(random.nextInt(0, lstSubjects.size())),
                        random.nextInt(1, 10 + 1));
            }

            lstMaps.add(grades);
        }

        for (int i = 0; i < lstStudents.size(); i++) {

            studentDatabase.addNewStudentWithGrades(lstStudents.get(i), lstMaps.get(i));
        }

        studentDatabase.printAllStudentsWithSubjectsAndGrades();
        System.out.println("******************");
        studentDatabase.printAllSubjectsWithStudents();
    }
}

/*
public class Main {
    public static void main(String[] args) {
        String[] arrStudentNames = {"Alice", "Bob", "Charlie", "David", "Eve"};
        int naxStudentsNumber = 10;
        Random random = new Random();

        List<Student> lstStudents = IntStream.range(0, naxStudentsNumber)
                .mapToObj(i -> new Student(arrStudentNames[random.nextInt(arrStudentNames.length)]))
                .collect(Collectors.toList());

        // Вывод списка студентов для проверки
        lstStudents.forEach(student -> System.out.println(student.getName()));
    }
}
*/

