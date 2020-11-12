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
		System.out.println("===================== FINISH =====================");
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
			.setDeadline(new DeadlineBuilder().addMonths(2).build())
			.build());

		ToDo psd = new ToDoBuilder()
			.setName("review PSD")
			.setDeadline(new DeadlineBuilder().build())
			.build();

		ToDo ada = new ToDoBuilder()
			.setName("Review ada")
			.setDeadline(new DeadlineBuilder().build())
			.build();

		ToDo os = new ToDoBuilder()
			.setName("Review operating system")
			.setDeadline(new DeadlineBuilder().build())
			.build();

		ToDo cb = new ToDoBuilder()
			.setName("Review character building")
			.setDeadline(new DeadlineBuilder().build())
			.build();

		fla.add(psd);
		psd.add(ada);
		ada.add(os);
		os.add(cb);

		fla.copyTo(ooad);

		ToDo ct = new ToDoBuilder()
			.setName("Review compilation techniques")
			.setDeadline(new DeadlineBuilder().build())
			.build();

		System.out.println("===================== Fla Children =====================");
		fla.printChildren();
		System.out.println("===================== OOAD Children =====================");
		ooad.printChildren();

		ooad.add(ct);

		todos.add(fla);
		todos.add(ooad);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
