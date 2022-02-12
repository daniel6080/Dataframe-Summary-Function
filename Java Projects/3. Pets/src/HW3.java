import hw3.*;
import TXTFileReaderWriter.*;

public class HW3 {
	static int nPerson;
	static Person[] person;
	
	public static void main(String[] args) {
		readData();
		showData();
	}
	
	static void readData() {
		TXTFileReader reader = new TXTFileReader("petdata.txt");
				
		String temp = reader.readString();
		nPerson = Integer.parseInt(temp);
		
		person = new Person[nPerson];
		
		for(int i=0; i <nPerson; i++) {
			String s1 = reader.readString(); //reads person_name
			temp = reader.readString(); //reads # of pets
			int x1 = Integer.parseInt(temp); //convert # of pets to int
			person[i] = new Person(s1, x1);
			for(int j=0; j < x1; j++) {
				String s2 = reader.readString(); //reads kind_of_pet
				String s3 = reader.readString(); //reads pet_name
				temp = reader.readString(); //reads pet_age
				int x2 = Integer.parseInt(temp);
				String s4 = reader.readString(); //reads pet_color
				String s5 = reader.readString(); //reads dog_role, cat_hair, or size_of_egg
				if(s2.equals("Dog")) {
					Dog dog = new Dog(s3, x2, s4, s5); //create Dog instance
					person[i].setPet(j, dog);
				}
				else if(s2.equals("Cat")) {
					Cat cat = new Cat(s3, x2, s4, s5); //create Cat instance
					person[i].setPet(j, cat);
				}
				else if(s2.equals("Bird")) {
					int x3 = Integer.parseInt(s5); //converts size_of_egg to int
					Bird bird = new Bird(s3, x2, s4, x3); //create Bird instance
					person[i].setPet(j, bird);
				}
			}
		}
		reader.close();
	}
	
	static void showData() {
		for(int i=0; i < nPerson; i++) {
			System.out.println(person[i].toString());
		}
	}
}
