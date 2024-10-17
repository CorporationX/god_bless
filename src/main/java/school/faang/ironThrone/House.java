package school.faang.ironThrone;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class House {
    private String name;
    private List<String> accessibleRoles;
    private int quantityOfAccessibleRoles;

    public House(String name, List<String> accessibleRoles) {
        this.name = name;
        this.accessibleRoles = new ArrayList<>(accessibleRoles);
        quantityOfAccessibleRoles = accessibleRoles.size();
    }

    public void addRole(User user) {
        this.quantityOfAccessibleRoles --;
        this.accessibleRoles.remove(user.getPreferedRole());
    }

    public void removeRole(User user) {
        quantityOfAccessibleRoles ++;
        accessibleRoles.add(user.getTakedRole());
        System.out.println("игрок "  + user.getName() + " освобождает роль " +
                                     user.getTakedRole() + " в доме " + name);
    }

}
