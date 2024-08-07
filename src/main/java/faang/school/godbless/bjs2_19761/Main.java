package faang.school.godbless.bjs2_19761;

import static java.util.AbstractMap.SimpleEntry;

public class Main {
    public static void main(String[] args) {
        var service = new UniversityService();

        var initialSubjects = service.generateInitialSubjects();

        var student1 = service.createStudent("John");
        var marks1 = service.assignMarksToSubjects(initialSubjects, new int[]{10, 6, 3});
        service.addStudentWithMarks(new SimpleEntry<>(student1, marks1));
        var student2 = service.createStudent("Ivan");
        var marks2 = service.assignMarksToSubjects(initialSubjects, new int[]{5, 5, 5});
        service.addStudentWithMarks(new SimpleEntry<>(student2, marks2));
        service.printData();

        service.addSubjectToStudent(new SimpleEntry<>(new Subject("Ruby"), 1), student1);
        service.printData();

        service.deleteStudent(student1);
        service.printData();
    }
}
