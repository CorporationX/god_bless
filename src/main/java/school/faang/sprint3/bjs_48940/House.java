package school.faang.sprint3.bjs_48940;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class House {
    private List<String> roles;
    @Setter
    private int availableRolesAmount;

    public House(List<String> roles) {
        this.roles = roles;
        this.availableRolesAmount = roles.size();
    }
}
