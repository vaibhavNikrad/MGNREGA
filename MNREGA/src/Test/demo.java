package Test;

import java.sql.*;
import com.masai.util.*;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Connection conn = DButil.getConnection()) {
			
			PreparedStatement creatTb = conn.prepareStatement("CREATE TABLE  IF NOT EXISTS asfda(col1 int, col2 varchar(20))");

			int outCreatTb = creatTb.executeUpdate();
			
			if(outCreatTb>=0)System.out.println("Table Created OR Already Exist");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
