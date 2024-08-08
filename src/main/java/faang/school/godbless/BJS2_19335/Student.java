package faang.school.godbless.BJS2_19335;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record Student(String name, String faculty, int year){

    public static Map<String, List<Student>> insertIntoMap(List<Student> students){
        Map<String, List<Student>> map = new HashMap<>();

        students.forEach(
                x -> map.computeIfAbsent((x.faculty + ", " + x.year), k -> new ArrayList<>()).add(x));

        return map;
    }
}
