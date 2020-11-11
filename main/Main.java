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
		ToDo fla = new ToDoBuilder()
			.setName("study COMP6122")
			.setDeadline(new Deadline())
			.build();

		ToDo ooad = new ToDoBuilder()
			.setName("review OOAD")
			.setDeadline(new DeadlineBuilder().build())
			.build();

		fla.add(new ToDoBuilder()
			.setName("read design pattern materials")
			.setDeadline(new DeadlineBuilder().addDays(3).build())
			.build());

		fla.add(new ToDoBuilder()
			.setName("train to code some toy projects")
			.setDeadline(new DeadlineBuilder().addMonth(2).build())
			.build());

		ToDo psd = new ToDoBuilder()
			.setName("review PSD")
			.setDeadline(new DeadlineBuilder().build())
			.build();

		ToDo ada = new ToDoBuilder()
			.setName("Review ada")
			.setDeadline(new DeadlineBuilder().build())
			.build();

		fla.copyTo(ooad);
		
		ooad.add(psd);
		psd.add(ada);

		todos.add(fla);
		todos.add(ooad);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
