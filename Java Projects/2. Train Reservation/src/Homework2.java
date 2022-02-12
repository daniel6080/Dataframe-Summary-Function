import java.util.Scanner;
public class Homework2 {
	static int nTrain;
	static Train train[]; //train array
	
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		train = new Train[3];
		
		train[0]= new Train(1, 1, 30, 2); //Train(id, hour, min, nCar)
		train[1] = new Train(2, 2, 30, 2);
		train[2] = new Train(3, 3, 30, 2);
		
		for(int i=0; i<3; i++)
			train[i].car = new Car[2];

		for(int i=0; i<3; i++) {
			for(int j=0; j<train[i].nCar; j++) {
				if(j==0)
					train[i].car[j] = new Car(j+1,true,2); //Car(id, executive, nRow)
				else if(j==1)
					train[i].car[j] = new Car(j+1,false,2);
			}
		}
		
		for(int i=0; i<3; i++)
			for(int j=0; j<2; j++)
				train[i].car[j].seats = new Seat[2][4];
		
		for(int i=0; i<3; i++) { //80%의 확률로 각 좌석이 이미 예약된 상태가 되도록 설정
			for(int j=0; j<2; j++) {
				for(int k=0; k<train[i].car[j].nRow; k++) {
					for(int s=0; s<4; s++) {
						int rand =(int)(Math.random()*10 + 1); //1,2,3,...,10
						if (rand == 1 || rand == 2)
							train[i].car[j].seats[k][s] = new Seat(k+1,s+1,false); //Seat(row, col, reserved)
						else
							train[i].car[j].seats[k][s] = new Seat(k+1,s+1,true);
					}
				}
			}
		}
		
		char reserveCont = 'y';
		while(reserveCont == 'y') {
			Homework2.showHome(); //during first loop, shows current status for the first time
			System.out.print("Select train number: ");
			int trainNum = input.nextInt(); //1,2,3
			if(trainNum == 1 || trainNum == 2 || trainNum == 3) {} //check if valid number
			else if (trainNum == -1)
				break; //escape while loop
			else { //not 1, 2, 3, or -1
				System.out.println("Invalid train number");
				System.out.print("Reservation Continue? (y/n): ");
				reserveCont = input.next().charAt(0); //If user inputs y, enter next while loop. If user inputs any other character, escape while loop.
				if(reserveCont == 'y') //If user inputs y, print next line before going to next loop
					System.out.println("");
				continue; //continue while loop
			}
			System.out.print("Select Executive(1)/Standard(2): ");
			int carType = input.nextInt(); //executive(1) or standard(2)
			if(carType == 1 || carType == 2) {} //check if valid number
			else if (carType == -1)
				break; //escape while loop
			else { //not 1, 2, or -1
				System.out.println("Invalid condition. Input 1 or 2.");
				System.out.print("Reservation Continue? (y/n): ");
				reserveCont = input.next().charAt(0); //If user inputs y, enter next while loop. If user inputs any other character, escape while loop.
				if(reserveCont == 'y') //If user inputs y, print next line before going to next loop
					System.out.println("");
				continue; //continue while loop
			}
			System.out.print("Select Window(1)/Aisle(2): ");
			int seatType = input.nextInt(); //window(1) or aisle(2)
			if(seatType == 1 || seatType == 2) {} //check if valid number
			else if (seatType == -1)
				break; //escape while loop
			else { //not 1, 2, or, -1
				System.out.println("Invalid condition. Input 1 or 2.");
				System.out.print("Reservation Continue? (y/n): ");
				reserveCont = input.next().charAt(0); //If user inputs y, enter next while loop. If user inputs any other character, escape while loop.
				if(reserveCont == 'y') //If user inputs y, print next line before going to next loop
					System.out.println("");
				continue; //continue while loop
			}
			boolean checkWindow;
			if(seatType == 1)
				checkWindow = true;
			else //(seatType == 2)
				checkWindow = false;
			int trainReserved = 0, hourReserved = 0, minReserved = 0, carReserved = 0, seatRowReserved = 0, seatColReserved = 0;
			
			Loop1: for (int k = 0; k < train[trainNum-1].car[carType-1].nRow; k++) {
				Loop2: for (int s = 0; s < 4; s++) {
					while (train[trainNum-1].car[carType-1].seats[k][s].isWindow() == checkWindow) { //check if seats[k][s] is window or aisle seat
						if(train[trainNum-1].car[carType-1].seats[k][s].reserved == true) //it is reserved
							continue Loop2;
						else if(train[trainNum-1].car[carType-1].seats[k][s].reserved == false) {
							trainReserved = trainNum;
							hourReserved = train[trainNum-1].hour;
							minReserved = train[trainNum-1].min;
							carReserved = carType;
							seatRowReserved = train[trainNum-1].car[carType-1].seats[k][s].row;
							seatColReserved = train[trainNum-1].car[carType-1].seats[k][s].col;
							break Loop1;
						}
					}
				} //end of Loop2
			} //end of Loop1
			if(trainReserved == 0) { //there are no seats available for the given conditions
				System.out.println("No seat available for the given conditions");
				System.out.print("Reservation Continue? (y/n): ");
				reserveCont = input.next().charAt(0); //If user inputs y, enter next while loop. If user inputs any other character, escape while loop.
				if(reserveCont == 'y') //If user inputs y, print next line before going to next loop
					System.out.println("");
			}
			else if(trainReserved!= 0) {//there is at least one available seat
				train[trainReserved-1].car[carReserved-1].seats[seatRowReserved-1][seatColReserved-1].reserved = true; //Reservation is made
				System.out.println("Your reservation completed");
				System.out.print("Train "+trainReserved+" ("+hourReserved+":"+minReserved+") Car "+carReserved+" Seat "+seatRowReserved);
				System.out.println((char)(seatColReserved+64));
				System.out.print("Reservation Continue? (y/n): ");
				reserveCont = input.next().charAt(0); //If user inputs y, enter next while loop. If user inputs any other character, escape while loop.
				if(reserveCont == 'y') //If user inputs y, print next line before going to next loop
					System.out.println("");
			}
		} //end of while loop
		System.out.println("");
		showHome(); //show current status before program ends
		System.out.print("System Exit ...");
	} //end of main method
	
	static void showHome() { //show current status
		for(int i = 0; i < 3; i++) {
			int x = train[i].avSeatEx();
			int y = train[i].avSeatStd();
			System.out.println("*** Train "+train[i].id+" ***("+train[i].hour+":"+train[i].min+") ex("+x+") std("+y+")");
			for(int j=0; j<train[i].nCar; j++) { //prints for example "-- Car 1 (EX) --"
				System.out.print("-- Car "+train[i].car[j].id);
				if(j==0)
					System.out.print(" (EX) --");
				else if (j==1)
					System.out.print(" --");
				System.out.println("");
				for(int k=0; k<train[i].car[j].nRow; k++) {
					for(int s=0; s<4; s++) {
						if(train[i].car[j].seats[k][s].reserved == true)
							System.out.print("X  ");
						else if (train[i].car[j].seats[k][s].reserved == false) {
							System.out.print(train[i].car[j].seats[k][s].row);
							System.out.print((char)(train[i].car[j].seats[k][s].col+64));
							System.out.print(" ");
						}
					}
					if(k==0) //if first row
						System.out.print("  |   ");
					else if (k==1) //if second row
						System.out.println("");
				}
			}
			System.out.println(""); //new line for new train
		}
	} //end of showHome
} //end of class Homework2

class Train {
	int id; //열차(train)번호: 1, 2, 3
	int hour; //departure time
	int min; //departure time
	int nCar; //# of cars
	Car car[] = new Car[nCar]; //car array
		
	Train() {}; //default constructor
	Train(int id, int hour, int min, int nCar) { //initializing variables
		this.id = id;
		this.hour = hour;
		this.min = min;
		this.nCar = nCar;
	}
		
	int avSeatEx() { //# of executive seats available
		int countEx=0; //used to count the # of executive seats available
		for (int k = 0; k < Homework2.train[this.id-1].car[0].nRow; k++) {
			for (int s = 0; s < 4; s++) {
				if (!(Homework2.train[this.id-1].car[0].seats[k][s].reserved)) //car[0]: executive car
					countEx++;
		    }
		}
		return countEx;
	}
	int avSeatStd() { //# of standard seats available
		int countStd=0; //used to count the # of standard seats available
		for (int k = 0; k < Homework2.train[this.id-1].car[1].nRow; k++) {
			for (int s = 0; s < 4; s++) {
				if (!(Homework2.train[this.id-1].car[1].seats[k][s].reserved)) //car[1]: standard car
					countStd++;
		   	}
	    }
		return countStd;
	}
}
	
class Car {
	int id; //객차(car)번호: 1, 2
	boolean executive; //true if executive car
	int nRow; //# of rows
	Seat seats[][]; //seat 2D array
		
	Car() {} //default constructor
	Car(int id, boolean executive, int nRow) { //initializing variables
		this.id = id;
		this.executive = executive;
		this.nRow = nRow;
	}
		
	int avSeatEx() { //# of executive seats available
		int countEx=0;
		for (int k = 0; k < nRow; k++) {
			for (int s = 0; s < 4; s++) {
				if (!(seats[k][s].reserved))
					countEx++;
		    }
		}
		if(this.id == 1)
			return countEx;
		else //(this.id == 2)
			return 0;
	}
	
	int avSeatStd() { //# of standard seats available
		int countStd = 0;
		for (int k = 0; k < nRow; k++) {
			for (int s = 0; s < 4; s++) {
				if (!(seats[k][s].reserved))
					countStd++;
			}
		}
		if(this.id == 2)
			return countStd;
		else //(this.id == 1)
			return 0;
	}
}
	
class Seat {
	int row; //1, 2
	int col; //1, 2, 3, 4
	boolean reserved; //true if reserved seat
	
	Seat() {} //default constructor
	Seat(int row, int col, boolean reserved) {
		this.row = row;
		this.col = col;
		this.reserved = reserved;
	}
	
	boolean isWindow() { //return true if window seat
		if(col == 1 || col == 4)
			return true;
		else //(col == 2 || col == 3)
			return false;
	}
}