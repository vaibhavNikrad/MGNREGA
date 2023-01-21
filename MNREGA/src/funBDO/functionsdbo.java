package funBDO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Dashboard.*;

import Beans.*;

import com.masai.util.*;

public class functionsdbo {

	public static Scanner sc = new Scanner(System.in);
	
	
	
//inserting the bdo account
	public static void insertBDO(BDObean bdo1) {
		int out = 0;
		try (Connection conn = DButil.getConnection()){
			
			PreparedStatement inBDO = conn.prepareStatement("INSERT INTO bdoDB(bdoName, bdoUsername, bdoPassword) VALUES(?, ?, ?)");
			
			inBDO.setString(1, bdo1.getName());
			inBDO.setString(2, bdo1.getUsername());
			inBDO.setString(3, bdo1.getPassword());
			
			out = inBDO.executeUpdate();
			
			if(out>0)System.out.println("NEW Block Development Officer Account Crated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	
//Login into the bdo account
	public static boolean loginBDO(String user, String pass) {
		
		boolean flag = false;
		
		try(Connection conn = DButil.getConnection()) {
			
			PreparedStatement logBDO = conn.prepareStatement("SELECT * FROM bdoDB WHERE bdoUsername=? AND bdoPassword=?");
			logBDO.setString(1, user);
			logBDO.setString(2, pass);
			ResultSet bdoAcc = logBDO.executeQuery();
			
			if(bdoAcc.next()) {
				String bdoID = bdoAcc.getString("bdoID");
				String bdoName = bdoAcc.getNString("bdoName");
				System.out.println("\n"+"Log in Sucessfull "+bdoName);
				System.out.println("Your account ID is "+bdoID);
//				current bdo name
				Dashboard.dsahBoard.curBDO= bdoID;
				flag = true;
			}else {
				System.out.println("Invalid Username Or Password");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
	
	
//Creating the projects	
	public static void createProject(PROJECTbean pro1) {
		
		try(Connection conn = DButil.getConnection()) {
			
			String qur = "INSERT INTO projectDB(proName, totalCost, balanceCost, WagePerEmp, employeeRequired, dateOfStart, dateOfEnd, bdoSupervise) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			 
			PreparedStatement crtPro = conn.prepareStatement(qur);
			crtPro.setString(1, pro1.getProName());
			crtPro.setInt(2, pro1.getTotalCost());
			crtPro.setInt(3, pro1.getTotalCost());
			crtPro.setInt(4, pro1.getWagePerEmp());
			crtPro.setInt(5, pro1.getEmployeeRequired());
			crtPro.setString(6, pro1.getDateOfStrat());
			crtPro.setString(7, pro1.getDateOfEnd());
			crtPro.setString(8, pro1.getBdoSupervise());
			
		    int out	 = crtPro.executeUpdate();
		    
		    if(out>0) {
		    	System.out.println(pro1.getProName()+" Project Created");
		    }else {
		    	System.out.println("Project unable to create...");
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
//View the list of the project
	public static List<PROJECTbean> viewProjectList(String curBDO) {
		
		List<PROJECTbean> proList = new ArrayList<PROJECTbean>();
		
		try(Connection conn = DButil.getConnection()) {
			
			PreparedStatement viwProLi = conn.prepareStatement("SELECT * FROM projectDB WHERE bdoSUpervise=?");
			viwProLi.setString(1, curBDO);
			
			ResultSet proj = viwProLi.executeQuery();
			boolean proFlag = true;
			int countOfPro = 0;
			
			while(proj.next()) {
				
				String proID = proj.getString("proID");
				String name = proj.getString("proName");
				int cost = proj.getInt("totalcost");
				int bal = proj.getInt("balanceCost");
				int wag = proj.getInt("WagePerEmp");
                int empReq = proj.getInt("employeeRequired");
                String dos = proj.getString("dateOfStart");
                String doe = proj.getString("dateOfEnd");
                String status = proj.getString("status");
                String bdosup = proj.getString("bdoSupervise");
				
                PROJECTbean pro = new PROJECTbean(proID, name, cost, cost, wag, empReq, dos, doe, status, bdosup);
                
                proList.add(pro);
                
                proFlag = false;
                countOfPro++;
			}
			
			if(proFlag)System.out.println("No Project Is Under Your Supervison. Create A New Project.");
			else System.out.println("Total Numbers OF Projects: "+countOfPro+"\r\n------------------------------------------");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return proList;
	}
	
//Creating garm panchayat member
	public static void insertGPM(GPMbean gpm1) {
		
		try(Connection conn = DButil.getConnection()) {
			
			PreparedStatement inGPM = conn.prepareStatement("INSERT INTO gpmDB(gpmName, gpmUsername, gpmPassword, bdoSupervise) VALUES(?, ?, ?, ?)");
			
			inGPM.setString(1, gpm1.getGpmName());
			inGPM.setString(2, gpm1.getGpmUsername());
			inGPM.setString(3, gpm1.getGpmPassword());
			inGPM.setString(4, gpm1.getBdoSupervise());
			
			int out = inGPM.executeUpdate();
			
			if(out>0)System.out.println("\n"+"New Gram Panchayat Member Account Added");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
//Viewing the gram pancayat member list
	public static List<GPMbean> viewGPMList(){
		
		List<GPMbean> gpmList = new ArrayList<GPMbean>();
		
		try(Connection conn = DButil.getConnection()) {
			
			PreparedStatement viwGpm = conn.prepareStatement("SELECT * FROM gpmDB");
			
			ResultSet gpm = viwGpm.executeQuery();
			
			boolean gpflag = true;
			
			int gpmCount = 0;
			
			while(gpm.next()) {
				
				String gpmID = gpm.getString("gpmID");
				String gpmName = gpm.getString("gpmName");
				String gpmUser = gpm.getString("gpmUsername");
				String gpmpass = gpm.getString("gpmPassword");
				String bdo = gpm.getNString("bdoSupervise");
				String pro = gpm.getString("proAllot");
				
				GPMbean gpm1 = new GPMbean(gpmID, gpmName, gpmUser, gpmpass, bdo, pro);
				
				gpmList.add(gpm1);
				
				gpflag = false;
				
				gpmCount++;
			}
			
			if(gpflag)System.out.println("No Gram Panchayat Member Avialable");
			else System.out.println("Total Numbre Of Gram Panchayat Members: "+gpmCount+"\r\n----------------------------------------------");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return gpmList;
	}
	
//Alloting the project. It will display project ID and name ti choose from.
	public static void projAandGpm(String curBDO) {
		
//		Displaying the project available and not finshed
		try(Connection conn = DButil.getConnection()) {
			
			System.out.println("\n"+"This projects are avialbe to allot who have budget and either work in progress or not started and Not Alloted.");
			
			PreparedStatement proAc = 
		   conn.prepareStatement("SELECT proID, proName FROM projectDB WHERE NOT proID = ANY (SELECT proAllot FROM gpmDB WHERE proAllot IS NOT NULL) AND balanceCost>0 AND employeeRequired>0 AND NOT status='done' AND bdoSupervise=?");
			proAc.setString(1, curBDO);
			
			ResultSet proj = proAc.executeQuery();
			System.out.println("ProjID  ProjName");
			System.out.println("------------------");
			
			boolean proFlag = true;
			
			while(proj.next()) {
				System.out.println(proj.getString(1)+"  "+proj.getString(2));
				proFlag = false;
			}
			
			if(proFlag) {
				System.out.println("No Project Reamainaig To allot");
			}
			
			System.out.println("\n"+"This are the Gram Panchayat Members whome project Not alloted.");
			PreparedStatement gpmAc = conn.prepareStatement("SELECT gpmID, gpmName FROM gpmDB WHERE proAllot IS NULL AND bdoSupervise=?");
			gpmAc.setString(1, curBDO);
			
			boolean flag = true;
			
			ResultSet gpm =  gpmAc.executeQuery();
			System.out.println("gpmID   gpmName");
			System.out.println("--------------------");
			
			while(gpm.next()) {
				System.out.println(gpm.getString(1)+" "+gpm.getString(2));
				flag = false;
			}
//			alloting the project
			
			if(flag) {
				System.out.println("No Gram Pnachyat Member Under Your Supervsion");
			}else {
			allotProToGpm();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
//Actually alloting the project	
	public static void allotProToGpm() {
		
		try(Connection conn = DButil.getConnection()) {
			System.out.println("\n"+"Allot the project from above options using Ids");
			System.out.println("Enter the Project ID");
			String proID = sc.next();
			System.out.println("Enter the Gram Panachayt Member ID");
			String gpmID = sc.next();
			PreparedStatement allotpro = conn.prepareStatement("UPDATE gpmDB SET proAllot=? WHERE gpmID=?");
			allotpro.setString(2, gpmID);
			allotpro.setString(1, proID);
			
			int out = allotpro.executeUpdate();
			
			if(out>0)System.out.println("Project Alloted Sucessfully");
			else System.out.println("Invalid project id or gpm Id");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
//list of employee working on project and their salary	
//	options of project
	public static void showproOption() {
		
    try(Connection conn = DButil.getConnection()) {
			
			System.out.println("This projects are avialbe to allot who have budget and either work in progress or not started.");
			
			PreparedStatement proAc = conn.prepareStatement("SELECT proID, proName FROM projectDB");
			ResultSet proj = proAc.executeQuery();
			System.out.println("ProjID  ProjName");
			System.out.println("------------------");
			while(proj.next()) {
				System.out.println(proj.getString(1)+"  "+proj.getString(2));
			}

			System.out.println("\n"+"Enter the Project Id");
			String proCurr = sc.next();
			listOfempProSal(proCurr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void listOfempProSal(String proCurr) {
		try(Connection conn = DButil.getConnection()) {
			
	System.out.println("\n"+"This projects are avialbe to allot who have budget and either work in progress or not started.");
			
			PreparedStatement proAc =
			conn.prepareStatement(" SELECT employeeDB.empID, employeeDB.empName, employeeDB.wageEarned  FROM employeeDB CROSS JOIN projectDB WHERE projectDB.proID=employeeDB.proWorking AND projectDB.proID=?");
			proAc.setString(1, proCurr);
			ResultSet proj = proAc.executeQuery();
			System.out.println("Following are the employee working on project id "+proCurr+"\n");
			System.out.println("EmpID  empName   wageEarned");
			System.out.println("-----------------------------");
			while(proj.next()) {
				System.out.println(proj.getString(1)+"  "+proj.getString(2)+"  "+proj.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
