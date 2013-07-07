/*this is a example for extends*/

public class Apple extends MyFruit
{
	static String typeName = "apple";	

	public void setName() //重写，覆盖了父类的setName
	{
		this.name = typeName;
	}

	public void setName(String _name)
	{
		this.setName();
	}

	public static void main(String[] args)
	{
	
		Apple appleA = new Apple();
		MyFruit a = new MyFruit(3, "peach");

		a.info();

		appleA.info();

		appleA.setName();
		appleA.setWeight(1);
		appleA.info();
		
		MyFruit.classInfo();
	}
}