package school.faang.BJS2_32564;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Main {
    private final Map<KeyFaculty, List<String>> university = new HashMap<>();
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Name Student 1", "Faculty 1", 2021));
        students.add(new Student("Name Student 2", "Faculty 2", 2022));
        students.add(new Student("Name Student 3", "Faculty 3", 2023));
        students.add(new Student("Name Student 4", "Faculty 1", 2021));

        Main main = new Main();
        main.transferFromListToMap(students);
        main.printAllUniversity();
        main.deleteStudentFromMap(new Student("Name Student 3", "Faculty 3", 2023));
        main.printAllUniversity();

        System.out.printf("\nList of a Faculty : %s\n",
                main.findAllStudents(new KeyFaculty( "Faculty 1", 2021)).toString());
    }

    public Map<KeyFaculty, List<String>> transferFromListToMap(List<Student> students){
        students.forEach(this::addNewStudentToMap);
        return university;
    }

    public void addNewStudentToMap(Student student){
        KeyFaculty keyFaculty = new KeyFaculty(student.getFaculty(), student.getYear());
        university.putIfAbsent(keyFaculty, new ArrayList<>());
        for (String name : university.get(keyFaculty)){
            if(name.equals(student.getName())) {
                return;
            }
        }
        university.get(keyFaculty).add(student.getName());
    }

    public void deleteStudentFromMap(Student student){
        university.get(new KeyFaculty(student.getFaculty(), student.getYear())).remove(student.getName());
    }

    public List<String> findAllStudents(KeyFaculty keyFaculty){
        return university.containsKey(keyFaculty) ? university.get(keyFaculty) : new ArrayList<>();
    }

    public void printAllUniversity(){
        System.out.println("\n=== University ===");
        university.forEach((keyFaculty, strings) -> {
            System.out.printf("=== Faculty - %s || Year - %d ===\n", keyFaculty.getFaculty(), keyFaculty.getYear());
            System.out.printf("Students : %s \n", strings.toString());
        });
    }
}