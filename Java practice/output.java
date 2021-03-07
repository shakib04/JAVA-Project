import java.lang.*;

public class output 

{
	int num1,num2,sum;
	
	public output(int a,int b)
	{
		num1=a;
		num2=b;
	}
	
	
	public int print()
	{
		return sum=num1+num2;
	}
	
	public void buyPr(int c)
	{
		num1=num1+c;
	}

	public static void main(String[] args)
	{
		//int a=5;
		//static int b=6;
		
		//a=9;
		//b=7;
		//System.out.println(a);
		//System.out.println(b);
		
		
		output o1 = new output(2,3);
		System.out.println(o1.print());
		o1.buyPr(7);
		System.out.println(o1.num1);
		System.out.println(o1.num2);
		System.out.println(o1.print());
		System.out.println(o1.print());
		
	}
}