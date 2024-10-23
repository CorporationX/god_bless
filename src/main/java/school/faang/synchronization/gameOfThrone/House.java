package school.faang.synchronization.gameOfThrone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class House {
    private List<String> availableRoles;
    private Integer countOfAvailableRoles;
    private final String houseName;
    private Random random = new Random();

    public House(List<String> roles, String houseName) {
        this.availableRoles = new ArrayList<>(roles);
        this.countOfAvailableRoles = roles.size();
        this.houseName = houseName;
    }

    public String addRole() {
        countOfAvailableRoles--;
        return availableRoles.get(random.nextInt(countOfAvailableRoles));
    }

    public void removeRole() {
        countOfAvailableRoles++;
    }

}
