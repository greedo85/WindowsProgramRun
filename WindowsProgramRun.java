/* package WindowsProgramRun; */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WindowsProgramRun extends JFrame
{
	public JButton button1;
	public JButton button2;
	public JButton button3;
	public JButton button4;
	public JButton button5;
	public JButton button6;
	public JLabel label1;
	public JLabel label2;
	public JLabel label3;
	public JLabel label4;
	public JTextField field1;
	public JTextField field2;
	public JTextField field3;
	public String pathToBrowser;
	public String pathToMail;
	public String pathToUser1;
	public String buttonNameUser1;
	Event1 ev1=new Event1();
	Event2 ev2=new Event2();
	Event3 ev3=new Event3();
	Event4 ev4=new Event4();
	Event5 ev5=new Event5();
	Event6 ev6=new Event6();
	
	Runtime run;
	

	public WindowsProgramRun()
	{
		
		run=Runtime.getRuntime();
		try
		{
			File file=new File("config.txt");
			Scanner key=new Scanner(file);
			pathToBrowser=key.nextLine();
			pathToMail=key.nextLine();
			buttonNameUser1=key.nextLine();
			pathToUser1=key.nextLine();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("plik nie istnieje");
		}
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		label1=new JLabel("Uruchamiacz programów");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=1;
		gbc.gridy=0;
		add(label1,gbc);
		
		button1=new JButton("Przegl¹darka");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=1;
		add(button1,gbc);
		button1.addActionListener(ev1);
		
		field1=new JTextField(20);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=1;
		gbc.gridy=1;
		add(field1,gbc);
		
		button2=new JButton("X");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=4;
		gbc.gridy=1;
		add(button2,gbc);
		button2.addActionListener(ev2);
	/* --------------------------------------------------- */
		button3=new JButton("Poczta");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=2;
		add(button3,gbc);
		button3.addActionListener(ev3);
		
		field2=new JTextField(20);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=1;
		gbc.gridy=2;
		add(field2,gbc);
		
		button4=new JButton("X");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=4;
		gbc.gridy=2;
		add(button4,gbc);
		button4.addActionListener(ev4);
	/* -------------------------------------------------- */
		button5=new JButton(buttonNameUser1);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=3;
		add(button5,gbc);
		button5.addActionListener(ev5);
		
		field3=new JTextField(20);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=1;
		gbc.gridy=3;
		add(field3,gbc);
		
		button6=new JButton("X");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=4;
		gbc.gridy=3;
		add(button6,gbc);
		button6.addActionListener(ev6);
	}
	public int runProcess(int choice1)
	{
		try
		{
			switch(choice1)
			{
				case 1:
					run.exec(pathToBrowser);
					break;
				case 2:
					run.exec(pathToMail);
					break;
				case 3:
					run.exec(pathToUser1);
					break;
			}			
		}
		catch (Exception Ex)
        {
		  System.out.println("B³¹d " + Ex.toString());
	    }
		return choice1;
	}
	public int closeProcess(int choice2)
	{
		run=Runtime.getRuntime();
		try
		{
			switch (choice2)
			{
				case 1:
					run.exec("taskkill /F /IM firefox.exe");
					break;
				case 2:
					run.exec("taskkill /F /IM thunderbird.exe");
					break;
				case 3:
					run.exec("taskkill /F /IM "+pathToUser1+"exe");
					break;
			}
		}
		catch (Exception Ex)
        {
		  System.out.println("B³¹d " + Ex.toString());
	    }
		return choice2;
	}
	public class Event1 implements ActionListener
	{
		public void actionPerformed(ActionEvent ev1)
		{
			runProcess(1);
			field1.setText(pathToBrowser);
			revalidate();
		}
	} 
	public class Event2 implements ActionListener
	{
		public void actionPerformed(ActionEvent ev2)
		{
			closeProcess(1);
			field1.setText(null);
			revalidate();
		}
	}
	public class Event3 implements ActionListener
	{
		public void actionPerformed(ActionEvent ev3)
		{
			runProcess(2);
			field2.setText(pathToMail);
			revalidate();
		}
	}
	public class Event4 implements ActionListener
	{
		public void actionPerformed(ActionEvent ev4)
		{
			closeProcess(2);
			field2.setText(null);
			revalidate();
		}
	}
	public class Event5 implements ActionListener
	{
		public void actionPerformed(ActionEvent ev5)
		{
			runProcess(3);
			field3.setText(pathToUser1);
			revalidate();
		}
	}
	public class Event6 implements ActionListener
	{
		public void actionPerformed(ActionEvent ev6)
		{
			closeProcess(3);
			field3.setText(null);
			revalidate();
		}
	}
}