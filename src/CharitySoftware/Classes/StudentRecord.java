package CharitySoftware.Classes;

public class StudentRecord 
{
	private int studentID;
	public int GetStudentID() {return studentID;}
	private String fullName;
	public String GetFullName() {return fullName;}
	private String primarySchool;
	public String GetPrimarySchool() {return primarySchool;}
	private String bioParagraph;
	public String GetBioParagraph() {return bioParagraph;}
	private String pictureImagePath;
	public String GetPictureImagePath() {return pictureImagePath;}

	
	
	private boolean isUniversity;
	public boolean GetIsUniversity() {return isUniversity;}
	private String university;
	public String GetUniversity() {return university;}
	private String fieldOfStudy;
	public String GetFieldofStudy() {return fieldOfStudy;}
	private int gradYear;
	public int GetGradYear() {return gradYear;}
	
	private String phoneNumber;
	public String GetPhoneNumber() {return phoneNumber;}
	
	private String email;
	public String GetEmail() {return email;}
	
	
	public StudentRecord(int SI, String FN, String PS, String BIO, String PIC, boolean IsUni, String UNI, String FOS, int GY, String PHN, String EML  )
	{
		studentID = SI;
		fullName = FN;
		primarySchool = PS;
		bioParagraph = BIO;
		pictureImagePath = PIC;
		
		isUniversity = IsUni;
		university = UNI;
		fieldOfStudy =FOS;
		gradYear = GY;
		
		phoneNumber =PHN;
		email = EML;
	}
	
	
}
