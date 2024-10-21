package school.faang.BJS237051;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private House house;
    private String role;

    public void joinHouse(){

    }
}
