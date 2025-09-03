package school.faang.bjs2_85464;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private Integer age;
    private Set<String> activities;
}
