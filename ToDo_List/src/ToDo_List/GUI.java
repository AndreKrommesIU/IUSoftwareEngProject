package ToDo_List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
	
	private static final int frameWidth = 750;
	private static final int frameHeight = 750;
	
	
	private JFrame frame = new JFrame();
	
	private JLabel label = new JLabel();

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	private JButton buttonAdd = new JButton();
	private JButton buttonShowAll = new JButton();
	private JButton buttonShowUncompleted = new JButton();
	private JButton buttonDeleteUncompleted = new JButton();
	
	private Border border = BorderFactory.createLineBorder(Color.black, 5);
	private ImageIcon logo = new ImageIcon("ToDo_Icon.png");
	private ImageIcon addTask = new ImageIcon("ToDo_Add.png");
	private ImageIcon listAllTasks = new ImageIcon("ToDo_All.png");
	private ImageIcon listUncompletedTasks = new ImageIcon("ToDo_Icon.png");
	private ImageIcon deleteCompletedTasks = new ImageIcon("ToDo_DeleteDone.png");
	
	public void createGUI(){
		
		//-----------------------------Frames-------------------------
		//Size
		frame.setSize(frameWidth,frameHeight);
		frame.setTitle("GLORIOUS GUI");
		frame.setResizable(false);
		
		//Icon
		frame.setIconImage(logo.getImage());
		
		//Coloring
		frame.getContentPane().setBackground(new Color(150,150,150));
		
		//add Panels to Frame
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		
		//Frame-Layout Setting
		frame.setLayout(null); //necessary to use custom Boundaries for Labels
		
		//other Settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//-----------------------------Panels-------------------------
		//(Panel ~ Container for content)
		panel1.setBounds(0,0,400,650);
		panel1.setBackground(Color.white);
		
		panel2.setBounds(410,0,300,300);
		panel2.setBackground(Color.blue);
		
		panel3.setBounds(410,310,300,300);
		panel3.setBackground(Color.green);
		
		//Panel-Layout Setting
		panel1.setLayout(null); //necessary to use custom Boundaries for Labels
		
		
		//-----------------------------Buttons-------------------------
		buttonAdd.setBounds(50, 60, 300, 50);
		buttonAdd.setText("Task anlegen");
		buttonAdd.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		buttonAdd.setFont(new Font("Domani", Font.BOLD, 20));
		buttonAdd.setHorizontalTextPosition(JButton.LEFT);
		addTask = this.rescaleImage(50,50, addTask);
		buttonAdd.setIcon(addTask);

		
		buttonShowAll.setBounds(50, 120, 300, 50);
		buttonShowAll.setText("Alle Tasks auflisten");
		buttonShowAll.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		buttonShowAll.setFont(new Font("Domani", Font.BOLD, 20));
		buttonShowAll.setHorizontalTextPosition(JButton.LEFT);
		listAllTasks = this.rescaleImage(50,50, listAllTasks);
		buttonShowAll.setIcon(listAllTasks);
		
		buttonShowUncompleted.setBounds(50, 180, 300, 100);
		buttonShowUncompleted.setText("Nicht erledigte Tasks auflisten");
		buttonShowUncompleted.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		buttonShowUncompleted.setFont(new Font("Domani", Font.BOLD, 20));
		buttonShowUncompleted.setHorizontalTextPosition(JButton.LEFT);
		listUncompletedTasks = this.rescaleImage(50,50, listUncompletedTasks);
		buttonShowUncompleted.setIcon(listUncompletedTasks);
		
		buttonDeleteUncompleted.setBounds(50, 300, 300, 50);
		buttonDeleteUncompleted.setText("Erledigte Tasks l\u00f6schen");//Erledigte Tasks löschen
		buttonDeleteUncompleted.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		buttonDeleteUncompleted.setFont(new Font("Domani", Font.BOLD, 20));
		buttonDeleteUncompleted.setHorizontalTextPosition(JButton.LEFT);
		deleteCompletedTasks = this.rescaleImage(50,50, deleteCompletedTasks);
		buttonDeleteUncompleted.setIcon(deleteCompletedTasks);
		
		//!!!!!!!!!!!!!!!  Hover over bug should be gone after implementing a Layout Manager !!!!!!!!!!!!!!!!!
		
		//add ActionListeners (~ Functionalities) to Buttons
		buttonAdd.addActionListener(func -> System.out.println("OUCH!!"));
		
		//-----------------------------Labels-------------------------
		label.setText("labiles Label");
		label.setForeground(new Color(0,0,0));
		label.setFont(new Font("Domani", Font.BOLD, 20));
		
		//Boundaries
		label.setBounds(0,0,400,50); //relative to the Container (Frame or Panel);
		
		//Border for Label
		label.setBorder(border);
	
		//Alignment
		label.setVerticalAlignment(JLabel.BOTTOM);
		label.setHorizontalAlignment(JLabel.RIGHT);

		//relational to Images
		//label.setHorizontalTextPosition(JLabel.CENTER);
		//label.setVerticalTextPosition(JLabel.CENTER);
		
		//----------------adding Labels to Frames or Panels-------------------
		//frame.add(label);
		panel1.add(label);
		panel1.add(buttonAdd);
		panel1.add(buttonShowAll);
		panel1.add(buttonShowUncompleted);
		panel1.add(buttonDeleteUncompleted);
		
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
