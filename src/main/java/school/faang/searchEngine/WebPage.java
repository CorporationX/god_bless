package school.faang.searchEngine;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WebPage {
  private String url;
  private String title;
  private String content;
}
