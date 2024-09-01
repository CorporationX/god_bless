package com.multithreading.thron;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class House {
    private final String name;
    private final Map<Role, Boolean> roles;

    public House(String name) {
        this.name = name;
        roles = new HashMap<>();
        roles.put(Role.LORD, true);
        roles.put(Role.ARCHER, true);
        roles.put(Role.KNIGHT, true);
    }

    public void addRole(Role role) {
        roles.computeIfPresent(role, (key, value) -> value = false);
    }

    public void removeRole(Role role) {
        synchronized (this) {
            roles.computeIfPresent(role, (key, value) -> value = true);
            this.notifyAll();
        }
    }
}
