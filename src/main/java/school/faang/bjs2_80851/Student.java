package school.faang.bjs2_80851;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Student {
    private String firstName;
    private String lastName;
    @SerializedName("subjects")
    private final Map<String, List<Integer>> courses = new HashMap<>();
}
