package faang.school.godbless.IronThroneAtAnyCost;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
public class House {
    private final List<String> avaliableRoles;
    private final String name;
    private int numOfAvaliableRoles;

    public synchronized void addRole(String role) {
        numOfAvaliableRoles--;
        avaliableRoles.remove(role);
        log.info("add: " + this.name + " | available roles " + this.numOfAvaliableRoles + " " + this.avaliableRoles);
        //avaliableRoles.notifyAll();
    }

    public synchronized void removeRole(String role) {
        numOfAvaliableRoles++;
        avaliableRoles.add(role);
        log.info("remove: " + this.name + " | available roles " + this.numOfAvaliableRoles + " " + this.avaliableRoles);
        //notify();
    }

    public House(List<String> avaliableRoles, String name) {
        this.numOfAvaliableRoles = avaliableRoles.size();
        this.avaliableRoles = avaliableRoles;
        this.name = name;
    }
}