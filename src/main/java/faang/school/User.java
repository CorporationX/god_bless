package faang.school;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User implements Runnable{
    @NonNull
    private String name;
    @NonNull
    private House house;
    @NonNull
    private String role;
    private boolean isAdded = false;

    public void joinHouse() throws InterruptedException {
        isAdded = house.addUser(this);
        if (!isAdded) {
            System.out.printf("У дома %s нет подходящей роли (%s)\n", house.getName(), role);
        }
    }

    public void leaveHouse() {
        house.removeUser(this);
    }

    @Override
    public void run() {
        try {
            joinHouse();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
