import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class Phase_5_GUI {
    public static JFrame fra;
    public static String fname;
    public static String line="";
    public static int k=0,j=0,count=0;
    public static String nam[]=new String[100];
    public static String surnam[]=new String[100];
    public static String ph[]=new String[100];
    public static String zi[]=new String[100];
    public static String[] removeTheElement(String[] arr, int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        String[] anotherArray = new String[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public static void main(String args[]){
        JFrame frame=new JFrame("Untitled");
        FrameGenerator(frame);

    }
    public static void FrameGenerator(JFrame frame)
    {
        fra =new JFrame();
        fra.setSize(300, 160);
        JPanel jp=new JPanel();
        jp.setBorder(new EmptyBorder(10,40,10,10));
        //Adding Components to the frame.
        JLabel lab=new JLabel();
        jp.add(lab);
        lab.setText("FILE SAVED");


        for(int g=0;g<650;g++)
        {
            line=line+"-";
        }

        //Creating the Frame
        //frame = new JFrame("Untitled");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(650, 650);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        mb.add(m1);
        JMenuItem New = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem sav = new JMenuItem("Save");
        JMenuItem save_as = new JMenuItem("Save As");
        JMenuItem exit =new JMenuItem("Exit");
        m1.add(New);
        m1.add(open);
        m1.add(sav);
        m1.add(save_as);
        m1.add(exit);
        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                JFrame frame2=new JFrame("Untitled"+Integer.toString(count));
                FrameGenerator(frame2);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        sav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw=new FileWriter("UntitledGUI.txt");
                    for(int i=0;i<j;i++)
                    {
                        fw.write("\nName = " + nam[i]+"\nSurname = "+surnam[i]+"\nPhone = "+ph[i]+"\nZIP = "+zi[i]+"\n\n");
                    }
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                JPanel pan=new JPanel();
                pan.setBorder(new EmptyBorder(10,0,10,10));
                fra.getContentPane().add(BorderLayout.CENTER, pan);
                JLabel l=new JLabel("FILE SAVED");
                pan.add(l);
                fra.setVisible(true);
            }
        });
        save_as.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JPanel pan=new JPanel();
                pan.setBorder(new EmptyBorder(10,0,10,10));
                fra.getContentPane().add(BorderLayout.CENTER, pan);
                JLabel l=new JLabel("ENTER NAME");
                JTextField text=new JTextField(20);
                fra.setSize(500, 300);
                fra.setVisible(true);

                JButton ok = new JButton("ok");
                ok.setFocusable(false);
                pan.add(l);
                pan.add(text);
                pan.add(ok);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fname=text.getText();
                        fname=fname+".txt";
                        try {
                            FileWriter fw=new FileWriter(fname);
                            for(int i=0;i<j;i++)
                            {
                                fw.write("\nName = " + nam[i]+"\nSurname = "+surnam[i]+"\nPhone = "+ph[i]+"\nZIP = "+zi[i]+"\n\n");
                            }
                            fw.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        fra.dispose();
                    }
                });

            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JPanel pan=new JPanel();
                pan.setBorder(new EmptyBorder(10,0,10,10));
                fra.getContentPane().add(BorderLayout.CENTER, pan);
                JLabel l=new JLabel("ENTER NAME");
                JTextField text=new JTextField(20);
                fra.setSize(500, 300);
                fra.setVisible(true);

                JButton ok = new JButton("ok");
                ok.setFocusable(false);
                pan.add(l);
                pan.add(text);
                pan.add(ok);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fname=text.getText();
                        fname=fname+".txt";
                        Desktop d=Desktop.getDesktop();
                        File f=new File(fname);
                        try {
                            d.open(f);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        fra.dispose();
                    }
                });

            }
        });


        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JPanel panel1 = new JPanel();
        JLabel label0[] = new JLabel[40];
        for(int i=0;i<40;i++)
        {
            label0[i]=new JLabel("\n");
        }

        JLabel label = new JLabel("Name");
        JLabel label1 = new JLabel("Surname");
        JLabel label2 = new JLabel("Phone");
        JLabel label3= new JLabel("ZIP");
        JTextField name = new JTextField(20); // accepts upto 10 characters
        JTextField surname = new JTextField(20);
        JTextField phone = new JTextField(20);
        JTextField zip = new JTextField(20);
        JButton add = new JButton("Add");
        add.setFocusable(false);
        JButton del = new JButton("Delete");
        del.setFocusable(false);
        JButton sort = new JButton("Sort");
        sort.setFocusable(false);
        JButton reset = new JButton("Reset");
        reset.setFocusable(false);
        panel1.setLayout(new GridLayout(35, 1));
        for(int i=0;i<35;i++)
        {
            panel1.add(label0[i]);
        }
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new GridLayout(6, 2));
        // Components Added using Flow Layout
        panel.add(label);
        panel.add(name);
        panel.add(label1);
        panel.add(surname);
        panel.add(label2);
        panel.add(phone);
        panel.add(label3);
        panel.add(zip);
        //panel2.setLayout(new GridLayout(1, 3));
        panel.add(add);
        panel.add(del);
        panel.add(sort);
        panel.add(reset);

        // Text Area at the Center
        //JTextArea ta = new JTextArea();
        panel1.setBorder(new EmptyBorder(10,0,10,10));
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, panel1);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        //frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                nam[j]=name.getText();
                surnam[j]=surname.getText();
                ph[j]=phone.getText();
                zi[j]= zip.getText();
                label0[k].setText("\nName = "+nam[j]);
                label0[k+2].setText("\nSurname = "+surnam[j]);
                label0[k+4].setText("\nPhone = "+ph[j]);
                label0[k+6].setText("\nZip = "+zi[j]);
                label0[k + 8].setText(line);
                j++;
                k=k+11;
                name.setText("");
                surname.setText("");
                phone.setText("");
                zip.setText("");
            }
        });
        sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                k=0;
                for(int i=0;i<j-1;i++)
                {
                    for(int m=i+1;m<j;m++)
                    {
                        if(nam[i].compareTo(nam[m])>0)
                        {
                            String t1=nam[i];
                            nam[i]=nam[m];
                            nam[m]=t1;
                            String t2=surnam[i];
                            surnam[i]=surnam[m];
                            surnam[m]=t2;
                            String t3=ph[i];
                            ph[i]=ph[m];
                            ph[m]=t3;
                            String t4=zi[i];
                            zi[i]=zi[m];
                            zi[m]=t4;
                        }
                    }
                }
                for(int i=0;i<j;i++)
                {
                    label0[k].setText("\nName = " + nam[i]);
                    label0[k + 2].setText("\nSurname = " + surnam[i]);
                    label0[k + 4].setText("\nPhone = " + ph[i]);
                    label0[k + 6].setText("\nZip = "+zi[i]);
                    label0[k + 8].setText(line);
                    k = k + 11;
                }
            }
        });
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String n=name.getText();
                String s=surname.getText();
                String p=phone.getText();
                int i,x=0;
                for(i = 0;i<j;i++)
                {
                    if(nam[i].compareTo(n)==0 && surnam[i].compareTo(s)==0)
                    {
                        nam=removeTheElement(nam,i);
                        surnam=removeTheElement(surnam,i);
                        ph=removeTheElement(ph,i);
                        zi=removeTheElement(zi,i);
                        j--;
                        for(int ind=0;ind<j;ind++)
                        {
                            label0[x].setText("\nName = " + nam[ind]);
                            label0[x + 2].setText("\nSurname = " + surnam[ind]);
                            label0[x + 4].setText("\nPhone = " + ph[ind]);
                            label0[x + 6].setText("\nZip = "+zi[ind]);
                            label0[x + 8].setText(line);
                            x=x + 11;
                        }
                        label0[x].setText("");
                        label0[x+2].setText("");
                        label0[x+4].setText("");
                        label0[x+6].setText("");
                        label0[x+8].setText("");
                        k=k-11;
                        break;
                    }
                }

                for(i = 0;i<j;i++)
                {
                    if(ph[i].compareTo(p)==0)
                    {
                        nam=removeTheElement(nam,i);
                        surnam=removeTheElement(surnam,i);
                        ph=removeTheElement(ph,i);
                        zi=removeTheElement(zi,i);
                        j--;
                        for(int ind=0;ind<j;ind++)
                        {
                            label0[x].setText("\nName = " + nam[ind]);
                            label0[x + 2].setText("\nSurname = " + surnam[ind]);
                            label0[x + 4].setText("\nPhone = " + ph[ind]);
                            label0[x + 6].setText("\nZip = "+zi[ind]);
                            label0[x + 8].setText(line);
                            x=x + 11;
                        }
                        label0[x].setText("");
                        label0[x+2].setText("");
                        label0[x+4].setText("");
                        label0[x+6].setText("");
                        label0[x+8].setText("");
                        k=k-11;
                        break;
                    }
                }


                name.setText("");
                surname.setText("");
                phone.setText("");
            }
        });
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                for(int i=0;i<label0.length;i++)
                    label0[i].setText("");
            }
        });
    }
}