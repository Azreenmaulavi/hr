package mini_Project;  //1.Package Concept
import java.io.*;

class Company           //2.class concept
 {
	  public static final String ANSI_GREEN_BOLD="\033[1;32m";
	  public static final String ANSI_RESET = "\u001B[0m"; 
	String comp_name,location;
	int no;
	Company()                            //constructor
	{
		comp_name="MyComapny";       //assigning default values
		no=8000;
		location="Pune";
		
	}
	public void show()
	{
		System.out.println(ANSI_GREEN_BOLD+"\t\t\t\t\t\t\t\t\t\t\t\t "+comp_name+ANSI_RESET);
	}
	 String show(String msg)          //3.Polymorphism   show() method has two forms here
	 {
		 return msg+"\n "+no+" "+"employees work in"+"  "+comp_name;
	 }
}



class HR extends Company {             //4.Class Concept
	                                                       
	String nm;         //5.Non-primitive data type String
	int No_of_emp;     //6.Primitive Data Types int and double
	double sal;
	public String getNm() {        
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public int getNo_of_emp() {                      //getter method is used to get the value and setter method is used to set the value
		return No_of_emp;
	}
	public void setNo_of_emp(int no_of_emp) {
		No_of_emp = no_of_emp;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	String description()           //7.Method concept
	{
		return "Human Resource Managers are professionals tasked with strategic planning for staffing,\n conducting interviews, and hiring personnel \n to foster a productive work atmosphere.";
	}
}

@SuppressWarnings("serial")           //It instructs the compiler to ignore the warning related to the missing serialVersionUID field when a class implements Serializable interface.
class Employee implements Serializable{       //8.Interface Concept
                                     //Serialization in Java allows us to convert an Object to stream that we can store for later usage.
	int id;
	String name;
	float salary;
	long contact_no;
	String email_id;
	
	public Employee(int id, String name, float salary, long contact_no, String email_id) //9.Constructor Concept
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.contact_no = contact_no;
		this.email_id = email_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public long getContactNo() {
		return contact_no;
	}
	public void setContactNo(long contact_no) {
		this.contact_no = contact_no;
	}
	
	public String getEmailId() {
		return email_id;
	}
	public void setEmailId(String email_id) {
		this.email_id = email_id;
	}
	
	public String toString()          //10.Method Overriding Concept
	{
		return "\nEmployee Details :" + "\nID: " + this.id + "\nName: " + this.name + "\nSalary: " + 
				this.salary + "\nContact No: " + this.contact_no + "\nEmail-id: " + this.email_id;
	}
	
}

