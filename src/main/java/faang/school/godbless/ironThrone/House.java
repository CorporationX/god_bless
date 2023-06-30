package faang.school.godbless.ironThrone;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Getter
@Setter
public class House {
    @NonNull
    private String name;
    private List<String> roles = new ArrayList<>();
    private int availableRoles;

    public House(@NonNull String name) {
        this.name = name;
    }

    public void addRole(){
        synchronized (this){
            availableRoles--;
            System.out.println("Количество доступных ролей : " + availableRoles);
        }

    }

    public void removeRole(String name){
        synchronized (this) {
            availableRoles++;
            System.out.println("Количество доступных ролей: " + availableRoles + name);
        }
    }
}
