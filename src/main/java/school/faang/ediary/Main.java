package school.faang.ediary;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException,
            NoSuchElementException, NullPointerException {

        List<Student> students = new ArrayList<>();

        try {
            String pathToJsonFile = "src/main/resources/students_test_data.json";

            File file = new File(pathToJsonFile);
            ObjectMapper objectMapper = new ObjectMapper();
            ExtractedClass[] extracted =
                    objectMapper.readValue(file, ExtractedClass[].class);

            for (ExtractedClass e : extracted) {
                String firstName = e.firstName;
                String lastName = e.lastName;
                Map<String, Integer[]> extractedSubjects = e.subjects;
                Map<String, List<Integer>> subjects = extractedSubjects
                        .entrySet()
                        .stream()
                        .map(x -> {
                            String subjectName = x.getKey();
                            Integer[] subjectValue = x.getValue();
                            List<Integer> listInsteadOfArray =
                                    new ArrayList<>(Arrays.asList(subjectValue));

                            Map.Entry<String, List<Integer>> entry =
                                    new AbstractMap.SimpleEntry<>(
                                            subjectName, listInsteadOfArray);
                            return entry;
                        })
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue));

                Student newStudent = new Student(firstName, lastName, subjects);
                students.add(newStudent);
            }
            //BJS2-35246
        } catch(Exception e) {
            e.printStackTrace();
        }

        Student firstStudentinTheList = students.get(0);
        String name = firstStudentinTheList.getFirstName();
        String lastName = firstStudentinTheList.getLastName();

        System.out.println("Возьмем первого студента из списка");
        System.out.println(" имя нашего подопытного: " + name);
        System.out.println(" его фамилия: " + lastName);
        System.out.println(" его средние оценки: " +
                Student.getFinalGradesForStudent(students, name, lastName));
        System.out.println();

        System.out.println("Посмотрим, какой предмет тут самый трудный... " +
                "\n" + " - " + Student.findMostDifficultSubject(students));
        System.out.println();

        System.out.println("Ну и какие же в этой школе средние оценки?" + "\n" +
                " " + Student.calculateAverageGrade(students));
    }
}
