import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class contacts {

    //CREATING A PERSON CLASS
    static class Person {
        String name;
        String surname;
        String zip;
        String phone;
        String email;
        String address;

        Person(String name, String surname, String zip, String phone, String email, String address) {
            this.name = name;
            this.surname = surname;
            this.zip = zip;
            this.phone = phone;
            this.email = email;
            this.address = address;
        }

        void display() {
            System.out.println("\nName = " + name + "\nSurname = " + surname + "\nPhone no = " + phone + "\nZip = " + zip + "\nEmail = " + email + "\nAddress = " + address + "\n");
        }
    }

    static class AddressBook {

        // THIS IS OUR ADDRESS BOOK WHICH WHILE THE STORE THE DETAILS OF MULTIPLE PERSONS OR PEOPLE
        Person[] p;
        int a;
        String file_name;

        AddressBook() {
            a = 0;
            p = new Person[1000];
            file_name="Untitled";
        }

        void add()  // THIS FUNCTION WILL ADD A PERSON TO THE ADDRESS BOOK
        {
            System.out.println("Adding an entry");
            String n1;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name");
            String name = sc.nextLine();
            System.out.println("Enter surname");
            String surname = sc.nextLine();
            System.out.println("Enter phone");
            String phone = sc.nextLine();
            System.out.println("Enter zip");
            String zip = sc.nextLine();
            System.out.println("Enter email");
            String email = sc.nextLine();
            System.out.println("Enter address");
            String address = sc.nextLine();
            p[a] = new Person(name, surname, zip, phone, email, address);
            a++;
        }

        void delete()  // THIS FUNCTION WILL DELETE A PERSON FROM THE ADDRESS BOOK
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name");
            String name = sc.nextLine();
            System.out.println("Enter surname");
            String surname = sc.nextLine();
            int index = -1;
            for (int j = 0; j < a; j++) {
                if (p[j].name.compareTo(name) == 0 && p[j].surname.compareTo(surname) == 0) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("\nContact not found\n");
                return;
            }
            while (index < a) {
                p[index] = p[index + 1];
                index++;
            }
            a--;
        }

        int find() //THIS WILL FIND A PERSON IN THE ADDRESS BOOK
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter 1 to search by name, 2 to search by phone number\n");
            int k;
            k=sc.nextInt();
            String name,surname,phone;
            name=surname=phone="";
            if(k==1)
            {
                System.out.println("Enter name");
                name = sc.nextLine();
                System.out.println("Enter surname");
                surname = sc.nextLine();
            }
            else if(k==0)
            {
                System.out.println("Enter phone number");
                phone = sc.nextLine();
            }
            int index = -1;
            for (int j = 0; j < a; j++)
            {
                if(k==1)
                {
                    if (p[j].name.compareTo(name) == 0 && p[j].surname.compareTo(surname) == 0) {
                        index = j;
                        break;
                    }
                }
                else if(k==0)
                {
                    if (p[j].phone.compareTo(phone) == 0) {
                        index = j;
                        break;
                    }
                }
            }
            if (index == -1) {
                System.out.println("\nContact not found\n");
            }
            return index;
        }
        //THE FUNCTIONS GIVEN BELOW ARE USED TO EDIT DIFFERENT FIELDS OF A PERSON IN ADDRESS BOOK
        void edit_name(int index) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter name\n");
            String name = sc.nextLine();
            p[index].name = name;
        }

        void edit_surname(int index) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter surname\n");
            String surname = sc.nextLine();
            p[index].surname = surname;
        }

        void edit_zip(int index) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter zip\n");
            String zip = sc.nextLine();
            p[index].zip = zip;
        }

        void edit_phone(int index) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter phone\n");
            String phone = sc.nextLine();
            p[index].phone = phone;
        }

        void edit_address(int index) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter address\n");
            String address = sc.nextLine();
            p[index].address = address;
        }

        void edit_email(int index) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter email\n");
            String email = sc.nextLine();
            p[index].email = email;
        }

        void edit() {
            Scanner sc = new Scanner(System.in);
            int i;
            i = find();
            int c;
            if (i == -1)
                return;
            System.out.println("\nHere are the contact details\n");
            p[i].display();
            while (true) {
                System.out.println("\n1. Edit name\n2. Edit surname\n3. Edit phone\n4. Edit zip\n5. Edit email\n6.Edit address\n0. Exit\n");
                c = sc.nextInt();
                if (c == 0)
                    break;
                if (c == 1)
                    edit_name(i);
                if (c == 2)
                    edit_surname(i);
                if (c == 3)
                    edit_phone(i);
                if (c == 4)
                    edit_zip(i);
                if (c == 5)
                    edit_email(i);
                if (c == 6)
                    edit_address(i);
            }
        }

        void display() // DISPLAY THE CONTACTS IN SORTED ORDER
        {
            int i, j;
            if (a > 1) {
                for (i = 0; i < a - 1; i++) {
                    for (j = i + 1; j < a; j++) {
                        if (p[i].name.compareTo(p[j].name) >= 1) {
                            Person temp = p[i];
                            p[i] = p[j];
                            p[j] = temp;
                        } else if (p[i].name.compareTo(p[j].name) == 0) {
                            if (p[i].surname.compareTo(p[j].surname) >= 1) {
                                Person temp = p[i];
                                p[i] = p[j];
                                p[j] = temp;
                            }
                        }
                    }
                }
            }
            /*try{
                File f=new File("C:\\Users\\testout.txt");
            }
            catch(Exception e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }*/

            for (i = 0; i < a; i++) {
                System.out.println("\nPerson " + (i + 1) + "\n");
                p[i].display();
                System.out.println();
            }
        }

        void Save() //SAVING AN ADDRESS BOOK
        {
            String fname=file_name+".txt";
            String temp = file_name + "1.txt";
            try {
                FileWriter fw = new FileWriter(fname);
                FileWriter t = new FileWriter(temp);
                for (int i = 0; i < a; i++) {
                    fw.write("\nPerson ");
                    fw.write(Integer.toString(i + 1));
                    fw.write("\nName =");
                    fw.write(p[i].name);
                    t.write(p[i].name);
                    t.write("\n");
                    fw.write("\nSurname =");
                    fw.write(p[i].surname);
                    t.write(p[i].surname);
                    t.write("\n");
                    fw.write("\nPhone =");
                    fw.write(p[i].phone);
                    t.write(p[i].phone);
                    t.write("\n");
                    fw.write("\nZip =");
                    fw.write(p[i].zip);
                    t.write(p[i].zip);
                    t.write("\n");
                    fw.write("\nEmail =");
                    fw.write(p[i].email);
                    t.write(p[i].email);
                    t.write("\n");
                    fw.write("\nAddress =");
                    fw.write(p[i].address);
                    t.write(p[i].address);
                    t.write("\n");
                    fw.write("\n");
                }
                fw.close();
                t.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("\nFile saved as "+fname);
        }


        void Save_As() {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter the name of the file\n");
            String fname = sc.nextLine();
            String temp = fname + "1.txt";
            fname = fname + ".txt";
            try {
                FileWriter fw = new FileWriter(fname);
                FileWriter t = new FileWriter(temp);
                for (int i = 0; i < a; i++) {
                    fw.write("\nPerson ");
                    fw.write(Integer.toString(i + 1));
                    fw.write("\nName =");
                    fw.write(p[i].name);
                    t.write(p[i].name);
                    t.write("\n");
                    fw.write("\nSurname =");
                    fw.write(p[i].surname);
                    t.write(p[i].surname);
                    t.write("\n");
                    fw.write("\nPhone =");
                    fw.write(p[i].phone);
                    t.write(p[i].phone);
                    t.write("\n");
                    fw.write("\nZip =");
                    fw.write(p[i].zip);
                    t.write(p[i].zip);
                    t.write("\n");
                    fw.write("\nEmail =");
                    fw.write(p[i].email);
                    t.write(p[i].email);
                    t.write("\n");
                    fw.write("\nAddress =");
                    fw.write(p[i].address);
                    t.write(p[i].address);
                    t.write("\n");
                    fw.write("\n");
                }
                fw.close();
                t.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("\nFile saved as "+fname);
        }
        void operate(String name) //THIS FUNCTION IS USED TO OPERATE ON AN EXISTING ADDRESS BOOK
        {
            file_name=name;
            int c,ch=0;
            while (true)
            {
                System.out.println("\n1. Add Contact\n2. Delete contact\n3. Edit contact\n4. Display contact\n5. Save\n6. Save as\n7. Close\n");
                Scanner sc=new Scanner(System.in);
                c=sc.nextInt();
                if(c==0)
                    break;
                if(c==1)
                {
                    ch++;
                    add();
                }
                if(c==2)
                {
                    ch++;
                    delete();
                }
                if(c==3)
                {
                    ch++;
                    edit();
                }
                if(c==4)
                    display();
                if(c==5)
                {
                    Save();
                    break;
                }
                if(c==6) {
                    Save_As();
                    break;
                }
                if(c==7)
                {
                    if(ch>0)
                    {
                        System.out.println("\nSave file? 1 for yes 2 for no");
                        int k=sc.nextInt();
                        if(k==1)
                        {
                            Save();
                            break;
                        }
                        if(k==2)
                            break;
                    }
                    break;
                }
            }
        }
    }

}
