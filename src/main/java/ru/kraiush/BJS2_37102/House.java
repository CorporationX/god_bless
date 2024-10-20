package ru.kraiush.BJS2_37102;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class House {
    private List<String> availableRoles;
    private int availableRolesCount;

    public House() {
        this.availableRoles = new ArrayList<>(Arrays.asList("Lord", "Knight", "Mage"));
        this.availableRolesCount = availableRoles.size();
    }

    public String addRole() {
        String role = availableRoles.get(availableRoles.size() - 1);
        availableRoles.remove(role);
        availableRolesCount--;
        return role;
    }

    public void removeRole(String role) {
        availableRoles.add(role);
        availableRolesCount++;
    }
}
