package CharitySoftware.Classes;

public class Student extends User
{
	
	private int studentID;
	
	public Student(String u, int s) 
	{
		super(u);
		studentID = s;
	}
	
	public int GetStudentID () {return studentID;}
}
