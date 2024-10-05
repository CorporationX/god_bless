package dima.evseenko.absenteeism;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FacultyYearKeyPair{
    private Faculty faculty;
    private int year;
}