package school.faang.doublecash;

import lombok.Data;

@Data
public class Student {
    private final String name;

    public Student(String name) {
        this.name = name;

        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.checkNameStudent(name);
    }
}