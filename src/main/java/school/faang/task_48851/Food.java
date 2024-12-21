package school.faang.task_48851;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Random;

@Getter
@Setter
public class Food {

	private int id;
	private String name;

	public Food( String name) {
		this.id =new Random().nextInt(0,15);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Food{" +"id=" + id
				+", name='" + name + '\'' +'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Food food = (Food) o;
		return id == food.id && Objects.equals(name, food.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
