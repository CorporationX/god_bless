package school.faang.doublecash;

import lombok.Data;

@Data
public class Subject {
    private final String name;

    public Subject(String name) {
        this.name = name;

        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.checkNameSubject(name);
    }
}