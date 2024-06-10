package faang.school.godbless.count_absences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public record Student(String name, String faculty, int year) {
    public static HashMap<Key, ArrayList<Student>> groupStudentsByFacultyAndYear(
            ArrayList<Student> students) {
        HashMap<Key, ArrayList<Student>> studentsGroupedByFacultyAndYear = new HashMap<>();
        //создаём списки студентов сгруппированных по факультету и году
        for (Student student : students) {
            //формируем составной ключ
            Key keyByFacultyAndYear = new Key(student.faculty(), student.year());
            ArrayList<Student> studentsGrouped;
            //проверяем существование составного ключа в ХэшМапе
            if (!studentsGroupedByFacultyAndYear.containsKey(keyByFacultyAndYear)) {
                //создаём список сгруппированных студентов
                studentsGrouped = new ArrayList<>();
                studentsGrouped.add(student);//добавляем студента в список
                //добавляем запись в ХэшМапу
                studentsGroupedByFacultyAndYear.put(keyByFacultyAndYear, studentsGrouped);
            } else {
                studentsGrouped = studentsGroupedByFacultyAndYear.get(keyByFacultyAndYear);
                studentsGrouped.add(student);
                studentsGroupedByFacultyAndYear.put(keyByFacultyAndYear, studentsGrouped);
            }
        }
        return studentsGroupedByFacultyAndYear;
    }

    //добавление нового студента в список
    public void addStudentToList(Student student, ArrayList<Student> students) {
        if (students.contains(student)) {
            System.out.println("Такой студент уже есть в списке!");
        } else {
            students.add(student);
        }
    }

    //удаление студента из списка по его имени, факультету и курсу
    public void deleteStudent(String name, String faculty, int year, ArrayList<Student> students) {
        //создаём нового студента
        Student student = new Student(name, faculty, year);
        if (!students.contains(student)) {
            System.out.println("Такого студента нет в списке!");
        } else {
            students.remove(student);
        }
    }

    //поиск всех студентов определённого факультета и курса
    public static List<Student> findStudentsByFacultyAndYear(String faculty,
                                                      int year,
                                                      HashMap<Key, ArrayList<Student>> sortedStudents) {

        List<Student> students = new ArrayList<>();
        //создаём ключ для поиска в ХэшМапе
        Key keyOfMap = new Key(faculty, year);
        //находим список студентов
        System.out.println(sortedStudents.get(keyOfMap));
        return students;
    }
}
