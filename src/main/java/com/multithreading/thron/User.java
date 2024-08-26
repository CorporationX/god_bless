package com.multithreading.thron;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@Slf4j
public class User {
    private final String name;
    private final House house;
    private Role role;

    private final Object lock = new Object();

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() {
        synchronized (house) {
            try {
                if (house.getRoles().values().stream().allMatch(r -> r.equals(false))) {
                    log.info("{} Ожидает свободных ролей для дома {}", name, house);
                    house.wait();
                }
                Role role = house.getRoles()
                        .keySet()
                        .stream()
                        .filter(r -> house.getRoles().get(r).equals(true))
                        .findFirst()
                        .get();
                setRole(role);
                house.addRole(role);

                log.info("{} получил роль {}", name, role);
                log.info("Статус дома {}", house);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (role != null) {
                log.info("{} покинул роль {}", name, role);

                house.removeRole(role);
                setRole(null);
            }
        }
    }
}
