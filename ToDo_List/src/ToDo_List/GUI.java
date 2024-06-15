package ToDo_List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class GUI {
	
	private static final int frameWidth = 500;
	private static final int frameHeight = 500;
	
	
	private JFrame frame = new JFrame();
	private JLabel label = new JLabel();
	private Border border = BorderFactory.createLineBorder(Color.black, 5);
	private ImageIcon logo = new ImageIcon("ToDo_Icon.jpg");
	
	public void createGUI() {
		
		//-----------------------------Frame-------------------------
		//Size
		frame.setSize(frameWidth,frameHeight);
		frame.setTitle(":^) stop, Fenster time");
		frame.setResizable(false);
		
		//Icon
		frame.setIconImage(logo.getImage());
		
		//Coloring
		frame.getContentPane().setBackground(new Color(150,150,150));
		
		//other Settings
		frame.setLayout(null); //necessary to use custom Boundaries for Labels
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//-----------------------------Label-------------------------
		label.setText("labiles Label");
		label.setForeground(new Color(255,255,255));
		label.setFont(new Font("Didot", Font.BOLD, 20));
		
		//Border for Label
		label.setBorder(border);
	
		//Alignment
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);

		//relational to Images
		//label.setHorizontalTextPosition(JLabel.CENTER);
		//label.setVerticalTextPosition(JLabel.TOP);
		
		//Boundaries
		label.setBounds(0,0,200,200);
		
		//--------------------Initializing of GUI---------------------
		frame.add(label);
		
		//alternative to automatically set frame size according to all labels to be displayed
		//-> to use delete frame.setSize and label.setBorder Methods
		//-> as well as frame.setLayout(null) Option for Standard LayoutManager
		//frame.pack(); 
		
	}

}
