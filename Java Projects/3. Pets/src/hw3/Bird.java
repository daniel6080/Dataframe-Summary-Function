package hw3;

public class Bird extends Pet implements walking, flying {
	private int eggSize;
	
	public Bird() {} //기본 생성자
	public Bird(String name, int age, String color, int eggSize) {
		super(name, age, color);
		this.eggSize = eggSize;
	}
	
	public String sound() {
		return "sparkle";
	}
	public String walk() {
		return "bird_walk";
	}
	public String fly() {
		return "bird_fly";
	}
	public String toString() {
		return "Bird "+super.toString()+"eggSize("+eggSize+") sound("+this.sound()+") walk("+this.walk()+") fly("+this.fly()+")";
	}
}
