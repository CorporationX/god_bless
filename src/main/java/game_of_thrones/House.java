package game_of_thrones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class House {
    private List<String> availableRole = new ArrayList<>(Arrays.asList("Lord", "Knight", "Mage"));
    private List<String> notAvailableRole = new ArrayList<>();
    private int quantityAvailableRoles = 3;

    public List<String> getAvailableRole() {
        return availableRole;
    }

    public int getQuantityAvailableRoles() {
        return quantityAvailableRoles;
    }
    public void decreaseAvailableRoles() {
        quantityAvailableRoles--;
    }
    public void increaseAvailableRoles() {
        quantityAvailableRoles++;
    }
    public void removeAvailableRoles(String role){
        notAvailableRole.add(role);
        for(String roles : availableRole){
            if(roles.equals(role)){
                availableRole.remove(role);
            }
        }
    }

    public void addAvailableRoles(String role){
        availableRole.add(role);
        for(String roles : notAvailableRole){
            if(roles.equals(role)){
                notAvailableRole.remove(role);
            }
        }
    }

}