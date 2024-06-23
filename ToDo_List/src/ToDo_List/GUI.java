package ToDo_List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
	
	private static final int frameWidth = 430;
	private static final int frameHeight = 700;
	
	private JFrame frame = new JFrame();

	private JPanel panel1 = new JPanel();

	private JButton buttonAdd = new JButton();
	private JButton buttonShowAll = new JButton();
	private JButton buttonShowUncompleted = new JButton();
	
	private JLabel label = new JLabel();
	
	private Border border = BorderFactory.createLineBorder(Color.black, 5);
	
	private ImageIcon logo = new ImageIcon("ToDo_Icon.png");
	private ImageIcon addTask = new ImageIcon("ToDo_Add.png");
	private ImageIcon listAllTasks = new ImageIcon("ToDo_All.png");
	private ImageIcon listUncompletedTasks = new ImageIcon("ToDo_Icon.png");
	
	GUI(){
		
	//-----------------------------Frames-------------------------
		//Size
		frame.setSize(frameWidth,frameHeight);
		frame.setTitle("ToDo-Planner");
		frame.setResizable(false);
		
		//Icon
		frame.setIconImage(logo.getImage());
		
		//Coloring
		frame.getContentPane().setBackground(new Color(150,150,150));
		
		//add Panels to Frame
		frame.add(panel1);

		
		//Frame-Layout Setting (standard Frame Layout = BorderLayout)
		//frame.setLayout(null); //necessary to use custom Boundaries for Labels
		//frame.setLayout(new BorderLayout());
		frame.setLayout(new FlowLayout());
		
		//other Settings
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	//-----------------------------Panels-------------------------
		//set Bounds or preferred Sizes (Panel ~ Container for content)
		//panel1.setBounds(0,0,400,650);
		panel1.setPreferredSize(new Dimension(400,650));
		panel1.setBackground(Color.white);
		
		//Panel-Layout Setting (standard Panel Layout = FlowLayout)
		panel1.setLayout(null); //necessary to use custom Boundaries for Labels
		//panel1.setLayout(new FlowLayout());
		
	//-----------------------------Buttons-------------------------
		buttonAdd.setBounds(50, 60, 300, 50);
		buttonAdd.setText("Neue Task anlegen");
		buttonAdd.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		buttonAdd.setFont(new Font("Domani", Font.BOLD, 20));
		buttonAdd.setHorizontalTextPosition(JButton.LEFT);
		addTask = this.rescaleImage(50,50, addTask);
		buttonAdd.setIcon(addTask);

		buttonShowUncompleted.setBounds(50, 120, 300, 100);
		buttonShowUncompleted.setText("<html>Nicht erledigte <br />Tasks auflisten</html>");
		buttonShowUncompleted.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		buttonShowUncompleted.setFont(new Font("Domani", Font.BOLD, 20));
		buttonShowUncompleted.setHorizontalTextPosition(JButton.LEFT);
		listUncompletedTasks = this.rescaleImage(50,50, listUncompletedTasks);
		buttonShowUncompleted.setIcon(listUncompletedTasks);
		
		buttonShowAll.setBounds(50, 230, 300, 50);
		buttonShowAll.setText("Alle Tasks auflisten");
		buttonShowAll.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		buttonShowAll.setFont(new Font("Domani", Font.BOLD, 20));
		buttonShowAll.setHorizontalTextPosition(JButton.LEFT);
		listAllTasks = this.rescaleImage(50,50, listAllTasks);
		buttonShowAll.setIcon(listAllTasks);
		
		//add ActionListeners (~ Functionalities) to Buttons
		buttonAdd.addActionListener(func -> new AddTaskWindow());
		buttonAdd.addActionListener(func -> frame.dispose());
		
		buttonShowUncompleted.addActionListener(func -> new ListIncompleteTasksWindow());
		buttonShowUncompleted.addActionListener(func -> frame.dispose());
		
		buttonShowAll.addActionListener(func -> new ListAllTasksWindow());
		buttonShowAll.addActionListener(func -> frame.dispose());
		
		//-----------------------------Labels-------------------------
		label.setText("Hauptmenü");
		label.setForeground(new Color(0,0,0));
		label.setFont(new Font("Domani", Font.BOLD, 35));
		
		//Boundaries
		label.setBounds(0,0,400,50); //relative to the Container (Frame or Panel);
		
		//Border for Label
		label.setBorder(border);
	
		//Alignment
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);

		//relational to Images
		//label.setHorizontalTextPosition(JLabel.CENTER);
		//label.setVerticalTextPosition(JLabel.CENTER);
		
	//----------------adding Labels to Frames or Panels-------------------
		//frame.add(label);
		panel1.add(label);
		panel1.add(buttonAdd);
		panel1.add(buttonShowUncompleted);
		panel1.add(buttonShowAll);
		
		
		//Setting Frame visibility last to prevent "invisible Buttons" Bug
		frame.setVisible(true);
		
		//alternative to automatically set frame size according to all labels to be displayed
		//-> to use delete frame.setSize and label.setBorder Methods
		//-> as well as frame.setLayout(null) Option for Standard LayoutManager
		//frame.pack(); 
		
	}

	
	
	public ImageIcon rescaleImage(int x, int y, ImageIcon imgc) {
		Image img = imgc.getImage();
		Image newImg = img.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newImgIcon = new ImageIcon(newImg);
		return newImgIcon;
	}
	
	
}
