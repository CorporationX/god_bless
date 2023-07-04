package faang.school.godbless.facebook;

public class Notification {
  private String id;
  private String message;

  public Notification(String id, String message) {
    this.id = id;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public String getId() {
    return id;
  }
}
