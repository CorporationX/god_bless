package school.faang.async.twitter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class TwitterAccount {

  private String username;
  private int followers;

  @Override
  public String toString() {
    return "User name: " + username + ", followers: " + followers;
  }
}
