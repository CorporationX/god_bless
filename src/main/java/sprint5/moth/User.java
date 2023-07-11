package sprint5.moth;

import lombok.Data;

@Data
public class User {
    private final String name;
    private boolean isOnline;

    public User(String name) {
        this.name = name;
    }

    public User(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public void online() {
        isOnline = true;
    }

    public void offline() {
        isOnline = false;
    }
}
