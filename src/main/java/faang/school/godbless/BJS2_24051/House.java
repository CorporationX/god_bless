package faang.school.godbless.BJS2_24051;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
@ToString
public class House {
    private List<Role> roles;
    private int freeRoles;

    public void addRole(){
        log.info("One role added by {}", Thread.currentThread().getName());
        this.freeRoles--;
    }

    public void removeRole(){
        log.info("One role removed by {}", Thread.currentThread().getName());
        this.freeRoles++;
        notifyAll();
    }
}
