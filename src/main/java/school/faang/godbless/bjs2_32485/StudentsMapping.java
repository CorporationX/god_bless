package school.faang.godbless.bjs2_32485;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentsMapping {

  private Map<FacultyYearKey, List<Student>> studentsMap;

  public StudentsMapping(List<Student> students) {
    studentsMap = new HashMap<>();

    students.forEach(student -> {
      FacultyYearKey key = new FacultyYearKey(student.getFaculty(), student.getYear());
      studentsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
    });
  }

  public void addStudent(Student student) {
    FacultyYearKey key = new FacultyYearKey(student.getFaculty(), student.getYear());
    studentsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
  }

  public void removeStudent(String name, String faculty, int year) {
    FacultyYearKey facultyYearKey = new FacultyYearKey(faculty, year);
    List<Student> filteredStudents = studentsMap.get(facultyYearKey);
    Student student = new Student(name, faculty, year);
    filteredStudents.remove(student);
  }

  public Optional<List<Student>> getFilteredStudents(String faculty, int year) {
    FacultyYearKey facultyYearKey = new FacultyYearKey(faculty, year);
    return studentsMap.containsKey(facultyYearKey) ? Optional.of(studentsMap.get(facultyYearKey)) : Optional.empty();
  }

  public String getStudentsAsString() {
    StringBuilder sb = new StringBuilder();
    studentsMap.forEach((key, students) -> {
      sb.append(key);
      sb.append(": ");
      sb.append(students);
    });
    return sb.toString();
  }
}
