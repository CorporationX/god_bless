package school.faang.task_48831;

import lombok.Data;

@Data
public class Role {
    private final RoleName name;
    private User user;
}
