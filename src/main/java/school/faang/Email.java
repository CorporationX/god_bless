package school.faang;

public class Email {
   private String subject;
   private String body;
   public boolean isImportant;
    public Email(String subject, String body, boolean isImportant){
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

}
