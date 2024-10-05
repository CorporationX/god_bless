package dima.evseenko.absenteeism;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Faculty faculty;
    private int year;
}
