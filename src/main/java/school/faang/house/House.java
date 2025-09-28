package school.faang.house;

import java.util.EnumMap;
import java.util.concurrent.Semaphore;
import java.util.Optional;

public class House {
    private String nameHouse;
    private final EnumMap<Role, Semaphore> roleLocks = new EnumMap<>(Role.class) {{
            for (Role role : Role.values()) {
                put(role, new Semaphore(role.getMaxMembers(), true));
            }
        }};

    public House(String name) {
        this.nameHouse = name;
    }

    public void assignRole(User user, Role role) {
        System.out.println(String.format("%s пытается получить роль %s", user.getName(), role));

        Optional.ofNullable(roleLocks.get(role))
                .orElseThrow(() -> new IllegalStateException("No semaphore for role: " + role))
                .acquireUninterruptibly();

        System.out.printf("%s вошел в %s%n", user.getName(), nameHouse);
        user.setRole(role);
    }


    public void releaseRole(User user) {
        Role role = user.getRole();
        if (role != null) {
            Optional.ofNullable(roleLocks.get(role))
                    .ifPresentOrElse(
                            semaphore -> {
                                semaphore.release();
                                System.out.printf("%s покинул роль %s%n", user.getName(), role);
                            },
                            () -> System.err.printf("Нет семафора для роли %s%n", role));
            user.setRole(null);
        }
    }
}
