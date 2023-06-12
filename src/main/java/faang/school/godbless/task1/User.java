package faang.school.godbless.task1;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class User {
    private String name;
    @Getter
    private int age;
    private String worksPlace;
    private String address;
}
