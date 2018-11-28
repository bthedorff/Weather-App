import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WarnGUI extends JFrame implements ActionListener
{
	private JPanel Panel;
	
	private JLabel warnings;
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
		
		JLabel warnings = new JLabel("No Weather Warnings");
		if(Warning == false)
		{
		//	JLabel warnings = new JLabel("No Weather Warnings");
		}
		
		closeBut = new JButton("Close");
		closeBut.addActionListener(this);
		closeBut.setBounds(150, 140, 150, 30);
		
		warnings.setBounds(15,15,150,150);
		
		Panel.add(warnings);
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
