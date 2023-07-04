package faang.school.godbless.amazon;

public class Order {
  private int id;
  private Status status = Status.CREATED;

  public Order(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
