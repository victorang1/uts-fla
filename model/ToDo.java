package model;

import java.util.Vector;

public class ToDo implements Cloneable {
	private ToDo parent;
	private Vector<ToDo> children;

	private String name;
	private Deadline deadline;
	
	public ToDo() {
		super();
		parent = null;
		children = new Vector<ToDo>();
	}
	
	/**
	 * copy this ToDos structures (including the children) to new parent.
	 * 
	 * @param parent
	 */
	public void copyTo(ToDo parent) {
		try {
			parent.children = deepCopy();
		} catch (Exception e) {
			throw new UnsupportedOperationException("not yet implemented");
		}
	}

	@Override
	protected Object clone() {
		try {
			return super.clone();
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
		for(int i = 0; i < getLevel(); i++) {
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
			curr = parent.getParent();
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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	private Vector<ToDo> deepCopy() {
		Vector<ToDo> temp = new Vector<>();
		for(ToDo todo: children) {
			temp.add((ToDo) todo.clone());
		}
		return temp;
	}
}
