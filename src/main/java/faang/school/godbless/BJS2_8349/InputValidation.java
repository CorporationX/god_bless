package faang.school.godbless.BJS2_8349;

import java.util.List;

public class InputValidation {
    public void checkInputValueStudent(String name, String faculty, int year) {
        checkInputValueFacultyAndYear(faculty, year);

        if (name.isEmpty() || name.trim().isEmpty()) {
            throwIllegalArgument("Имя студента не должно быть пустым");
        }
    }

    public void checkInputValueFacultyAndYear(String faculty, int year) {
        if (faculty.isEmpty() || faculty.trim().isEmpty() ||
                year == 0) {
            throwIllegalArgument("Факультет и год не должны быть пустыми");
        }
    }


    public void checkInputListOfStudentsIsNull(List<Student> students) {
        if (students == null || students.isEmpty()) {
            throwIllegalArgument("Коллекция студентов пустая");
        }
    }

    public void checkExistStudentInList(Student newStudent, List<Student> studentList) {
        if (studentList.contains(newStudent)) throwIllegalArgument("Такой студент уже существует в списке");
    }

    private void throwIllegalArgument(String error) {
        throw new IllegalArgumentException(error);
    }

}
