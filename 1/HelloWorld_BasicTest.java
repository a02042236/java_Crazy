public class HelloWorld_BasicTest
{
	
	public static void main(String[] args)
	{
		int nice = 0;
		char b = '��';
		int bina = 0b1111_1111_1111_1111_1111_1111_1111_1110; // 0000000000000001
		System.out.println("Hello World!");
		System.out.print(bina);
		System.out.println(b);
		System.out.println(true + " nice");

		/**/
		String val = "45";
		System.out.println(Integer.parseInt(val));
		val = "bf";
		System.out.println(Integer.parseInt(val, 16));

		/**/
		short uval = 74;
		//uval = uval - 2; //HelloWorld_BasicTest.java:22: ����: ������ʧ����
		System.out.println(uval - 2);

		/**/
		System.out.println("" + null);

		/*
		Infinity
		-Infinity
		NaN
		*/
		System.out.println(32.0/0);
		System.out.println(-32.0/0);
		System.out.println(0.0/0);

		/*��λ*/
		short sa = 13;
		int ia = sa >> 2;
		System.out.println(ia);

		/*��λ*/
		short sa2 = 13;
		sa2 >>= 2;
		System.out.println(sa2);
	}
}