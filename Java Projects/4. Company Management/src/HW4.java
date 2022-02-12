import java.util.*;

public class HW4 {
	public static void main(String[] args) {
		LinkedList emp = new LinkedList(); //list of Employees
		ArrayList prod = new ArrayList(); //list of Products
		HashSet cust = new HashSet(); //set of Customers
		Map purchase = new HashMap(); //purchase data
		
		Employee e1 = new Employee("Jim", 35); //Employee 클래스 생성
		Employee e2 = new Employee("Pam", 39);
		Employee e3 = new Employee("Dwight", 42);
		Employee e4 = new Employee("Ryan", 28);
		Employee e5 = new Employee("Kevin", 37);
		Employee e6 = new Employee("Creed", 64);
		Employee e7 = new Employee("Stanley", 58);
		Employee e8 = new Employee("Jim", 30); //동명이인이 있을 수 있다
		
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		emp.add(e4);
		emp.add(e5); //Employee 5명 추가
		
		System.out.println("List of Employees before firing, hiring, and sorting:");
		Iterator itEmp1 = emp.iterator();
		while(itEmp1.hasNext())
			System.out.println(itEmp1.next().toString()); //Employee 5명만 추가한 상태에서 list 출력
		System.out.println();
		
		emp.remove(e2);
		emp.remove(e4); //임의의 위치의 2명 해고
		
		emp.add(1,e6);
		emp.add(2,e7);
		emp.add(4,e8); //3명을 임의의 위치에 추가
		
		Collections.sort(emp); //Employee list 정렬

		System.out.println("List of Employees after firing, hiring, and sorting:");
		Iterator itEmp2 = emp.iterator();
		while(itEmp2.hasNext())
			System.out.println(itEmp2.next().toString()); //정렬된 Employee list 출력
		System.out.println();
		
		
		Product p1 = new Product("paper", 90, e1, true); //Product 클래스 생성
		Product p2 = new Product("paper", 90, e1, false);
		Product p3 = new Product("paper", 90, e5, false);
		Product p4 = new Product("paper", 80, e1, false);
		Product p5 = new Product("sandpaper", 20, e6, false);
		Product p6 = new Product("stapler", 1, e1, false);
		Product p7 = new Product("eraser", 5, e8, false);
		Product p8 = new Product("eraser", 8, e8, true);
		Product p9 = new Product("paper", 90, e8, false);
		Product p10 = new Product("paper", 100, e5, false);
		
		prod.add(p1);
		prod.add(p2);
		prod.add(p3);
		prod.add(p4);
		prod.add(p5);
		prod.add(p6);
		prod.add(p7);
		prod.add(p8);
		prod.add(p9);
		prod.add(p10); //10개의 Product를 list에 추가
		
		System.out.println("List of Products before sorting:");
		Iterator itProd1 = prod.iterator();
		while(itProd1.hasNext())
			System.out.println(itProd1.next().toString()); //정렬되기 전 Product list 출력
		System.out.println();

		Collections.sort(prod); //Product list 정렬
		
		System.out.println("List of Products after sorting:");
		Iterator itProd2 = prod.iterator();
		while(itProd2.hasNext())
			System.out.println(itProd2.next().toString()); //정렬된 Product list 출력
		System.out.println();
		
		
		Customer c1 = new Customer("Alice"); //Customer 클래스 생성
		Customer c2 = new Customer("Bob");
		Customer c3 = new Customer("Carlos");
		Customer c4 = new Customer("Daniel");
		Customer c5 = new Customer("Ethan");
		Customer c6 = new Customer("Fred");
		Customer c7 = new Customer("Galileo");
		
		cust.add(c1);
		cust.add(c2);
		cust.add(c3);
		cust.add(c4);
		cust.add(c5);
		cust.add(c6);
		cust.add(c7); //7명의 Customer를 set에 추가
		
		System.out.println("Customers:");
		Iterator itCust = cust.iterator();
		while(itCust.hasNext())
			System.out.println(itCust.next().toString()); //Customers set의 원소들 출력
		System.out.println();
		
		Boolean b1 = c1.equals(c2); //Customers set의 원소들이 서로 중복되는지 확인하는 몇 가지 예
		Boolean b2 = c1.equals(c3);
		Boolean b3 = c4.equals(c5);
		Boolean b4 = c6.equals(c7);
		
		System.out.println("Customers(HashSet) Duplicate Test:"); //Boolean값이 false가 돼야 중복되지 않는다는 뜻
		System.out.println("c1 equal to c2? " + b1);
		System.out.println("c1 equal to c3? " + b2);
		System.out.println("c4 equal to c5? " + b3);
		System.out.println("c6 equal to c7? " + b4);
		System.out.println();
		
		purchase.put(c1, p10); //7개의 엔트리(키와 값의 쌍)를 Purchase Map에 추가
		p10.sold = true;
		purchase.put(c2, p2);
		p2.sold = true;
		purchase.put(c3, p3);
		p3.sold = true;
		purchase.put(c4, p4);
		p4.sold = true;
		purchase.put(c5, p5);
		p5.sold = true;
		purchase.put(c6, p6);
		p6.sold = true;
		purchase.put(c7, p7);
		p7.sold = true;
		
		System.out.println("Purchases:");
		System.out.println(purchase); //Purchase Map에 포함된 엔트리들 출력
		System.out.println();
						
		System.out.println("List of Products after purchase:");
		Iterator itProd3 = prod.iterator();
		while(itProd3.hasNext())
			System.out.println(itProd3.next().toString()); //구매 후 바뀐 Product list 출력
		System.out.println();
	}
}

class Employee implements Comparable {
	String name; //Employee 이름
	int age; //Employee 나이
	
	Employee(String name, int age) { //생성자
		this.name = name;
		this.age = age;
	}
	
	public int compareTo(Object obj) { //정렬 기준: name 먼저, name 같으면 age로 (모두 오름차순)
		if(!(obj instanceof Employee)) return -1;
		Employee e = (Employee) obj;
		int nameDiff = name.compareTo(e.name);
		
		if(nameDiff == 0) return this.age - e.age; //name 같으면 age로
		
		return nameDiff; //name 다르면 name으로 정렬
	}
	
	public String toString() { //toString 메서드 오버라이딩
		return this.name+","+this.age;
	}
}

class Product implements Comparable {
	String name; //Product 명
	int amount; //Product 수량
	Employee employee; //Product를 생산한 Employee
	boolean sold; //Product 판매완료 여부
	
	Product(String name, int amount, Employee employee, boolean sold) { //생성자
		this.name = name;
		this.amount = amount;
		this.employee = employee;
		this.sold = sold;
	}
	
	public int compareTo(Object obj) { //정렬기준: name, amount, employee, sold 순 (모두 오름차순)
		if(!(obj instanceof Product)) return -1;
		Product p = (Product)obj;
		int nameDiff = name.compareTo(p.name);
		int amountDiff  = this.amount - p.amount;
		int employeeNameDiff = this.employee.name.compareTo(p.employee.name);
		int employeeAgeDiff = this.employee.age - p.employee.age;
		
		if(nameDiff==0) { //name 같으면 amount로
			if(amountDiff==0) { //amount 같으면 Employee name으로
				if(employeeNameDiff==0) { //Employee name 같으면 Employee age로
					if(employeeAgeDiff==0) { //Employee age 같으면 sold 여부로
						if(this.sold == true) return -1; //5.sold 여부로 정렬: true < false
						else return 1;
					}
					else return employeeAgeDiff; //4.Employee age 다르면 Employee age로 정렬
				}
				else return employeeNameDiff; //3.Employee name 다르면 Employee name으로 정렬
			}
			else return amountDiff; //2.amount 다르면 amount으로 정렬
		}
		else return nameDiff; //1.name 다르면 name으로 정렬
	}
	
	public String toString() { //toString 메서드 오버라이딩
		return this.name+","+this.amount+","+this.employee+","+this.sold;
	}
}

class Customer {
	String name; //Customer 이름 (중복 허용 X)
	
	Customer(String name) { //생성자
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Customer)) return false;
		
		Customer other = (Customer) obj;
		
		return name.equals(other.name); //이름이 동일하면 true 반환, 다르면 false 반환
	}
	
	public int hashCode() {
		return name.hashCode(); //String 클래스의 hashCode()는 각 문자열마다 서로 다름. 두 Customer의 name이 서로 다르면 hashCode도 서로 다름.
	}
	
	public String toString() { //toString 메서드 오버라이딩
		return name;
	}
}