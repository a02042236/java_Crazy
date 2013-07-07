public class NewStringClass
{
	private String sentence;

	/**
	*获得该字符的长度，英文符号为1个字节，其他字符为２个字节
	*/
	private int getByteNum(char c)
	{
		return  ((c < 0x00FF)&&(c > 0x0000)) ? 1 : 2; 
	}

	/**
	*获得字符的低字节
	*/
	private char getLowByte(char c)
	{
		c &= 0x00FF;
		return c;
	}

	/**
	*获取字符串的字节字串；
	×从pos起始的字节符，长度为length的子串. 非英文符号，比如中文要占两个位置。
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

				if (newOneLength == 2) // 一个字符占了两个Byte时，总共要获取的字符数减去一
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
		newString.sentence = "hks好lo world!";

		String sub;

		sub = newString.getSentenceSubString(1, 5);

		System.out.println(sub);
	}

	

}