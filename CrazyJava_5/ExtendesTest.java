

class father
{
	String a = "father string";
}

class son extends father
{
	private String a = "son string";
}



public class ExtendsTest
{

	public static void main()
	{
		son Jonh = new son();

		System.out.println(Jonh.a);

		System.out.println(father.a);
	}

}
