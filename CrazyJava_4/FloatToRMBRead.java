/**
* 2013.06.25 V0.1
*/
public class FloatToRMBRead
{
	/**���ڳ����е�������
	*/
	static String[] numToChineseRead = {"","һ","��","��","��","��","��","��","��","��"};
	static String[] indexToJinzhi = {"","ʮ","��","ǧ"};

	private static String getZhengshuRMBString(int num)
	{

		String numString = "" + num, retString = "";
		int currNum,currIndex;
		int zeroFlag = 0; //���ж��������ʱ��ֻ��һ���㡣

		for(int i =  0, numCount = 0; i < numString.length()  ; i ++, numCount ++)	//�Ӹ�λ��ʼ����
		{
			currNum = Integer.parseInt("" + numString.charAt(i)); //��ǰ���λ����ֵ
			currIndex = numString.length() - i - 1; //��ǰ���λ����λ��,�ӣ���ʼ

			//System.out.println(currNum + "" + currIndex);

			if (currNum == 0)
			{
				zeroFlag = 1;
				if (currIndex != 0 && currIndex%4 == 0) //����Ҫ��ӡ��򡱡��ڡ���Щ��λʱ��������
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
				retString = retString + "��"; //����Ķ����ڴ˴����
				zeroFlag = 0;
			}

			switch (currIndex / 4)
			{
			case 0: //0~9999 ������				
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				break;
			case 1: //1000_0000~9999_9999��������
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				if (currIndex%4 == 0)
				{
					retString = retString + "��";
				}
				break;
			case 2: //��������
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				if (currIndex%4 == 0)
				{
					retString = retString + "��";
				}
				break;
			case 3: //��������
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				if (currIndex%4 == 0)
				{
					retString = retString + "����";
				}				
				break;
			case 4: //����������
				retString =  retString + numToChineseRead[currNum] + indexToJinzhi[currIndex%4];
				if (currIndex%4 == 0)
				{
					retString = retString + "����";
				}				
				break;
			default:
				retString  = "�����޷��Ķ�" + retString;
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