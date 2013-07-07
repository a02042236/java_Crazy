package sub;

public class PackageTest  
{
	public static int callerNum;
	private static String[] callerNames = new String[100];

	private String callerName;
	
	public PackageTest(String _callerName)
	{
		callerName = _callerName;
		callerNames[callerNum]= callerName;
		callerNum ++;
	}

	public String getCallerName()
	{
		return callerName;
	}

	public void printCallerName()
	{
		System.out.println(callerName);
	}

	public static void printAllCallers()
	{
		System.out.println(callerNum);

		for(String caller : callerNames)
		{
			if (caller != null)
			{
				System.out.println(caller);
			}			
		}
	}
}