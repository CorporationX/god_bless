package faang.school.godbless.tinder;

public class Message {
  private String userOwnerId;
  private String text;
  private boolean isRead;

  public Message(String userOwnerId, String text) {
    this.userOwnerId = userOwnerId;
    this.text = text;
  }

  public String getUserOwnerId() {
    return userOwnerId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isRead() {
    return isRead;
  }

  public void setRead(boolean read) {
    isRead = read;
  }
}
