package faang.school.godbless.countAbsences;

import ch.qos.logback.core.joran.sanity.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class Student{
    private String name;
    private Faculty faculty;
    private int year;

    public Student(String name, Faculty faculty,int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }



}


