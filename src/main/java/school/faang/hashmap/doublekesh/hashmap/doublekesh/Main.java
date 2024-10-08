package school.faang.hashmap.doublekesh.hashmap.doublekesh;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  добавить студента, будет только в  studentSubjectsMarks (не будет предметов, не будет оценок) --- мапа с оценками не добавляется
//  добавить предмет (студент если нет, то дабавим, если есть , то добавим предмет если нет) - лист оценок не заполняется, заполняется только предмет и оценки
//  добавить оценку  - проверяется студент, проверяется предмет - если предмета нет, то проверяем и вторую мапу, чтоб добавить
//  удалить предмет - удаляем предмет - удаляется в 2-х мапах, может быть студент без предметов и оценок
//  удаление студента - удаляется из 2-х мап
//  вывод списка всех предметов и студентов. выводим только второй список
@Data
public class Main {
    private Map<Student, Map<Subject, Integer>> studentSubjectsMarks = new HashMap<>();
    private Map<Subject, List<Student>> subjectListStudents = new HashMap<>();

    public void addStudent(Student student){
        studentSubjectsMarks.putIfAbsent(student, new HashMap<>());
    }

    public void addStudentToSubject(Subject subject, Student student) {
        addStudent(student);
        if (subjectListStudents.containsKey(subject)) {
            List<Student> tempList = subjectListStudents.get(subject);
            for (Student studentFor : tempList) {
                if (studentFor.equals(student)) {
                    return;
                }
            }
            tempList.add(student);
        } else {
            List<Student> studentList = new ArrayList<>();
            studentList.add(student);
            subjectListStudents.put(subject, studentList);
        }
    }

    public void addMark(Subject subject, Student student, Integer mark)
    {
        addStudentToSubject(subject, student);
        studentSubjectsMarks.get(student).put(subject, mark);
    }

    public void deleteSubjectForStudent(Subject subject, Student student) {
        if(studentSubjectsMarks.containsKey(student)) {
            studentSubjectsMarks.get(student).remove(subject);
        }

        if(subjectListStudents.containsKey(subject)) {
            List<Student> tempList = subjectListStudents.get(subject);
            tempList.remove(student);
        }
    }

    public void deleteStudent(Student student) {
        studentSubjectsMarks.remove(student);
        subjectListStudents.forEach(((subject, students) -> students.remove(student)));
    }

    public void printSubjectListStudents() {
        subjectListStudents.forEach((subject, students) -> {
            System.out.printf("Subject : %s \n", subject);
            System.out.printf("Students : %s \n", students);
        });
    }
}