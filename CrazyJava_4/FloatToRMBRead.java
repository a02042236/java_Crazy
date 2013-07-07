/**
* 2013.06.25 V0.1
*/
public class FloatToRMBRead
{
	/**零在程序中单独处理
	*/
	static String[] numToChineseRead = {"","一","二","三","四","五","六","七","八","九"};
	static String[] indexToJinzhi = {"","十","百","千"};

	private static String getZhengshuRMBString(int num)
	{

		String numString = "" + num, retString = "";
		int currNum,currIndex;
		int zeroFlag = 0; //当有多个零相临时，只念一个零。

		for(int i =  0, numCount = 0; i < numString.length()  ; i ++, numCount ++)	//从高位开始处理
		{
			currNum = Integer.parseInt("" + numString.charAt(i)); //当前这个位的数值
			currIndex = numString.length() - i - 1; //当前这个位数的位置,从０开始

			//System.out.println(currNum + "" + currIndex);

			if (currNum == 0)
			{
				zeroFlag = 1;
				if (currIndex != 0 && currIndex%4 == 0) //当需要添加“万”“亿”这些单位时不能跳过
				{
					;
				}
				else
				{
					continue;
				}
				
			}

			if ((zeroFlag == 1) && (currNum != 0))
			{
				retString = retString + "零"; //添零的动作在此处完成
				zeroFlag = 0;
			}

			switch (currIndex / 4)
			{
			case 0: //0~9999 万以内				
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				break;
			case 1: //1000_0000~9999_9999　亿以内
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				if (currIndex%4 == 0)
				{
					retString = retString + "万";
				}
				break;
			case 2: //万亿以内
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				if (currIndex%4 == 0)
				{
					retString = retString + "亿";
				}
				break;
			case 3: //亿亿以内
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				if (currIndex%4 == 0)
				{
					retString = retString + "万亿";
				}				
				break;
			case 4: //万亿亿以内
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				if (currIndex%4 == 0)
				{
					retString = retString + "亿亿";
				}				
				break;
			default:
				retString  = "超额无法阅读" + retString;
				break;
			}

			
		}
		return retString;
	}

	private static String getXiaoshuRMBString(float num)
	{
		String retString = "";
		return retString;
	}

	private static String floatToString(float num)
	{
		int zhengshu = (int)num;
		float xiaoshu = num - (float)zhengshu;

		System.out.println("" + zhengshu + "--" + xiaoshu);

		return getZhengshuRMBString(zhengshu) + getXiaoshuRMBString(xiaoshu);	
	}

	public static void main(String[] args)
	{
		System.out.println(floatToString(1204.43f));
		System.out.println(floatToString(100));	
		System.out.println(floatToString(10204.43f));
		System.out.println(floatToString(1230204.43f));
		System.out.println(floatToString(1000204.43f));
		System.out.println(floatToString(1000004.43f));
		System.out.println(floatToString(130010000.43f));
	}
}