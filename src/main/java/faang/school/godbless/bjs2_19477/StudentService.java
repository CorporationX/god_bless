package faang.school.godbless.bjs2_19477;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentService {
    public Map<StudentsFinderByFacultyYear, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        var result = new HashMap<StudentsFinderByFacultyYear, List<Student>>();
        for (Student s : students) {
            addStudentToGroupedStudents(s, result);
        }
        return result;
    }

    public Map<StudentsFinderByFacultyYear, List<Student>> groupStudentsByFacultyAndYearJava8(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        s -> new StudentsFinderByFacultyYear(s.getFaculty(), s.getYear()),
                        s -> {
                            List<Student> list = Lists.newArrayList(s);
                            return list;
                        },
                        (existingList, newList) -> {
                            existingList.addAll(newList);
                            return existingList;
                        }
                ));
    }

    public void addStudentToGroupedStudents(Student s, Map<StudentsFinderByFacultyYear, List<Student>> groupedStudents) {
        var finder = new StudentsFinderByFacultyYear(s.getFaculty(), s.getYear());
        if (!groupedStudents.containsKey(finder)) {
            groupedStudents.put(finder, Lists.newArrayList(s));
        } else {
            groupedStudents.get(finder).add(s);
        }
    }

    public void removeStudentFromGroupedStudents(Student s, Map<StudentsFinderByFacultyYear, List<Student>> groupedStudents) {
        var finder = new StudentsFinderByFacultyYear(s.getFaculty(), s.getYear());
        var students = groupedStudents.get(finder);
        if (students != null) {
            students.remove(s);
        }
    }

    public List<Student> findStudentsByFacultyYear(StudentsFinderByFacultyYear finder, Map<StudentsFinderByFacultyYear, List<Student>> groupedStudents) {
        return groupedStudents.get(finder);
    }

    public void printStudents(Map<StudentsFinderByFacultyYear, List<Student>> groupedStudents) {
        printEntrySet(groupedStudents.entrySet());
    }

    public void printStudentsWithSorting(Map<StudentsFinderByFacultyYear, List<Student>> groupedStudents) {
        TreeMap<StudentsFinderByFacultyYear, List<Student>> sortedGroupedStudents = new TreeMap<>(groupedStudents);
        printEntrySet(sortedGroupedStudents.entrySet());
    }

    private void printEntrySet(Set<Map.Entry<StudentsFinderByFacultyYear, List<Student>>> entrySet) {
        for (Map.Entry<StudentsFinderByFacultyYear, List<Student>> entry : entrySet) {
            var key = entry.getKey();
            System.out.println("Faculty: " + key.faculty.name());
            System.out.println("Year: " + key.year);
            printUsersList(entry.getValue());
        }
    }

    public void printUsersList(List<Student> students) {
        for (Student student : students) {
            System.out.println("    " + student.toString());
        }
    }
}
