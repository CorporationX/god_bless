package faang.school.godbless.multithreading.ironthrone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class House {

    private List<Role> roles;
    private int freeRoles;

    public void addRole(){
        System.out.printf("> role added by %s%n", Thread.currentThread().getName());

        this.freeRoles--;
    }

    public void removeRole(){
        System.out.printf("> role removed by %s%n", Thread.currentThread().getName());

        this.freeRoles++;
        notifyAll();
    }
}
