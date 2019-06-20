package com.cg.eis.pl;
import java.io.*;
import java.util.*;
import com.cg.eis.bean.*;
import com.cg.eis.service.*;

public class MedicalScheme {

	public static void main(String[] args)throws IOException {
		
		EmployeeServiceImpl service=new EmployeeServiceImpl();
		Map<Integer,Employee> emp=new TreeMap<Integer,Employee>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String choice="";
		while(true)
		{
		System.out.println("1.Add an Employee");
		System.out.println("2.Find Scheme");
		System.out.println("3.Display all Employees");
		System.out.println("4.Exit");
		System.out.println("Enter your choice:");
		choice=br.readLine();
		switch(choice)
		{
		case "1":	int id=0;
					String name="";
					String designation="";
					double salary=0.0;
					System.out.println("Enter the Employee ID");
					while(true)
					{
						String s_id=br.readLine();
						boolean ch1=Validator.validatedata(s_id,Validator.eidpattern);
						if(ch1==true)
						{
							try {
								id=Integer.parseInt(s_id);
								break;
							}
							catch(NumberFormatException e)
							{
								System.out.println("Employee ID must be in 3 digits");
							}
						}
						else
						{
							System.out.println("Enter Employee ID in 3 digits.Please re enter.");
						}
					}
					System.out.println("Enter the Employee name");
					while(true)
					{
						String s_name=br.readLine();
						boolean ch1=Validator.validatedata(s_name,Validator.namepattern);
						if(ch1==true)
						{
							try {
								name=s_name;
								break;
							}
							catch(NumberFormatException e)
							{
								System.out.println("Re Enter");
							}
						}
						else
						{
							System.out.println("Re enter the Employee name.");
						}
					}
					System.out.println("Enter the Designation");
					while(true)
					{
						String s_des=br.readLine();
						boolean ch1=Validator.validatedata(s_des,Validator.namepattern);
						if(ch1==true)
						{
							try {
								designation=s_des;
								break;
							}
							catch(NumberFormatException e)
							{
								
								System.out.println("Re enter the Designation");
							}
						}
						else
						{
							System.out.println("Re Enter Designation");
						}
					}
					System.out.println("Enter the salary");
					while(true)
					{
						String s_sal=br.readLine();
						boolean ch1=Validator.validatedata(s_sal,Validator.salpattern);
						if(ch1==true)
						{
							try {
								salary=Double.parseDouble(s_sal);
								break;
							}
							catch(NumberFormatException e)
							{
								System.out.println("Salary must be in range or be numeric.");
							}
						}
						else
						{
							System.out.println("Salary must be in range or be numeric.Please re enter.");
						}
					}
					Employee ob=new Employee(id,name,salary,designation);
					emp.put(ob.getId(),ob);
					break;
					
		case "2":	System.out.println("Enter ID");
					id=Integer.parseInt(br.readLine());
					System.out.println(service.findScheme(emp.get(id)));
					break;
					
		case "3":	Collection<Employee> vc=emp.values();
					List<Employee> emplist=new ArrayList<Employee>(vc);
					for(Employee e:emplist)
					{
						service.printStatement(e);
					}
					break;
					
		case "4":	System.out.println("Exiting Program");
					System.exit(0);
					
		default:	System.out.println("Invalid Choice");
		}
		}

}
}
