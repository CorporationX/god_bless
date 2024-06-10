package faang.school.godbless.count_absences;

import java.util.ArrayList;
import java.util.HashMap;

public record Student(String name, String faculty, int year) {
    public HashMap<Key, ArrayList<Student>> groupStudentsByFacultyAndYear(
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
}
