
import java.util.*;
/**
ͨ����̬����ʹ����ָ��ͬ�����࣬Ȼ���������ͬ�ķ�����������ʵʩ�ϵ��õ��ǲ�ͬ����ķ�����
*/

class Shape 
{
	String name = "Shape";
	public void draw()
	{
		System.out.println("Shape.draw()");
	}
}

class Rectangle extends Shape 
{
	String name = "Rectangle";
	@Override
	public void draw() 
	{
		System.out.println("������");
	}
}

class Circle extends Shape 
{
	String name = "Circle";
	@Override
	public void draw() 
	{
		System.out.println("��Բ��");
	}
}
 
class Triangle extends Shape  //�����β�û����д�����draw������
{
	String name = "Triangle";
}

class ShapeDemo  //�Զ����ɸ�����״�Ļ���
{   
	Random rand = new Random();   
	public  Shape createShape()
	{   
		int c = rand.nextInt(3);   
		Shape s = null;   
		switch(c)
		{   
		case 0:   
			s = new Rectangle();   
			break;   
		case 1:   
			s = new Circle();   
			break;   
		case 2:   
			s = new Triangle();   
			break;   
		}

		return s;   
	}
}   

public class PloyTest 
{
	public static void main(String[] args)
	{
		ShapeDemo shapeDome = new ShapeDemo();
		Shape[] shapes = new Shape[10]; //����ʱΪ����
		
		for(int i = 0; i < shapes.length; i++)
		{
			shapes[i] = shapeDome.createShape(); //����ʱָ��������
		}

		for(int i = 0; i < shapes.length; i++)
		{
			shapes[i].draw();	//���ڷ��������û�������ķ����� ������������д�ˣ�
								//���Ƕ���Triangle����࣬����û����д�����õľ��Ǹ���ķ����ˡ�
		}

		for(int i = 0; i < shapes.length; i++)
		{
			System.out.println(shapes[i].name); //����Feild�����������д����������õĻ��Ǹ����Feild
		}
	}
}