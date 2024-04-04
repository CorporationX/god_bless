package faang.school.godbless.college;

import java.util.*;

public class StudentJournal {
    private HashMap<Group, List<Student>> journal = new HashMap<>();

    //добавление нового студента в список;
    public void addNewStudent(Student student) {
        Group group = new Group(student.getFaculty(), student.getYear());
        List<Student> listOfStudents = journal.containsKey(group) ? journal.get(group) : new ArrayList<>();
        listOfStudents.add(student);
        journal.put(group, listOfStudents);
    }

    //удаление студента из списка по его имени, факультету и курсу;
    public void deleteByAttributes(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        Group group = new Group(faculty, year);
        if (journal.containsKey(group)) {
            List<Student> listOfStudents = journal.get(group);
            if (listOfStudents.contains(student)) {
                listOfStudents.remove(student);
                if (listOfStudents.isEmpty()) {
                    journal.remove(group);
                } else {
                    journal.put(group, listOfStudents);
                }
            } else {
                throw new IllegalArgumentException("Нет такого студента");
            }
        }
    }

    //поиск всех студентов определённого факультета и курса;
    public void findByGroup(String faculty, int year) {
        Group group = new Group(faculty, year);
        if (!journal.containsKey(group)) {
            throw new IllegalArgumentException("Нет такой группы");
        } else {
            List<Student> list = journal.get(group);
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }

    //вывод списка всех студентов сгруппированных по факультетам и курсам
    public void displayAllByGroups() {
        Set<Map.Entry<Group, List<Student>>> entries = journal.entrySet();
        for (Map.Entry<Group, List<Student>> entry : entries) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }
}
