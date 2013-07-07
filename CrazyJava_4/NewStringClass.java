public class NewStringClass
{
	private String sentence;

	/**
	*��ø��ַ��ĳ��ȣ�Ӣ�ķ���Ϊ1���ֽڣ������ַ�Ϊ�����ֽ�
	*/
	private int getByteNum(char c)
	{
		return  ((c < 0x00FF)&&(c > 0x0000)) ? 1 : 2; 
	}

	/**
	*����ַ��ĵ��ֽ�
	*/
	private char getLowByte(char c)
	{
		c &= 0x00FF;
		return c;
	}

	/**
	*��ȡ�ַ������ֽ��ִ���
	����pos��ʼ���ֽڷ�������Ϊlength���Ӵ�. ��Ӣ�ķ��ţ���������Ҫռ����λ�á�
	*/
	public String getSentenceSubString(int pos, int length )
	{
		String sub = new String();
		char newOne;
		int newOneLength;
		for (int i = 0 ; i < length; i ++)
		{
			newOne = sentence.charAt(i + pos);
			newOneLength = getByteNum(newOne); 

			if (newOneLength + i <= length)
			{
				sub = sub + newOne;

				if (newOneLength == 2) // һ���ַ�ռ������Byteʱ���ܹ�Ҫ��ȡ���ַ�����ȥһ
				{
					length --;
				}
			}
			else
			{
				sub = sub + getLowByte(newOne);
			}		
			
		}
	
		return sub;
	}

	public static void main(String[] args)
	{
		NewStringClass newString = new NewStringClass();
		newString.sentence = "hks��lo world!";

		String sub;

		sub = newString.getSentenceSubString(1, 5);

		System.out.println(sub);
	}

	

}