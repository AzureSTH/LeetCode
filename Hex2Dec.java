import java.util.*;

public class Main{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            String s=in.nextLine();
            int res=0;
            int pow=1;
            String sub=s.substring(2,s.length());
            for (int i=sub.length()-1;i>=0;i--)
            {
                char c=sub.charAt(i);
                if(c>='0'&&c<='9')
                    res+=(c-'0')*pow;
                else if(c>='A'&&c<='F')
                    res+=(c-'A'+10)*pow;
                pow=pow*16;
            }
            System.out.println(res);
        }
    }
}