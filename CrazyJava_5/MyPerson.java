import sub.PackageTest;
import static sub.PackageTest.*; //���������feild�ͷ���

/**
* 2013.06.26 һ���������๹���Լ�ʹ��: class MyPersonClass
*/
public class MyPerson
{
	public static void main(String args[])
	{
		/*����ʵ��*/
		MyPersonClass Xiaolei = new MyPersonClass(18, "xiaolei", "male");
		MyPersonClass Wangbao = new MyPersonClass(28, "Wangbao", "female");

		/*����ʵ���ķ���*/
		System.out.println(Xiaolei.getSex());	//male

		/*ʵ�����Ե�����ķ���*/
		System.out.println(Xiaolei.getPersonNum());	//male

		/*ͨ���������ķ���*/
		System.out.println(MyPersonClass.getPersonNum()); //2

		/*����ʵ����field*/
		Xiaolei.age ++;
		System.out.println(Xiaolei.getAge());	//19
		System.out.println(Wangbao.getAge());	//28 Wangbao������û�з����仯

		//Xiaolei.sex = "female";  //˽�б���ֻ�������з��ʣ��ⲿ�����޷����ʡ�
		System.out.println(Xiaolei.getSex());	//male

		/** ��֮��ĸ�ֵ����������������ָ��ĸ�ֵ��
		*/
		MyPersonClass XiaoleiCopy = Xiaolei; //XiaoleiCopy �͡�Xiaoleiָ��ͬһ������
		XiaoleiCopy.name = "newXiaolei";	//��XiaoleiCopy�Ĳ�������Ӱ��Xiaolei.
		System.out.println(Xiaolei.getName());	//newXiaolei

		/*�ͷ�ʵ��ָ��Ŀռ�*/
		Wangbao = null;

		/**
		* ʹ������������
		*/
		PackageTest test = new PackageTest("MyPerson.main");
		test.printCallerName();
		PackageTest.printAllCallers();

		System.out.println(callerNum); // import static sub.PackageTest.*; //���������feild�ͷ���
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
		personNum ++;��// ����һ�ַǳ����õĲ�����ʽ����ʵ���ķ����в��������ݡ�
	}

	
	public MyPersonClass(int _age, String _name, String _sex)
	{
		this(_age, _name);	//�ڹ������е�������һ��������
		sex = _sex;
		personNum ++; // ����һ�ַǳ����õĲ�����ʽ����ʵ���ķ����в��������ݡ�
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
		//printInfo();���෽���޷�����ʵ���������㵽����Ҫ��ӡXiaolei���ػ���Wangbao���أ�
		return personNum;
	}
}