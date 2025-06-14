package school.faang.bjs2_79679;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        StudentDatabase sb = new StudentDatabase(new HashMap<>(), new HashMap<>());

        sb.addStudent(new Student("jon"), new HashMap<>() {{
                put(new Subject("Algebra"), 5);
                put(new Subject("Electrodynamic"), 5);
                put(new Subject("Informatica"), 5);
            }
        });
        sb.addStudent(new Student("Fil"), new HashMap<>() {{
                put(new Subject("Algebra"), 4);
                put(new Subject("Informatica"), 4);
            }
        });
        sb.addStudent(new Student("Mary"), new HashMap<>() {{
                put(new Subject("Algebra"), 3);
            }
        });
        sb.addSubject(new Student("Mary"), new Subject("Informatica"), 3);
        sb.printSubject();
        sb.deleteStudent(new Student("Fil"));
        System.out.println();
        sb.printSubject();
    }
}
