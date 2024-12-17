package school.faang.task_48851;


import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Food {

	private int id;
	private String name;

	public Food( String name) {
		this.id =new Random().nextInt(0,10000);
		this.name = name;
	}
}
