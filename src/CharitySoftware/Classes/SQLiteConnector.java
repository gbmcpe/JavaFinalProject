package CharitySoftware.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLiteConnector 
{
	
	private Connection connection;
	
	boolean IsConnected = false;
	
	public boolean getIsConnected()
	{return IsConnected;}
	
	public boolean EstablishConnection()
	{
				
		String jdbcURL = "jdbc:sqlite:SQLite/CharityDB.db";
		
		try
		{
		connection = DriverManager.getConnection(jdbcURL);
		System.out.println("Connection Successful");
		IsConnected =true;
		return true;
		
		}
		catch (SQLException e)
		{
		System.out.println("Can’t connect to the database!");
		e.printStackTrace();
		return false;
		}
	}
	
	public User ValidateLogin(String u, String p)
	{
		String sql ="SELECT Username, PasswordValue, StudentID, IsAdministrator FROM Users WHERE Username = ?";
		System.out.println(sql);
		
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, u);
	        
	        	ResultSet result = pstmt.executeQuery();
	            if (result.next()) 
	            {
	            	
	                String dbUsername = result.getString("Username");
	                String dbPassword = result.getString("PasswordValue");
	                int dbStudentID = (result.getInt("StudentID"));
	                boolean dbIsAdmin = result.getBoolean("IsAdministrator");
	         
	                if (dbUsername.equals(u) && dbPassword.equals(p)) 
	                {
	                    
	                	if(dbStudentID != 0) 
	                	{
	                		Student student = new Student(dbUsername, dbStudentID);
	                		return student;
	                	}
	                	else if(dbIsAdmin) 
	                	{
	                		Administrator admin = new Administrator(dbUsername, true);
	                	}
	                	else return null;
	   
	                }
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }
	    
		
		return null;
		
	}
	
	public StudentRecord LoadRecord(int studentID) 
	{
		String sql ="SELECT st.fullName, sc.Name as PrimarySchool, st.Bio, st.ImagePath, st.Email, st.Phone, st.BecameUniversityStudent, uc.Name as University, st.UniversityGraduateYear, st.MajorOrInterest FROM Students st JOIN Schools sc ON st.SchoolID = sc.SchoolID JOIN Schools uc ON st.UniversitySchoolID = uc.SchoolID WHERE StudentID = ?";
		
		
		

		System.out.println(sql);
		
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, Integer.toString(studentID));
	        
	        	ResultSet result = pstmt.executeQuery();
	            if (result.next()) 
	            {
	                String dbFullName = result.getString("fullName");
	                String dbPSchool = result.getString("PrimarySchool");
	                String dbBio = result.getString("Bio");
	                String dbImagePath = result.getString("ImagePath");
	                String dbEmail = result.getString("Email");
	                String dbPhone = result.getString("Phone");
	                boolean dbBecameUni = result.getBoolean("BecameUniversityStudent");
	                String dbUni = result.getString("University");
	                int dbUniYear = result.getInt("UniversityGraduateYear");
	                String dbMajor = result.getString("MajorOrInterest");
	                
	                StudentRecord r = new StudentRecord(studentID, dbFullName, dbPSchool, dbBio, dbImagePath, dbBecameUni, dbUni, dbMajor, dbUniYear, dbEmail, dbPhone);
	                
	                return r;
	            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }
		
		return null;
		
	}
	

	
	
	
			
}