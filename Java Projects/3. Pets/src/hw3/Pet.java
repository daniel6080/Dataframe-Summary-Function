package hw3;

public abstract class Pet {
	private String name;
	private int age;
	private String color;
	
	public Pet() {} //기본 생성자
	public Pet(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	public abstract String sound();
	public String toString() {
		return "name("+this.name+") age("+this.age+") color("+this.color+") ";
	}
}
