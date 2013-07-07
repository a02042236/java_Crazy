import fruit.Fruit;
import static fruit.Fruit.classInfo;

public class Banana extends Fruit
{
	public Banana(int _weight)
	{	
		setWeight(_weight);
		setName("Banana"); 
		
	}

	public void info()
	{
		System.out.println("It's a banana~!");
	}

	public void printSuperClassInfo()
	{
		super.classInfo(); //实例中调用
	}


	public static void classInfo()
	{
		System.out.println("Banana!");
	}


	public static void  main(String[] args)
	{
		Banana b = new Banana(3);

		b.info();
		b.printSuperClassInfo();

		Banana.classInfo();
		classInfo();
		
		Fruit.classInfo(); //类中调用

	}


}