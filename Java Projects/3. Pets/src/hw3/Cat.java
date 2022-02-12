package hw3;

public class Cat extends Pet implements walking {
	private String hair;
	
	public Cat() {} //기본 생성자
	public Cat(String name, int age, String color, String hair) {
		super(name, age, color);
		this.hair = hair;
	}
	
	public String sound() {
		return "mew";
	}
	public String walk() {
		return "cat_walk";
	}
	public String toString() {
		return "Cat "+super.toString()+"hair("+hair+") sound("+this.sound()+") walk("+this.walk()+")";
	}
}
