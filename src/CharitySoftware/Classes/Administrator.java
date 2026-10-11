package CharitySoftware.Classes;

public class Administrator extends User
{
	private boolean boardMemberAccess;
	public Administrator(String u, boolean b)
	{
		super(u);
		boardMemberAccess=true;
	}
	
	public boolean HasBoardAccess()
	{
	return boardMemberAccess;
	}
}
