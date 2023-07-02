package faang.school.godbless.tinder;

public class User {
  private String name;
  private boolean isOnline = true;
  private boolean waitingForChat = true;

  public User(String name) {
    this.name = name;
  }

  public boolean isOnline() {
    return isOnline;
  }

  public void setOnline(boolean online) {
    isOnline = online;
  }

  public boolean isWaitingForChat() {
    return waitingForChat;
  }

  public String getName() {
    return name;
  }

  public void setWaitingForChat(boolean waitingForChat) {
    this.waitingForChat = waitingForChat;
  }
}
