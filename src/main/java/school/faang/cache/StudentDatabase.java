package school.faang.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentDatabase {
    // Карта, где ключ - студент, значение - карта его предметов с оценками
    private Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();

    // Карта, где ключ - предмет, значение - список студентов, изучающих этот предмет
    private Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudent(String name, Map<Subject, Integer> subjects) {
        // Создаем новый объект студента с переданным именем
        Student student = new Student(name);

        // Добавляем студента и его предметы в карту studentSubjects
        studentSubjects.put(student, subjects);

        // Проходим по всем предметам студента
        for (Subject subject : subjects.keySet()) {
            // Если предмета еще нет в карте subjectStudents, создаем для него пустой список
            subjectStudents.putIfAbsent(subject, new ArrayList<>());

            // Добавляем студента в список студентов, изучающих данный предмет
            subjectStudents.get(subject).add(student);
        }
    }

    public void addSubjects(String nameStudent, String nameSubjects, int grade) {
        // Создаем новый объект предмета с переданным названием
        Subject subject = new Subject(nameSubjects);

        // Если студента с таким именем еще нет в карте, создаем для него пустую карту предметов
        studentSubjects.putIfAbsent(new Student(nameStudent), new HashMap<>());

        // Проходим по всем записям в карте studentSubjects
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()) {
            // Получаем студента из текущей записи
            Student student = entry.getKey();

            // Проверяем, совпадает ли имя студента с искомым именем
            if (student.getName().equals(nameStudent)) {
                // Добавляем новый предмет с оценкой в карту предметов студента
                entry.getValue().put(subject, grade);
            }
        }
    }
}

