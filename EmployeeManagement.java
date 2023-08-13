/*Name:Azreen Arshad Maulavi
 Batch:2023-9899
 Enrollment Number: EBEON0523698085
 Project Title: Employee Management 
 Concepts used : Package,Polymorphism,Class,Inheritance,Non primitive data type,
 Primitive data types,Method,Interface,Constructor,Method Overriding,
 Final Variable,Static Method,Enum,Scanner,Object,Collection,Control Structure, Stream API,try-catch,Access Modifier.
 keywords used: package,public,int,import,static,final,class,void,return,extends,double,implements,float,long,this,for,enum,new,if,switch,do,while,case,break,
default,try,catch

 Project Description:  A Java-based employee management system with features like adding,deleting,updating,
 viewing the details of employee working in a company and calculation of average of employees' salaries using Stream API..
 This System will also print the details of company name and location 
 Also, the details of HR of the company are displayed .
 The HR can easily manage the records of employee.
 In this project 20 concepts of java and 26 keywords have been used.
 */


package mini_Project;
import java.util.*;
import java.io.*;
import java.util.stream.Stream;
public class EmployeeManagement {                                                //11Access modifier
	  public static final String ANSI_RESET = "\u001B[0m";          //12.Final Variable Concept
      public static final String ANSI_GREEN_BOLD="\033[1;32m";
      public static final String ANSI_BLUE="\u001B[34m";
      public static final String ANSI_PURPLE="\u001B[35m";
      public static final String BLACK_BOLD = "\033[1;30m"; 
      public static final String PURPLE_BOLD = "\033[1;35m";
      public static final String CYAN_BOLD = "\033[1;36m";
      public static final String RED_BOLD = "\033[1;31m"; 
      public static final String RED= "\033[1;31m"; 
      public static final String BLUE_BOLD = "\033[1;34m";  
      public static final String PURPLE_UNDERLINED = "\033[4;35m";
	static void display(ArrayList<Employee> al)     //13.Static Method Concept   static method belongs to the class and can be called without creating object of class
	{
		System.out.println("\n--------------Employee List---------------\n");       
		System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s", "ID","Name","salary","contact-no","Email-Id"));       //displaying employee details
		for(Employee e : al)
		{
			System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s",e.id,e.name,e.salary,e.contact_no,e.email_id));
		}
	}
	
	public enum Job {                           //14.Enum concept
	    Software_Engineer,                    //enum is used for constant values ,here job titles are constant for a company
	    Network_Architect,
	    System_Analyst,
	    Cloud_Architect,
	    Operations_Manager,
	    Data_Scientist,
	    Product_Manager,
	    Databse_Administrator
	}
	
	public static void main(String[] args) throws IOException{ 
		Company c=new Company();                 //creating object of company class 
		c.show();
		System.out.println();
		System.out.println(c.show("Located at Pune"));
		System.out.println();
		System.out.println(RED_BOLD+"\t\t\t\t\t\t\t\t\t -----Job Titles Of Employees-----");
		System.out.println();
		 for (Job var_1 : Job.values()) {
	            System.out.println(BLUE_BOLD+var_1);
		 }
	    Scanner sc=new Scanner(System.in);   //15.Scanner Concept
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    System.out.println(PURPLE_BOLD+"\n*********Welcome to the Employee Management System**********\n"+ANSI_RESET);
	    System.out.println("Enter HR Name: ");                //taking HR details as input
	    String n=sc.nextLine();
	    HR h=new HR();                       //16.Object concept
	    h.setNm(n);
	    System.out.println("Enter Number of employees: ");
	    int ne=sc.nextInt();
	    h.setNo_of_emp(ne);
	    System.out.println("Enter Salary: ");
	    double s=sc.nextDouble();
	    h.setSal(s);
	    System.out.println();
		System.out.println(ANSI_BLUE+"*****HR Details are*****");                //printing HR details
		System.out.println();
		System.out.println(ANSI_GREEN_BOLD+"Name : "+h.getNm()+ "\n"+ "Number of Employees work under: "+h.getNo_of_emp()
				+"\n"+"Salary: "+h.getSal()+ANSI_RESET);
		System.out.println();
		System.out.println(PURPLE_UNDERLINED+ANSI_PURPLE+"----Job Description of HR----"+ANSI_RESET);
		System.out.println(h.description());
		System.out.println();
		
		int e_id;
		String e_name;
		float e_salary;
		long e_contact_no;
		String e_email_id;
		ArrayList<Employee> al = new ArrayList<Employee>();  //17.Collection Concept : creating ArrayList to store employee details
		
		

do                                                         //18.Control structure
{
	System.out.println(RED_BOLD+"\n*******MENU*******\n"+ANSI_RESET);
	System.out.println(BLUE_BOLD+"1). Add Employee to Record\n" +
						"2). Search for Employee\n" +
						"3). Edit Employee details\n" +
						"4). Delete Employee Details\n" +
						"5). Display all Employees working in this company\n" +
						"6).Calculate average of salaries of employee\n"+
						"7). Exit\n"+ANSI_RESET);
	System.out.println("Enter your choice : ");
	int ch = sc.nextInt();
	
	switch(ch) 
	{
	case 1:System.out.println("\nEnter the following details to ADD list:\n");         //taking employee details as input
		System.out.println("Enter ID :");
		e_id = sc.nextInt();
		System.out.println("Enter Name:");
		e_name=br.readLine();
		System.out.println("Enter Salary");
		e_salary=sc.nextFloat();
		System.out.println("Enter Contact No :");
		e_contact_no = sc.nextLong();
		System.out.println("Enter Email-ID :");
		e_email_id = sc.next();
		al.add(new Employee(e_id, e_name, e_salary, e_contact_no, e_email_id));
		System.out.println();
		System.out.println(ANSI_GREEN_BOLD+"Reocrd Added Sucessfully!!!"+ANSI_RESET);
		 
		break;
		
	case 2: System.out.println("Enter the Employee ID to search :");         //searching employee details
			e_id = sc.nextInt();
			int i=0;
			for(Employee e: al)
			{
				if(e_id == e.id)
				{
					System.out.println(ANSI_GREEN_BOLD+"Details Found!!"+ANSI_RESET+"\n"+e+"\n");
					i++;
				}
			}
			if(i == 0)
			{
				System.out.println(RED+"\nEmployee Details are not available, Please enter a valid ID!!"+ANSI_RESET); //if details not found
			}
			break;
	
	case 3: System.out.println("\nEnter the Employee ID to EDIT the details");
			e_id = sc.nextInt();
			int j=0;
			for(Employee e: al)
			{
				if(e_id == e.id)
				{	
					j++;
				do{
					int ch1 =0;
					System.out.println("\nEDIT Employee Details :\n" +                              //editing employee details 
										"1). Employee ID\n" +
										"2). Name\n" +
										"3). Salary\n" +
										"4). Contact No.\n" +
										"5). Email-ID\n" +
										"6). GO BACK\n");
					System.out.println("Enter your choice : ");
					ch1 = sc.nextInt();
					switch(ch1)
					{
					case 1: System.out.println("\nEnter new Employee ID:");
							e.id =sc.nextInt();
							System.out.println(e+"\n");
							break;
					
					case 2: System.out.println("Enter new Employee Name:");
							e.name =br.readLine();
							System.out.println(e+"\n");
							break;
							
					case 3: System.out.println("Enter new Employee Salary:");
							e.salary =sc.nextFloat();
							System.out.println(e+"\n");
							break;
							
					case 4: System.out.println("Enter new Employee Contact No. :");
							e.contact_no =sc.nextLong();
							System.out.println(e+"\n");
							break;
							
					case 5: System.out.println("Enter new Employee Email-ID :");
							e.email_id =sc.next();
							System.out.println(e+"\n");
							break;
							
					case 6: j++;
							break;
							
					default : System.out.println("\nEnter a correct choice from the List :");
								break;
					
					}
					}
				while(j==1);
				}
			}
			if(j == 0)
			{
				System.out.println(RED+"\nEmployee Details are not available, Please enter a valid ID!!"+ANSI_RESET);
			}
		
			break;
			
	case 4: System.out.println("\nEnter Employee ID to DELETE :");       //deleting details of employee
			e_id = sc.nextInt();
			int k=0;
			try{              //19.try-catch(Exception) concept
			for(Employee e: al)
			{
				if(e_id == e.id)
				{
					System.out.println(ANSI_GREEN_BOLD+"Deleted Sucessfully!!"+ANSI_RESET);
					System.out.println(CYAN_BOLD+"After Deletion the Record is:\n"+ANSI_RESET);
						al.remove(e);
						display(al);
						k++;
				}
			}
			if(k == 0)
			{
				System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
			}
			}
			catch(Exception ex){}
			break;
	
	
	case 5:
		System.out.println("\n--------------Employee List---------------\n");   //showing details of all employees working in the company using stream API
		System.out.println();
		System.out.println("ID\tName\tsalary\tcontact-no\tEmail-Id");
		
		Stream<Employee> st = al.stream();                      // 20.Java 8 Feature Stream API
		
		st.map((e1) -> e1.getId() + "\t" + e1.getName() + "\t" + e1.getSalary() + "\t" + e1.getContactNo()
				+ "\t" + e1.getEmailId()).forEach(System.out::println);

		break;
		
	case 6:       //calculating average salary of employees
		  System.out.printf("Average of Employees' salaries: %.2f%n",al.stream().mapToDouble(Employee::getSalary).average() .getAsDouble());   
		  //The mapToDouble() method returns a DoubleStream consisting of the results of applying the given function to the elements of this stream
          break;
	 
	case 7:
		System.out.println("\nYou have chosen EXIT !! Saving Files and closing the tool.");
		sc.close();
		System.exit(0);
		break;
	default : System.out.println("\nEnter a correct choice from the List :");
				break;
	
	}
}
while(true);
}
}
