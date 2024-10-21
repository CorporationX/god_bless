package school.faang.iron_throne_at_any_cost;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Getter
public class House {
    private final String name;
    private final List<Role> availableRoles;

    public int getAvailableRoleCount(){
        return availableRoles.size();
    }

    public House(String name){
        this.name = name;
        availableRoles = new ArrayList<>();
    }

    public void addRole(Role... roles){
        Collections.addAll(availableRoles, roles);
    }
}