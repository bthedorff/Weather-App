import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class locLookup {

	public void locationLookup() {
		JFrame locFrame = new JFrame();
		locFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		locFrame.setTitle("Set Location");
		locFrame.setSize(800, 650);
		locFrame.setLocationRelativeTo(null);
		
		
		JButton okBut = new JButton("OK");
		okBut.setSize(40, 40);
		okBut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			//locFrame.setVisible(false);
			//locFrame.dispose();
				System.exit(0);
			}
		});
		JTextField locTextField = new JTextField("",10);
		//locFrame.add(locTextField);
		locFrame.add(okBut);
		
		locFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new locLookup().locationLookup();
	}

}