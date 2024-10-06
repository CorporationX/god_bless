package school.faang.godbless.bjs2_33520;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {

  private String subject;
  private String body;
  private boolean isImportant;

}
