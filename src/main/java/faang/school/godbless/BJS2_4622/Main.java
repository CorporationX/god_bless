package faang.school.godbless.BJS2_4622;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Student> studentsList = new ArrayList<>();

        studentsList.add(new Student("Slava", "PMI", 1));
        studentsList.add(new Student("Kate", "History", 2));
        studentsList.add((new Student("Gregory", "Music", 4)));
        studentsList.add((new Student("Kata", "IMIT", 3)));

        ActionOnStudents.deleteStudent("Gregory", "Music", 4, studentsList);
        ActionOnStudents.addNewStudent("Sasha", "IMIT", 3, studentsList);
        ActionOnStudents.printAllStudents(studentsList);
        ActionOnStudents.searchAllStudents("IMIT", 3, studentsList);

    }
}
