
/*this is a example for extends*/
public class MyFruit
{
	int weight;
	String name;
	static String calssType = "Fruit";

	public MyFruit()
	{
		weight = 0;
		name = "Unkown";
	}

	public MyFruit(int _weight, String _name)
	{
		setWeight(_weight);
		setName(_name);
	}

	public void setWeight(int _weight)
	{
		this.weight = _weight;
	}
	
	public void setName(String _name)
	{
		this.name = _name;
	}

	public void info()
	{
		System.out.println("weight:" + weight + "\n" + "name:" + name);
	}

	public static void classInfo()
	{
		System.out.println("calssType:" + calssType + "\n");
	}

	public static void main(String[] args)
	{
	
		MyFruit a = new MyFruit(3, "apple");

		a.info();

		classInfo();
	}

}


