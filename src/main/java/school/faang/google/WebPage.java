package school.faang.google;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class WebPage {
  private String url;
  private String title;
  private String content;

  @Override
  public String toString() {
    return "{" + url + " : " + title + "}";
  }
}
