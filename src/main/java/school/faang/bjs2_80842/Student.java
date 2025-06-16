package school.faang.bjs2_80842;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
public class Student {
    private String firstName;
    private String lastName;
    @JsonProperty("subjects")
    private Map<String, List<Integer>> courses;
}
