package model;

import java.util.Vector;

public class ToDo implements Cloneable {
	private ToDo parent;
	private Vector<ToDo> children;

	private String name;
	private Deadline deadline;
	
	public ToDo() {
		parent = null;
		children = new Vector<ToDo>();
	}

	public ToDo(ToDo todo) {
		this.parent = todo.parent;
		this.name = todo.name;
		this.deadline = todo.deadline;
	}
	
	/**
	 * copy this ToDos structures (including the children) to new parent.
	 * 
	 * @param parent
	 */
	public void copyTo(ToDo parent) {
		Vector<ToDo> newTodos = new Vector<>();
		for(ToDo todo: children) {
			ToDo newToDo = new ToDo((ToDo) todo.clone());
			newTodos.add(newToDo);
			todo.copyTo(newToDo);
		}
		parent.children = newTodos;
	}

	@Override
	protected ToDo clone() {
		try {
			return (ToDo) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void add(ToDo c) {
		this.children.add(c);
		c.setParent(this);
	}

	public void print() {
		System.out.println(this);
		for(ToDo todo : children) {
			todo.print();
		}
	}

	@Override
	public String toString() {
		String indent = "";
		int level = getLevel();
		for(int i = 0; i < level; i++) {
			indent += "--";
		}
		
		return indent + name + " | deadline: " + deadline;
	}
	
	public void setParent(ToDo parent) {
		this.parent = parent;
	}
	
	public ToDo getParent() {
		return parent;
	}
	
	private int getLevel() {
		int level = 0;
		ToDo curr = parent;
		while(curr != null) {
			curr = curr.getParent();
			++level;
		}
		return level;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}

	public void printChildren() {
		for(ToDo child: children) {
			System.out.println("Hashcode = " + child.hashCode());
			System.out.println("Name = " + child.name);
			child.printChildren();
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
