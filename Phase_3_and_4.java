import java.io.*;
import java.util.*;
public class Phase_3_and_4
{
    public static int IsNewFile(String name) //CHECKING WHETHER THE ADDRESSBOOK THAT IS OPEN IS NEWLY CREATED OR NOT
    {
        if(name.length()<8)
            return -10;
        if(name.substring(0,8).compareTo("Untitled")==0)
            return ((int) name.charAt(name.length() - 1)-48);
        return -10;

    }
    public static contacts.AddressBook Open() {
        contacts.AddressBook a=new contacts.AddressBook();
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the name of the file you want to open\n");
        String fname=sc.nextLine();
        a.file_name=fname;
        fname=fname+".txt";
        try {
            File file = new File(fname);
        }
        catch(Exception e)
        {
            System.out.println("\nFile not found\n");
            a.file_name="null";
        }
        return a;
    }
    public static contacts.AddressBook Open_Display(String fname)
    {
        contacts.AddressBook a=new contacts.AddressBook();
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
                surname=st;
                st= br.readLine();
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

        return a;
    }
    public static String[] removeTheElement(String[] arr, String name)
    {

        name=name+".txt";

        // Create another array of size one less
        String[] anotherArray = new String[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            if(arr[i]==null)
                continue;
            // the removal element index
            if(arr[i].compareTo(name)==0) {
                continue;
            }

            // if the index is not
            if(arr[i]!=null)
                anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public static void main(String[] args)
    {
        contacts.AddressBook new_add[]=new contacts.AddressBook[1000];
        contacts.AddressBook open[]=new contacts.AddressBook[1000];
        String AddressBooks[]=new String[1000];
        Scanner sc=new Scanner(System.in);
        int i=0,k=0,ch=-1,count=0;
        while(true)
        {
            if(ch!=-1)
            {
                System.out.print("\nThe Address Books opened are ");
                for(int m=0;m<i;m++)
                    if(AddressBooks[m]!=null)
                        System.out.print(AddressBooks[m]+"  ");
            }
            System.out.println("\n1. New AddressBook\n2. Open AddressBook\n3. Edit AddressBooks\n");
            ch=sc.nextInt();
            if(ch==1)
            {
                AddressBooks[i]="Untitled"+Integer.toString(i)+".txt";
                new_add[i]=new contacts.AddressBook();
                new_add[i].file_name="Untitled"+Integer.toString(i+1);
                i++;
                count++;
            }
            if(ch==2)
            {
                open[k]=new contacts.AddressBook();
                open[k]=Open();
                if(open[k].file_name.compareTo("null")!=0)
                {
                    AddressBooks[i] = open[k].file_name + ".txt";
                    i++;
                    k++;
                    count++;
                }

            }
            if(ch==3)
            {
                if(count==0)
                {
                    System.out.println("\nProgram terminated");
                    break;
                }
                System.out.println("\nWhich addressbook you want to edit?");
                String n1=sc.nextLine();
                String name=sc.nextLine();
                int index=IsNewFile(name);
                if(index!=-10)
                    new_add[index].operate(name);
                else
                {
                    for (int m=0;m<k;m++)
                    {
                        open[m].file_name=name;
                        if(open[m]==null)
                            continue;
                        if(open[m].file_name.compareTo(name)==0)
                        {
                            open[m]=Open_Display(open[m].file_name);
                            open[m].operate(name);
                            break;
                        }
                    }
                }
                count--;
                AddressBooks=removeTheElement(AddressBooks,name);
                if(count==0)
                {
                    System.out.println("\nProgram terminated");
                    break;
                }
            }
        }
    }
}