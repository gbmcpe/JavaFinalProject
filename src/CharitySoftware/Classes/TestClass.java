package CharitySoftware.Classes;

public class TestClass {

	public static void main(String[] args) 
	{
		Administrator admin = new Administrator("123", false);
		System.out.println(admin.getClass());
		Guest guest = new Guest();
		System.out.println(guest.getClass());
		Student student = new Student("John", 1245);
		System.out.println(student.getClass());
		
		DatabaseSession db = new DatabaseSession();
		
		StudentRecord testcase = db.PullRecord(11);
		
		
	}

}
