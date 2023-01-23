
package com.Control;

//This will provide all the main services to navigate the db main

import java.util.*;

import com.BDOusecase.*;
import com.ConsoleColor.ConsoleColors;
import com.GPMusecase.*;
import com.Model.*;

public class ComtrolMain {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static functionsdbo funBDO = new functionsdbo();
	
	public static void main(String[] args) {
		mnPortal();
	}
	
//	Current BDO or GPM to be remember
	public static String curBDO = null;
	public static String curGPM = null;

  	
    /**
     * 
     */
    /**
     * 
     */
    public static void mnPortal() {

    	System.out.print(ConsoleColors.GREEN_BOLD+
		 		 "+============================================+"+"\n"
		 	    +"|          Welcome to MNREGA portal          |"+"\n"
		 	    +"+============================================+"+"\n"
		        +"|                                            |"+"\n"
				+"|  1. to acess as BLOCK DEVELOPMENT OFFICER  |"+"\n"
				+"|  2. to acess as GRAM PANCAYAT MEMBER       |"+"\n"
				+"|  3. Exit the application                   |"+"\n"
				+"|                                            |"+"\n"
				+"+============================================+"+"\n"
				+ConsoleColors.RESET);
    	
    	 String out = sc.next();
    	 
    	 if(out.equals("1")) {
    		 bdoPotal();
    	 }else if(out.equals("2")) {
    		 gpmPortal();
    	 }else if(out.equals("0")) {
	    		sc.close();
	    		funBDO.sc.close();
	    		System.out.println(ConsoleColors.RED_BOLD+"Exited..."+ConsoleColors.RESET);
    	 }else {
    		 System.out.println(ConsoleColors.RED_BACKGROUND+"!!!Invalid selection!!!"+ConsoleColors.RESET);
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
    	      
    	      if(funBDO.loginBDO(user, pass)) {
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
 			
 			BDObean bdo1 = new BDObean(null, nam, user, pass);
 			
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
    		 System.out.println(ConsoleColors.RED_BACKGROUND+"!!!Invalid selection!!!"+ConsoleColors.RESET);
    		 bdoPotal();
    	 }
    	
    }
    
    public static void bdofunctiond() {
    	
    	boolean rev = true;

    	System.out.print(ConsoleColors.GREEN_BOLD+
		 		 "+================================================+"+"\n"
		 	    +"|             Welcome to BDO portal              |"+"\n"
		 	    +"+================================================+"+"\n"
		        +"|                                                |"+"\n"
				+"|  1. Create project                             |"+"\n"
				+"|  2. View the project                           |"+"\n"
				+"|  3. create Gram Panchayat Member               |"+"\n"
				+"|  4. View Gram Panchayat Member                 |"+"\n"
				+"|  5. View the project                           |"+"\n"
				+"|  6. Allocate Project To GPM                    |"+"\n"
				+"|  7. See The Employee Working, wage On Project |"+"\n"
				+"|  0. Exit The Application                       |"+"\n"
				+"|                                                |"+"\n"
				+"+================================================+"+"\n"
				+ConsoleColors.RESET);
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
    	
    			PROJECTbean pro = new PROJECTbean(null, nam, cost, cost, wage, empReq, dos, doe, null, curBDO);
    			funBDO.createProject(pro);
    	    break;
    	  case "2":
    		//Viewing project list
    		  System.out.println("\r\n"+"The Project List"+"\r\n"+"--------------------------------------------");
    		  List<PROJECTbean> poj = funBDO.viewProjectList(curBDO);
    		  
    		  for (PROJECTbean projecTbean : poj) {
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
    		
    			GPMbean gpm1 = new GPMbean(null, name, user, pass, curBDO, null);
    			funBDO.insertGPM(gpm1);
    			
    	    break;
    	  case "4":
    		//viewing list of gpm
    			System.out.println("\r\n"+"The Gram Panchayat Member List"+"\r\n"+"----------------------------------------");
    			List<GPMbean> gpmList = funBDO.viewGPMList();
    			
    			for (GPMbean gpMbean : gpmList) {
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
    
    
    public static functionsOfGPM funGpm  = new functionsOfGPM();
    
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
    			
    			EMPLOYEEbean emp1 = new EMPLOYEEbean(null, name, null, 0, 0, curGPM, null);
    			funGpm.createEmployee(emp1);
    			
    	    break;
    	  case "2":
    		//View the list of employee
    			System.out.println("\r\n"+"Employees List"+"\r\n"+"---------------------------");
    			List<EMPLOYEEbean> empList =funGpm.viewEmployeeList();
    			System.out.println("The List of The Eployees");
    			
    			for (EMPLOYEEbean employeEbean : empList) {
    				System.out.println(employeEbean);
    			}
    			
    	    break;
    	  case "3":
    		//Assign project to employee;	
//    			list of project available
    		  System.out.println("\r\n");
    			funGpm.aviaProjAndEmp(curGPM);
    	    break;
    	  case "4":
    		//Viewing the employee list and days of works
    		  System.out.println("\r\n"+"The List Of Gram Panchyat Mebers"+"/r/n"+"-----------------------------------");
    			funGpm.showproOption();
    	    break;
    	  case "99":
//      		going to main portal
    		  rev = false;
    		  mnPortal();
    		  curGPM=null;
    		  curBDO=null;
      	    break;  
    	  case "0":
//    		Closig the app
    	   rev = false;
       	   System.out.println("Exited..");
       	   sc.close();
       	   functionsOfGPM.sc.close();
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

