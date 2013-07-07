import fruit.Fruit;
import static fruit.Fruit.classInfo;

public class Banana extends Fruit
{
	String BananaBoss = "Boss";

	public Banana(int _weight)
	{	
		super(_weight, "Banana"); //���ø���Ĺ�����
		BananaBoss = "MT";
	}

	public Banana(String name)	//����ø��������޲����Ĺ�����
	{	
		BananaBoss = "MT";
	}

	public void info() //��д�������ʵ������
	{
		System.out.println("It's a banana~!" + BananaBoss);
	}

	public void callFatherInfoMethod()
	{
		super.info();	//������ʵ���е��� �����ʵ��������
	}

	public static void printSuperClassInfo()
	{
		Fruit.classInfo(); //���е��ø��౻���صķ�����
	}

	public static void classInfo() //��д�˸����classInfo������
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
		
		((Fruit)b).classInfo(); //ת��Ϊ����֮����÷��� //calssType:Fruit  
		Fruit.classInfo(); //���е���  //calssType:Fruit  

		Banana a = new Banana("Banana");
		a.callFatherInfoMethod();  //weight:0  name:Unkown
		a.info(); //It's a banana~!MT
	}
}