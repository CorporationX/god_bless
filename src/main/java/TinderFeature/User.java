package TinderFeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private String name;
    private Integer id;
    private boolean isActive;
    @Getter
    @Setter
    private Chat currentChat;

    public User(String name, Integer id, boolean isActive) {
        this.name = name;
        this.id = id;
        this.isActive = isActive;
    }

    public boolean isActive(){
        return isActive;
    }
}
