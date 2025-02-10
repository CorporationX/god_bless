package school.faang.task_57062;

import lombok.Data;

@Data
public class Student {
    private String name;
    char sex;
    int age;
    int course;


    public Student(String name) {
        this.name = name;
    }
}
