package faang.school.godbless.gmail;

public class Email {
  String subject;
  String body;
  Boolean important;

  public Email(String subject, String body, Boolean isImportant) {
    this.subject = subject;
    this.body = body;
    this.important = isImportant;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }

  public Boolean isImportant() {
    return important;
  }
}
