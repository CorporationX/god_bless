package faang.school.godbless.spring_4.send_a_raven;

public class Kingdom {
    private final String name;
    private String message;

    public Kingdom(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String sendMessage(Kingdom kingdom) {
        return kingdom.message;
    }

    public String getName() {
        return name;
    }
}
