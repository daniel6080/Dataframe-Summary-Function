package hw3;

public class Dog extends Pet implements walking {
	private String role;
	
	public Dog() {} //기본 생성자
	public Dog(String name, int age, String color, String role) {
		super(name, age, color);
		this.role = role;
	}
	
	public String sound() {
		return "bark";
	}
	public String walk() {
		return "dog_walk";
	}
	public String toString() {
		return "Dog "+super.toString()+"role("+role+") sound("+this.sound()+") walk("+this.walk()+")";
	}
}
