package faang.school.godbless.skyNet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Robot {
    @NonNull
    private String target;

    public synchronized void attack(){
        System.out.println(target + " атакован");
    }
}
