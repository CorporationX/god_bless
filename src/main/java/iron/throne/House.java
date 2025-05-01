package iron.throne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@AllArgsConstructor
public class House {
    private List<String> roles;

    public String assignRole() {
        return roles.remove(0);
    }

    public void releaseRole(String role) {
        roles.add(role);
    }
}
