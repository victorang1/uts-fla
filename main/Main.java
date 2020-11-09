package main;

import java.util.Vector;

import builder.DeadlineBuilder;
import builder.ToDoBuilder;
import model.Deadline;
import model.ToDo;

public class Main {
	Vector<ToDo> todos = new Vector<>();
	public Main() {
		seed();
		
		for(ToDo t : todos) {
			t.print();
		}
	}
	
	private void seed() {
		ToDo fla = new ToDoBuilder().setName("study COMP6122").setDeadline(new Deadline()).build();
		
		fla.add(new ToDoBuilder()
			.setName("review OOP basic")
			.setDeadline(new DeadlineBuilder().build())
			.build());
		fla.add(new ToDoBuilder()
			.setName("read design pattern materials")
			.setDeadline(new DeadlineBuilder().addDays(3).build())
			.build());
		fla.add(new ToDoBuilder()
			.setName("train to code some toy projects")
			.setDeadline(new DeadlineBuilder().addMonth(2).build())
			.build());
		todos.add(fla);

		ToDo ayah = new ToDoBuilder()
			.setName("Ayah")
			.setDeadline(new DeadlineBuilder().addDays(1).build())
			.build();
		fla.copyTo(ayah);
		ayah.add(new ToDoBuilder()
			.setName("Children Ayah")
			.setDeadline(new DeadlineBuilder()
				.addDays(7)
				.addMonth(1)
				.build()
			)
			.build());
		
		todos.add(ayah);

		ToDo cucu = new ToDoBuilder()
			.setName("Cucu")
			.setDeadline(new DeadlineBuilder().addDays(1).build())
			.build();

		// fla.copyTo(cucu);

		ayah.add(cucu);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
