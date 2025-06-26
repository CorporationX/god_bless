package school.faang.ironThrone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String name;
    private String assignedRole;
    public Map<String, User> rolesMap;

    public void joinHouse(House house) {

    }
}














