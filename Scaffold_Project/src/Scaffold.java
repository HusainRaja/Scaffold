import java.util.*;
import java.io.FileWriter;
import java.lang.*;
class Scaffold
{
	
	 static int rounding(float height, float ver) {
	    	int n,h = (int) height,v = (int) ver;
	    	n = v * (h/v);
	    	return n;
	    }
	 
	 
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        float h,w,l,n,led,ledw,ver,x,y,nov,nol,nolw;
        int flag=0,n1=0;
        System.out.println("Enter the total height required");
        h=s.nextFloat();
        System.out.println("Enter the total length required");
        l=s.nextFloat();
        System.out.println("Enter the total width required");
        w=s.nextFloat();
        System.out.println("Enter the cup interval to use");
        n=s.nextFloat();
        System.out.println("Enter the vertical size to use");
        ver=s.nextFloat();
        while(true)
        {
            
            if((h%ver==0.0)&&(ver%n==0.0))
            {
            	//System.out.println("Testing!");
                break;
            }
            else
            {
            	int round = rounding(h,ver);
                System.out.println("Height is not divisble by the vertical size.. Either Choose " + round + " or " + (round+(int)ver));
                h=s.nextFloat();
            }
        }
        System.out.println("Enter the ledger size for the length");
        while(true)
        {
            led=s.nextFloat();
            if(l%led==0.0)
            {
                break;
            }
            else
            {
                System.out.println("Please enter an alternate size");
            }
        }
        System.out.println("Enter the ledger size for width");
        while(true)
        {
             ledw=s.nextFloat();
             if(w%ledw==0.0)
             {
                 flag=1;
                 break;
             }
             else
             {
                 System.out.println("Please enter an alternate size");
             }
        }
        x=w/ledw;
        y=((h/ver)*((ver/n)-1))+1;
        nol=l/led;
        if(flag==1)
        {
            nov=(nol+1)*(1+x);
            nolw=(nol+1)*x;
        }
        else
        {
            nov=(nol+1)*2;
            nolw=nol+1;
        }
        nolw=nolw*y;
        nol=nol*2;
        nol=nol*y;
        nov=nov*(h/ver);
        System.out.println("\n");
        System.out.print("processing");
        while(n1<3)
        {
            try
            {
                Thread.sleep(200);
            }
            catch(InterruptedException e)
            {
            }
            System.out.print(".");
            n1++;
        }
        System.out.println("\nPlease enter the file name for the output.");
        String fn = s.next();
        try 
        {
        	FileWriter fw = new FileWriter("/Users/akil/Documents/Scaffold/"+fn);
        	//FileWriter fw = new FileWriter("C:\\Users\\hraja\\Documents\\"+fn);
        	fw.write("Details of Scaffold for Dimensions : "+h+"x"+l+"x"+w+" (HxLxW)\n");
        	fw.write("\n\n\t"+ver+"m verticals : "+nov+" nos.\n\t"+led+"m ledgers (length) : "+nol+" nos.\n\t"+ledw+"m ledgers (width) : "+nolw+" nos.");
        	System.out.println("\n\n\t"+ver+"m verticals : "+nov+" nos.");
            System.out.println("\t"+led+"m ledgers (length) : "+nol+" nos.");
            System.out.println("\t"+ledw+"m ledgers (width) : "+nolw+" nos.");
            fw.close();
            
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        System.out.println("Please find the output in the Scaffold folder in the filename : " + fn);
        //System.out.println("\n\n-HR");
    }
    
   
}
