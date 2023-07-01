package faang.school.godbless.sky_net;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private String name;
    private final Target target;

    public void attack(){
        synchronized (target){
            System.out.println(name + " is attacking " + target.getName());
        }
    }
}
