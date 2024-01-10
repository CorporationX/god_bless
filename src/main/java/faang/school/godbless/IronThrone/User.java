package faang.school.godbless.IronThrone;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private final String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            List<String> listOfRoles = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : house.getRoles().entrySet()) {
                if (entry.getValue() > 0)
                    listOfRoles.add(entry.getKey());
            }
            if (listOfRoles.contains(null)) {
                try {
                    house.wait();
                    System.out.println("Все роли в " + house.getName() + " заняты, ожидайте ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Выберите роль " + listOfRoles);
                try {
                    this.role = reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (house.addRole(this.role)) {
                    this.house = house;
                    System.out.println(this.name + " присоединился к дому " + this.house.getName() +
                            " с ролью " + this.role);
                } else System.out.println("Неверный ввод");
            }
            house.getRoles().forEach((key, value) -> System.out.println(key + " " + value));
        }
    }


    public synchronized void leaveHouse() {
        if (this.role != null) {
            this.getHouse().removeRole(this.role);
            this.house = null;
        }
    }

    @Override
    public String toString() {
        return name + ", house " + house +
                ", role '" + role + '\'' + "\n";
    }
}
