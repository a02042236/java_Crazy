import sub.PackageTest;
import static sub.PackageTest.*; //导入了类的feild和方法

/**
* 2013.06.26 一个基本的类构造以及使用: class MyPersonClass
*/
public class MyPerson
{
	public static void main(String args[])
	{
		/*构造实例*/
		MyPersonClass Xiaolei = new MyPersonClass(18, "xiaolei", "male");
		MyPersonClass Wangbao = new MyPersonClass(28, "Wangbao", "female");

		/*调用实例的方法*/
		System.out.println(Xiaolei.getSex());	//male

		/*实例可以调用类的方法*/
		System.out.println(Xiaolei.getPersonNum());	//male

		/*通过类调用类的方法*/
		System.out.println(MyPersonClass.getPersonNum()); //2

		/*访问实例的field*/
		Xiaolei.age ++;
		System.out.println(Xiaolei.getAge());	//19
		System.out.println(Wangbao.getAge());	//28 Wangbao的年龄没有发生变化

		//Xiaolei.sex = "female";  //私有变量只能在类中访问，外部调用无法访问。
		System.out.println(Xiaolei.getSex());	//male

		/** 类之间的赋值，本质上是类似于指针的赋值。
		*/
		MyPersonClass XiaoleiCopy = Xiaolei; //XiaoleiCopy 和　Xiaolei指向同一个对象，
		XiaoleiCopy.name = "newXiaolei";	//对XiaoleiCopy的操作将会影响Xiaolei.
		System.out.println(Xiaolei.getName());	//newXiaolei

		/*释放实例指向的空间*/
		Wangbao = null;

		/**
		* 使用其他包的类
		*/
		PackageTest test = new PackageTest("MyPerson.main");
		test.printCallerName();
		PackageTest.printAllCallers();

		System.out.println(callerNum); // import static sub.PackageTest.*; //导入了类的feild和方法
		System.out.println("End");
	}
}

class MyPersonClass
{
	static int personNum = 0;
	int age;
	String name;
	private String sex;

	public MyPersonClass(int _age, String _name, String _sex)
	{
		age = _age;
		name = _name;
		sex = _sex;
		personNum ++;　// 这是一种非常不好的操作方式，在实例的方法中操作类数据。
	}

	
	public MyPersonClass(int _age, String _name, String _sex)
	{
		this(_age, _name);	//在构造器中调用另外一个构造器
		sex = _sex;
		personNum ++; // 这是一种非常不好的操作方式，在实例的方法中操作类数据。
	}


	public void printInfo()
	{
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("sex:" + sex);
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		System.out.println("in getAge: " + getName());
		return age;
	}

	public String getSex()
	{
		return sex;
	}

	static int getPersonNum()
	{
		//printInfo();　类方法无法调用实例方法。你到底是要打印Xiaolei的呢还是Wangbao的呢？
		return personNum;
	}
}