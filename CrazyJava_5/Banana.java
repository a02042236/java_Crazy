import fruit.Fruit;
import static fruit.Fruit.classInfo;

public class Banana extends Fruit
{
	String BananaBoss = "Boss";

	public Banana(int _weight)
	{	
		super(_weight, "Banana"); //调用父类的构造器
		BananaBoss = "MT";
	}

	public Banana(String name)	//会调用父类里面无参数的构造器
	{	
		BananaBoss = "MT";
	}

	public void info() //重写父类里的实例方法
	{
		System.out.println("It's a banana~!" + BananaBoss);
	}

	public void callFatherInfoMethod()
	{
		super.info();	//用于在实例中调用 父类的实例方法。
	}

	public static void printSuperClassInfo()
	{
		Fruit.classInfo(); //类中调用父类被隐藏的方法。
	}

	public static void classInfo() //重写了父类的classInfo方法。
	{
		System.out.println("Banana!");
	}

	public static void  main(String[] args)
	{
		Banana b = new Banana(3);

		b.info(); //It's a banana~!MT
		b.callFatherInfoMethod(); //weight:3 name:Banana
		b.printSuperClassInfo(); //calssType:Fruit

		classInfo(); //Banana!
		
		((Fruit)b).classInfo(); //转换为父类之后调用方法 //calssType:Fruit  
		Fruit.classInfo(); //类中调用  //calssType:Fruit  

		Banana a = new Banana("Banana");
		a.callFatherInfoMethod();  //weight:0  name:Unkown
		a.info(); //It's a banana~!MT
	}
}