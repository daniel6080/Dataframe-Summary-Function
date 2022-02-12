package hw3;

public class Person {
	private String name; //person_name
	private int nPet; //# of pets
	private Pet[] pet;
	
	public Person() {} //기본 생성자
	public Person(String name, int nPet) {
		pet = new Pet[nPet];
		this.name = name;
		this.nPet = nPet;
	}

	public void setPet(int i, Pet pet) {
		this.pet[i] = pet;
	}
	public String toString() {
		String s=name+" pet("+nPet+")\n";
		for(int i=0; i<nPet; i++) { //return information for each pet belonging to this person
			s=s+"\t"+this.pet[i].toString()+"\n";
		}
		return s;
	}
	public String getName() {
		return name;
	}
	public int getNPet() {
		return nPet;
	}
	public Pet getPet(int i) {
		return this.pet[i];
	}
	
}
