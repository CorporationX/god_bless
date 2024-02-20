package ElectrDnevnik;

import java.util.List;
import java.util.Map;

public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Double>> courses;

    public Student(String firstName, String lastName, Map<String, List<Double>> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Map<String, List<Double>> getCourses() {
        return courses;
    }
}
