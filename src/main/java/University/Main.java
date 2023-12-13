package University;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Main.addStudent(new Student("Peter", "Math", 1));
        Main.addStudent(new Student("Paul", "Program", 2));
        Main.addStudent(new Student("Ann", "Math", 2));
        Main.addStudent(new Student("Tom", "Physic", 4));
        Main.addStudent(new Student("Fedor", "Math", 1));
        Main.addStudent(new Student("Peter", "Program", 3));
        Main.addStudent(new Student("Lisa", "Physic", 2));
        Main.addStudent(new Student("Tom", "Law", 4));

        //Отобразим всех по группам
        Main.showAllStudentsSortedByFacultyAndYear();

        //Удалить разными способами
        Main.removeStudentByName("Lisa");
        System.out.println("After remove Lisa" + students);

        Main.removeStudentByFaculty("Law");
        System.out.println("After remove Law" + students);

        Main.removeStudentByYear(3);
        System.out.println("After remove year 3" + students);

        //Разгруппируем по факультетам
        System.out.println(Main.findStudentByFacultyAndYear("Math", 2));

    }

    //Добавить список студентов в HashMap с ключом UniversityCourse (направление и год)
    public static Map<Map.Entry<String, Integer>, List<Student>> assignStudentsToCourses(List<Student> students) {
        //Создаем временные переменные
        Map<Map.Entry<String, Integer>, List<Student>> assignedStudents = new HashMap<>();
        List<Student> tempList;
        Map.Entry<String, Integer> tempCourse;

        for (Student student : students) {
            tempCourse = new AbstractMap.SimpleEntry<>(student.getFaculty(), student.getYear());
            tempList = assignedStudents.getOrDefault(tempCourse, new ArrayList<>());
            tempList.add(student);

            assignedStudents.put(tempCourse, tempList);
        }

        return assignedStudents;
    }

    //Добавление студента в список
    public static void addStudent(Student student) {
        students.add(student);
    }

    //удаление студента по имени
    public static void removeStudentByName(String name) {
        //Список найденных студентов с таким именем
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().equals(name)) {
                foundStudents.add(student);
            }
        }

        if (foundStudents.isEmpty()) {
            System.out.println("Не найдено");
            return;
        }

        //Если нашли только одного - удаляем
        if (foundStudents.size() == 1) {
            students.remove(foundStudents.get(0));
        } else {
            //Иначе выводим найденных на экран, спрашиваем кого именно удалить
            for (Student student : foundStudents) {
                System.out.println(student.toString());

            }
            System.out.println("Выберите кого удалить");
        }
    }

    //удаление студентов по факультету (аналогично удалению по имени)
    public static void removeStudentByFaculty(String faculty) {
        //Список найденных студентов с таким факультетом
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                foundStudents.add(student);
            }
        }

        if (foundStudents.isEmpty()) {
            System.out.println("Не найдено");
            return;
        }

        //Если нашли только одного - удаляем
        if (foundStudents.size() == 1) {
            students.remove(foundStudents.get(0));
        } else {
            //Иначе выводим найденных на экран, спрашиваем кого именно удалить
            for (Student student : foundStudents) {
                System.out.println(student.toString());

            }
            System.out.println("Выберите кого удалить");
        }
    }

    //Удаление студентов по курсу/году
    public static void removeStudentByYear(int year) {
        //Список найденных студентов с таким факультетом
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getYear() == year) {
                foundStudents.add(student);
            }
        }

        if (foundStudents.isEmpty()) {
            System.out.println("Не найдено");
            return;
        }

        //Если нашли только одного - удаляем
        if (foundStudents.size() == 1) {
            students.remove(foundStudents.get(0));
        } else {
            //Иначе выводим найденных на экран, спрашиваем кого именно удалить
            for (Student student : foundStudents) {
                System.out.println(student.toString());

            }
            System.out.println("Выберите кого удалить");
        }
    }

    //поиск студентов определенного факультета и курса
    public static List<Student> findStudentByFacultyAndYear(String faculty, int year) {
        List<Student> foundedStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                foundedStudents.add(student);
            }
        }
        return foundedStudents;
    }

    //вывести всех студентов, разгруппированных по факультетам и курсам
    public static void showAllStudentsSortedByFacultyAndYear() {
        //создадим мапу со студентами, распределенными по курсам
        Map<Map.Entry<String, Integer>, List<Student>> assignedStudents = Main.assignStudentsToCourses(students);

        assignedStudents.forEach((course, studentList) -> {
            System.out.println(course);
            System.out.println(studentList);
        });
    }

}

