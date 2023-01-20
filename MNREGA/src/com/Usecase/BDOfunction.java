package com.Usecase;


import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.Model.BDO;
import com.Model.GpmMember;
import com.Model.Project;
import com.Utility.DBUtil;


public class BDOfunction {

	public static Scanner sc = new Scanner(System.in);
	
	
	
//inserting the bdo account
	public static void insertBDO(BDO bdo) {
		int out = 0;
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement inBDO = conn.prepareStatement("INSERT INTO bdoDB(bdoid, bdoUsername, bdoPassword) VALUES(?, ?, ?)");
			
			inBDO.setLong(1, bdo.getBdoid());
			inBDO.setString(2, bdo.getBdoUsername());
			inBDO.setString(3, bdo.getBdoPassword());
			
			out = inBDO.executeUpdate();
			
			if(out>0)System.out.println("NEW Block Development Officer Account Crated");
			
		} catch (SQLException e) {
	
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	
//Login into the bdo account
	public static boolean loginBDO(String user, String pass) {
		
		boolean flag = false;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
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
//				Dashboard.dsahBoard.curBDO= bdoID;
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
	public static void createProject(Project prt) {
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			String res = "INSERT INTO projectDB(projectName, taotalBudget, balanceAmt, wagePerEmp, requiredEmployee, startingDate, endDate, bdoName) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			 
			PreparedStatement pr = conn.prepareStatement(res);
			pr.setString(1,prt.getProjectName() );
			pr.setInt(2, prt.getTaotalBudget());
			pr.setInt(3, prt.getBalanceAmt());
			pr.setInt(4,prt.getWagePerEmp());
			pr.setInt(5,prt.getRequiredEmployee());
			pr.setString(6,prt.getStartingDate());
			pr.setString(6, prt.getEndDate());
			pr.setString(7,prt.getBdoName());

		    int out	 = pr.executeUpdate();
		    
		    if(out>0) {
		    	System.out.println(prt.getProjectName()+" Project Created");
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
	public static List<Project> viewProjectList(String curBDO) {
		
		List<Project> proList = new ArrayList<Project>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM projectDB WHERE bdoSUpervise=?");
			ps.setString(1, curBDO);
			
			ResultSet proj = ps.executeQuery();
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
				
//                Pro pro = new PROJECTbean(proID, name, cost, cost, wag, empReq, dos, doe, status, bdosup);
                
                Project pro = new Project();
                
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
	public static void insertGPM(GpmMember gpm) {
		
		try(Connection conn =DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO gpmDB(gname, gpmusername, gpmpass, bdoNo) VALUES(?, ?, ?, ?)");
			
			ps.setString(1,gpm.getGname() );
			ps.setString(2,gpm.getGpmusername());
			ps.setString(3,gpm.getGpmpass());
			ps.setString(4, gpm.getBdoNo());
			
		
			
			int res = ps.executeUpdate();
			
			if(res>0)System.out.println("\n"+"New Gram Panchayat Member Account Added");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}

