import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WarnGUI extends JFrame implements ActionListener
{
	private JPanel Panel;
	
	private JLabel heading, Warning1, Warning2, Warning3, Warning4;
	private JButton closeBut;
	
	public boolean Warning;
	public int numOfWarnings;
	
	public void warning()
	{
		setTitle("Weather Warnings");
		getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel = (JPanel) getContentPane();
		Panel.setLayout(null);
		numOfWarnings = 0;
		heading = new JLabel(numOfWarnings + " Weather Warnings");
		
		//Warning1 = new JLabel("There is a Winter Weather Advisory");
		//Warning2 = new JLabel("There is a Winter Weather Advisory");
		//Warning3 = new JLabel("There is a Winter Weather Advisory");
		//Warning4 = new JLabel("There is a Winter Weather Advisory");

		if(numOfWarnings == 1)
		{
			Warning1 = new JLabel("There is a Winter Weather Advisory");
		}
		else if(numOfWarnings == 2)
		{
			Warning1 = new JLabel("There is a Winter Weather Advisory");
			Warning2 = new JLabel("There is a Winter Weather Advisory");
		}
		else if(numOfWarnings == 3)
		{
			Warning1 = new JLabel("There is a Winter Weather Advisory");
			Warning2 = new JLabel("There is a Winter Weather Advisory");
			Warning3 = new JLabel("There is a Winter Weather Advisory");
		}
		else if(numOfWarnings == 4)
		{
			Warning1 = new JLabel("There is a Winter Weather Advisory");
			Warning2 = new JLabel("There is a Winter Weather Advisory");
			Warning3 = new JLabel("There is a Winter Weather Advisory");
			Warning4 = new JLabel("There is a Winter Weather Advisory");		}
		else
		{
			Warning1 = new JLabel("");
			Warning2 = new JLabel("");
			Warning3 = new JLabel("");
			Warning4 = new JLabel("");
		}
		
		closeBut = new JButton("Close");
		closeBut.addActionListener(this);
		closeBut.setBounds(150, 140, 150, 30);
		
		heading.setBounds(15,5,150,20);
		Warning1.setBounds(15,25,240,20);
		Warning2.setBounds(15,40,240,20);
		Warning3.setBounds(15,55,240,20);
		Warning4.setBounds(15,70,240,20);
		
		Panel.add(heading);
		Panel.add(Warning1);
		Panel.add(Warning2);
		Panel.add(Warning3);
		Panel.add(Warning4);
		Panel.add(closeBut);
		
		setSize(450, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == closeBut) {
			dispose();
			new forecastGUI();
		}
	}
	public static void main(String[] args) {
		new WarnGUI().warning();
	}
}
