import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.FileNotFoundException;
public class WindowsProgramRunMain 
{
	public static void main (String[]args)
	{
		
		WindowsProgramRun wpr=new WindowsProgramRun();
		wpr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wpr.setSize(500,200);
		/* wpr.pack(); */
		wpr.setVisible(true);
		wpr.setTitle("Uruchamiacz programów");
		/* System.out.printl(); */
	}
}
	