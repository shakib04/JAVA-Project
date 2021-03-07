import java.lang.*;

public class Break

{ 

public void twoNum( int num, int val )
{
  for ( int i = 0 ; i < num ; i++ )
  {
     if ( num >= 2 * val )
        break ;
     val = val / 2 ;
	 System.out.println(val);
  }
  // break comes here if it runs
}


public static void main(String args[]) 

{
	Break b1=new Break();
	b1.twoNum(10,200);
}

}
