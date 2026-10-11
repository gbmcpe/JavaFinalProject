package CharitySoftware.Classes;

import CharitySoftware.Windows.jfMain;

public class DatabaseSession 
{

	private User activeUser;
	private SQLiteConnector conn;
	private jfMain appWindow;

	
	public DatabaseSession()
	{
		conn =  new SQLiteConnector();

		ConnectToDatabase();
	}
	
	public boolean ConnectToDatabase()
	{
		return conn.EstablishConnection();
	}
	
	public boolean CheckConnection()
	{
		return conn.getIsConnected();
	}
	
	public StudentRecord PullRecord(int StudentID) 
	{
		return conn.LoadRecord(StudentID);
	}
	
	public boolean LogIn(String u, String p)
	{
		
		activeUser = conn.ValidateLogin(u, p);
		
		if (activeUser != null) {return true;}
		else {return false;}
		
	}
	
	public void LogOut()
	{
		
	}
	
	public int getSessionType()
	{

		if (activeUser.getClass().equals("class CharitySoftware.Classes.Guest"))
		{return 0;}
		else if (activeUser.getClass().equals("class CharitySoftware.Classes.Student"))
		{return 1;}
		else if (activeUser.getClass().equals("class CharitySoftware.Classes.Administrator"))
		{return 2;}
		else return -1;
	
	}
	
}
