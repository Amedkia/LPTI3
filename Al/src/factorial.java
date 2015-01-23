
import java.util.Scanner;


public class factorial {

   
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Dame un numero y te dare su factorial");
        int n = scan.nextInt();
        
        if(n!=0)
        {
            if(n==1 || n==-1)
            {
                System.out.println("El factorial de 1 o -1 es 1");
            }
            else
            {
                if(n<=20)
                {
                    long fact = 1;
                    
                    for(int i = 1;i<=n;++i)
                    {
                        fact = fact*i;
                        
                        System.out.println(fact);
                    }
                    System.out.println("El resultado es: "+fact);
                }
                else
                {
                    System.out.println("No puedo calcularlo ");
                } 
            }
        }
        else
        {
            System.out.println("El factorial de 0 es 1");
        }
    }
    
}
