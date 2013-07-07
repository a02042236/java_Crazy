
import java.util.*;
/**
通过多态可以使父类指向不同的子类，然后父类调用相同的方法名，但是实施上调用的是不同子类的方法。
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
		System.out.println("画矩形");
	}
}

class Circle extends Shape 
{
	String name = "Circle";
	@Override
	public void draw() 
	{
		System.out.println("画圆形");
	}
}
 
class Triangle extends Shape  //三角形并没有重写父类的draw方法！
{
	String name = "Triangle";
}

class ShapeDemo  //自动生成各种形状的机器
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
		Shape[] shapes = new Shape[10]; //编译时为父类
		
		for(int i = 0; i < shapes.length; i++)
		{
			shapes[i] = shapeDome.createShape(); //运行时指向了子类
		}

		for(int i = 0; i < shapes.length; i++)
		{
			shapes[i].draw();	//对于方法，调用还是子类的方法， 方法被子类重写了；
								//但是对于Triangle这个类，由于没有重写，调用的就是父类的方法了。
		}

		for(int i = 0; i < shapes.length; i++)
		{
			System.out.println(shapes[i].name); //对于Feild并不会存在重写的情况，调用的还是父类的Feild
		}
	}
}