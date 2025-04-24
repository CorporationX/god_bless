package school.faang.stream2.electronicdiary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Student {
    private String firstName;
    private String lastName;
    @JsonProperty("subjects")
    private Map<String, List<Integer>> courses;
}
