package faang.school.godbless.BJS2_24097;


import java.util.HashMap;
import java.util.Map;

public class House {
    private final Map<String, Integer> roles = new HashMap<>();

    public void putNewRoleAndQuantity(String role, int quantity) {
        roles.put(role, quantity);
    }

    public void addRole(User user) {
        String userRole = user.getRole();
        if (roles.containsKey(userRole)) {
            while (roles.get(userRole) == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Wait error");
                }
            }
            int oldValue = roles.get(userRole);
            roles.put(userRole, --oldValue);
            System.out.println(user.getName() + " takes the role");

            if (--oldValue > 0) {
                this.notifyAll();
            }
        }
    }

    public void removeRole(User user) {
        String userRole = user.getRole();
        if (roles.containsKey(userRole)) {
            System.out.println();
            int oldValue = roles.get(userRole);
            roles.put(userRole, ++oldValue);
            System.out.println(user.getName() + " leaves the role:");
            this.notifyAll();
        }
    }
}

