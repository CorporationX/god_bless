package module_3.module_3_1_Parallelism_Thread.helpColleague_35959;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;

    @Override
    public String toString() {
        return name + " " + surname + " " + age + " " + workplace;
    }
}
