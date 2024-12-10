import java.io.*;
import java.util.*;
public class Phase_2
{
    public static contacts.AddressBook New()  //OPENING A NEW ADDRESS BOOK
    {
        contacts.AddressBook a=new contacts.AddressBook();

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
        return a;
    }
    
    public static contacts.AddressBook Open()  //OPENING AN EXISTING ADDRESS BOOK
    {
        contacts.AddressBook a=new contacts.AddressBook();
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the name of the file you want to open\n");
        String fname=sc.nextLine();
        a.file_name=fname;
        fname=fname+"1.txt";
        try{
            File file = new File(fname);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st,name,surname,phone,zip,email,address;
            while(true)
            {
                st= br.readLine();
                if(st==null)
                    break;
                name=st;
                st= br.readLine();
                surname=st;                         //THESE STEPS ARE USED TO COPY THE ADDRESS BOOK
                st= br.readLine();                  //FROM A TEXT FILE TO PROGRAM ADDRESS BOOK
                phone=st;
                st=br.readLine();
                zip=st;
                st=br.readLine();
                email=st;

                st=br.readLine();
                address=st;
                a.p[a.a]=new contacts.Person(name,surname,zip,phone,email,address);

                a.a++;
            }
        }
         catch (Exception e) {
            System.out.println("file not found");
            return null;
        }
        a.display();
        int c;
            while (true)
            {
                System.out.println("\n1. Add Contact\n2. Delete contact\n3. Edit contact\n4. Display contact\n0. exit\n");
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

        return a;
    }
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        int ch;
        while(true)
        {
            System.out.println("\n1. New AddressBook\n2. Open AddressBook\n0. Quit\n");
            ch=sc.nextInt();
            if(ch==0)
                break;
            if(ch==1)
            {
                contacts.AddressBook new_add=new contacts.AddressBook();
                new_add=New();
                System.out.println("\n1. Save\n2. Save as\n3. Close without saving\n");
                int k;
                k= sc.nextInt();
                if(k==1)
                {
                    new_add.Save();
                }
                if(k==2)
                {
                    new_add.Save_As();
                }
                if(k==3)
                    continue;
            }
            if(ch==2)
            {
                contacts.AddressBook open=new contacts.AddressBook();
                open=Open();
                if(open!=null) {
                    System.out.println("\n1. Save\n2. Save as\n3. Close without saving\n");
                    int k;
                    k = sc.nextInt();
                    if (k == 1) {
                        open.Save();
                    }
                    if (k == 2) {
                        open.Save_As();
                    }
                    if (k == 3)
                        continue;
                }
            }
            if(ch==3)
                break;
        }
    }
}
