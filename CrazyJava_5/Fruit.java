package fruit;

/*this is a example for extends*/
public class Fruit
{
	int weight;
	String name;
	static String calssType = "Fruit";

	public Fruit()
	{
		weight = 0;
		name = "Unkown";
	}

	public Fruit(int _weight, String _name)
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
	
		Fruit a = new Fruit(3, "apple");

		a.info();

		classInfo();
	}

}


