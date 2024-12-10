import java.util.*;
import java.util.Scanner;
public class Phase_1 {
    public static void main(String[] args)
    {
        contacts.AddressBook a=new contacts.AddressBook(); //importing the class contacts

        int c;
        while (true)
        {
            System.out.println("\n1. Add Contact\n2. Delete contact\n3. Edit contact\n4. Display contact\n0. exit\n");
            Scanner sc=new Scanner(System.in);
            c=sc.nextInt();
            if(c==0)
                break;
            if(c==1)
                a.add();
            if(c==2)
                a.delete();
            if(c==3)
                a.edit();
            if(c==4)
                a.display();
        }
    }
}
