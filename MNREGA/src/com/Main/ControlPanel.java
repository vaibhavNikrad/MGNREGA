package com.Main;

import java.util.List;
import java.util.Scanner;

import com.Model.BDO;
import com.Model.Employee;
import com.Model.GpmMember;
import com.Model.Project;
import com.Usecase.BDOfunction;
import com.Usecase.GpmFunctions;

public class ControlPanel {

public static Scanner sc = new Scanner(System.in);
	
	public static BDOfunction funBDO = new BDOfunction();
	
	public static void main(String[] args) {
		mnPortal();
	}
	
//	Current BDO or GPM to be remember
	public static String curBDO = null;
	public static String curGPM = null;

//wlecome mesage and main option  	
    public static void mnPortal() {
  	
    	System.out.println("***Welcome to MNREGA protal***\r\n"
    			+ "----------------------------------------\r\n"
    			+ "Type 1 to acess as BLOCK DEVELOPMENT OFFICER\r\n"
    			+ "Type 2 to acess as GRAM PANCAYAT MEMBER\r\n"
    			+ "Type 0 to exit the application");
    	
    	 String out = sc.next();
    	 
    	 if(out.equals("1")) {
    		 bdoPotal();
    	 }else if(out.equals("2")) {
    		 gpmPortal();
    	 }else if(out.equals("0")) {
	    		sc.close();
	    		funBDO.sc.close();
	    		System.out.println("Exited...");
    	 }else {
    		 System.out.println("!!!Invalid selection!!!");
    		 mnPortal();
    	 }
    	
    }
    
//bdo portal    
    public static void bdoPotal() {
    	
    	System.out.println("\r\n"
    			+ "***Welcome TO BLOCK DEVELOPMENT OFFICERS Portal***\r\n"
    			+ "\r\n"
    			+ "Type 1 To Login\r\n"
    			+ "Type 2 To Create BDO account\r\n"
    			+ "Type 99 To Go to Main Portal\r\n"
    			+ "Type 0 To Exit The Application");
    	
    	 String out = sc.next();
    	 
    	 if(out.equals("1")) {
    		//for loging in bdo account
    	      System.out.println("\r\n"+"BDO LOGIN PORTAL");
    	      System.out.println("ENTER YOUR USERNAME");
    	      String user = sc.next();
    	      System.out.println("ENTER YOUR PASSWORD");
    	      String pass = sc.next();
    	      
    	      if(BDOfunction.loginBDO(user, pass)) {
//    		      Accesing the functionality of BDO
        	      bdofunctiond(); 
    	      }else {
    	    	  bdoPotal();
    	      }
    	      
    	 }else if(out.equals("2")) {
//for insertin bdo
 			System.out.println("Creating New BDO Account");
 			
 			System.out.println("Enter BDO name");
 			String nam = sc.next();
 			System.out.println("Enter BDO username");
 			String user = sc.next();
 			System.out.println("Enter BDO password");
 			String pass = sc.next();
 			
 	       BDO bdo1 = new BDO(0, nam, user, pass);
 	       
 			
 			funBDO.insertBDO(bdo1);
// 			redirect to bdo portal
 			bdoPotal();
 			
    	 }else if(out.equals("0")) {
    			sc.close();
        		funBDO.sc.close();
        		System.out.println("Exited...");
    	 }else if(out.equals("99")) {
    		   mnPortal();
    	 }else {
    		 System.out.println("!!!Invalid selection!!!");
    		 bdoPotal();
    	 }
    	
    }
    
    public static void bdofunctiond() {
    	
    	boolean rev = true;
    	
    	System.out.println("\r\n"
    			+ "Type 1 to create project\r\n"
    			+ "Type 2 to View the project\r\n"
    			+ "Type 3 to create Gram Panchayat Member\r\n"
    			+ "Type 4 to view Gram Panchayat Member\r\n"
    			+ "Type 5 to Allocate Project To GPM\r\n"
    			+ "Type 6 to To See The Employee Working, wage On Project\r\n"
    			+ "Type 99 To Go to main Portal\r\n"
    			+ "Type 0 To Exit The Application");
    	
    	 String out = sc.next();
    	
    	switch (out) {
    	  case "1":
    		//for creating project
    			System.out.println("\r\n"+"Create Project");
    			System.out.println("Enter Project Name");
    			String nam = sc.next();
    			System.out.println("Enter Project total cost");
    			int cost = sc.nextInt();
    			System.out.println("Enter Project Wage Per Empployee");
    			int wage = sc.nextInt();
    			System.out.println("Enter Project No of Empployee Required");
    			int empReq = sc.nextInt();
    			System.out.println("Enter Project Date Of Start in YYYY-MM-DD");
    			String dos = sc.next();
    			System.out.println("Enter Project Date Of End in YYYY-MM-DD");
    			String doe = sc.next();
    	
//    			Project pro = new Project(doe, nam, empReq, cost, wage, empReq, out, dos, doe, nam);
//    			Project pro = new Project(null,doe, nam, empReq, cost, wage, empReq, out, dos, doe, nam);
//    			Project pro = new Project(null,nam,cost,wage,empReq,cost, dos,null,curBDO, nam);
    			Project pro = new Project();
    		pro.setProjectName(nam);
    		pro.setTaotalBudget(empReq);
    		pro.setWagePerEmp(wage);
    		pro.setRequiredEmployee(empReq);
    		pro.setStartingDate(out);
    		pro.setEndDate(out);
    		
//    			funBDO.createProject(pro);
//    			funBDO.createProject(pro);
    			BDOfunction.createProject(pro);
    	    break;
    	  case "2":
    		//Viewing project list
    		  System.out.println("\r\n"+"The Project List"+"\r\n"+"--------------------------------------------");
    		 List<Project> poj = funBDO.viewProjectList(curBDO);
    		  
    		  for (Project projecTbean : poj) {
				System.out.println(projecTbean);
			}
    		  
    	    break;
    	  case "3":
    		//Adding new Gramp Pancayat member
    			System.out.println("\r\n"+"Creating new Gram Pancahyat Memeber Account");
    			System.out.println("Enter Name");
    			String name = sc.next();
    			System.out.println("Enter Username");
    			String user = sc.next();
    			System.out.println("Enter Password");
    			String pass = sc.next();
    		
    			GpmMember gpm1 = new GpmMember( null,name, user, pass,curBDO, null);
    			
    			
//    			funBDO.insertGPM(gpm1);
    			funBDO.insertGPM(null);
    			
    	    break;
    	  case "4":
    		//viewing list of gpm
    			System.out.println("\r\n"+"The Gram Panchayat Member List"+"\r\n"+"----------------------------------------");
    			List<GpmMember> gpmList = funBDO.viewGPMList();
    			
    			for (GpmMember gpMbean : gpmList) {
    				System.out.println(gpMbean);
    			}
    	    break;
    	  case "5":
    		//Allocating project
    		  funBDO.projAandGpm(curBDO);
    	    break;
    	  case "6":
    		//Viewing employe and working employee on that project
    		  System.out.println("\r\n");
    		  funBDO.showproOption();
    	    break;
    	  case "99":
//    		  Going to main method
    		 rev = false;
    		 mnPortal();
    		  curGPM=null;
    		  curBDO=null;
    	    break;
      	  case "0":
//    		closing app
      		  rev = false;
      		sc.close();
    		funBDO.sc.close();
    		System.out.println("Exited...");
    	    break;
    	  default:
    		  System.out.println("!!!Invalid selection!!!");
    		  bdofunctiond(); 
    	}
    	
//    	Return to main function again
    	if(rev) {
    	bdofunctiond();
    	}

    }
    
    
    public static GpmFunctions funGpm  = new GpmFunctions();
    
//GPM portal
    public static void gpmPortal() {
    	
    	System.out.println("***Welcome To Gram Panchayat Member Portal***\r\n"
    			+ "\r\n"
    			+ "Type 1 To Login"
    			+ "\r\n"
    			+ "Type 99 To Main Portal");
    	
    	 String out = sc.next();
    	
    	if(out.equals("1")) {
    		//Login into Gram Panchyat Member account
    		System.out.println("\r\n"+"Login into the Gram Panchyat Member portal");
    		System.out.println("Enter Username");
    		String user = sc.next();
    		System.out.println("Enter Password");
    		String pass = sc.next();
    		
    	    boolean flag = funGpm.loginGPM(user, pass);
    	    if(flag) {
    	    	gpmFunction();
    	    }else {
    	    	System.out.println("\n");
    	    	gpmPortal();	
    	    }
    	}else if(out.equals("99")) {
              mnPortal();
    	}else {
    		System.out.println("\r\n"+"!!!Invalid selection!!!");
    		gpmPortal();
    	}
    	
    }
    
//GPM functions
    public static void gpmFunction() {
    	
    	boolean rev = true;
    	
    	System.out.println("\r\n"
    			+"Type 1 to Create Enployee \r\n"
    			+ "Type 2 to View List of Employee\r\n"
    			+ "Type 3 to Assign Employee To Project\r\n"
    			+ "Type 4 to View Employee And Number Of Days Worked\r\n"
    			+ "Type 99 to Go To Main Protal\r\n"
    			+ "Type 0 To Exit The Application");
    	
    	String out = sc.next();
    	
    	switch (out)
    	{
    	  case "1":
    		//Creating the new employee
    			System.out.println("\r\n"+"Adding the new employee");
    			System.out.println("Enter the name of employee");
    			String name = sc.next();
    			
    	Employee emp1 = new Employee(name, name, out, 0, 0, name, name);
    	
    			funGpm.createEmployee(emp1);
    			
    	    break;
    	  case "2":
    		//get all emplyess list 
    			System.out.println("\r\n"+"Employees List"+"\r\n"+"---------------------------");
    			List<Employee> empList =GpmFunctions.viewEmployeeList();
    			System.out.println("The List of The Eployees");
    			
    			for (Employee employeEbean : empList) {
    				System.out.println(employeEbean);
    			}
    			
    	    break;
    	  case "3":
    		
    		  System.out.println("\r\n");
    			GpmFunctions.aviaProjAndEmp(curGPM);
    	    break;
    	  case "4":
    		//Viewing the employee list and days of works
    		  System.out.println("\r\n"+"The List Of Gram Panchyat Mebers"+"/r/n"+"-----------------------------------");
    			GpmFunctions.showproOption();
    	    break;
    	  case "99":
//      		going to main portal
    		  rev = false;
    		  mnPortal();
    		  curGPM=null;
    		  curBDO=null;
      	    break;  
    	  case "0":
//    	
    	   rev = false;
       	   System.out.println("Exited..");
       	   sc.close();
//       	   functionsOfGPM.sc.close();
//       	   gpmFunction.sc.close;
       	   
    	    break;  
    	  default:
    		  System.out.println("!!!Invalid selection!!!");
    		  gpmFunction();
    	    break;
    	}
//    	return to main function
    	if(rev) {
    	 gpmFunction();
    	}
    	
    }
    
	
	
	
}
