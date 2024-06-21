package ToDo_List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddTaskWindow{
	
	
	private static final int frameWidth = 750;
	private static final int frameHeight = 750;
	private JFrame frame = new JFrame();

	private JPanel panel = new JPanel();
	
	private JLabel txtlabel1 = new JLabel();
	private JLabel txtlabel2 = new JLabel();
	private JLabel txtlabel3 = new JLabel();
	private JLabel txtlabel4 = new JLabel();
	
	private JTextField txtfield1 = new JTextField();
	private JTextField txtfield2 = new JTextField();
	private JTextField txtfield3 = new JTextField();
	private JTextField txtfield4 = new JTextField();
	
	private JButton buttonAddTask = new JButton();
	private JButton returnToMainMenu = new JButton();
	
	private ImageIcon logo = new ImageIcon("ToDo_Icon.png");
	
	AddTaskWindow(){
		
		frame.setSize(frameWidth,frameHeight);
		frame.setTitle("neue Task anlegen");
		frame.setResizable(false);
		
		frame.setIconImage(logo.getImage());
		
		frame.getContentPane().setBackground(new Color(150,150,150));
		
		//frame.setLayout(null);
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//-> beenden über Button, der das initiale Fenster wieder aufruft
		
	//--------------------------------------------------------------------------------------
		
		//panel.setPreferredSize(new Dimension(400,650));
		panel.setBackground(Color.lightGray);
		panel.setPreferredSize(new Dimension(frameWidth,frameHeight));
		panel.setLayout(new FlowLayout(FlowLayout.LEADING,20,10));
		
		//Panel-Layout Setting (standard Panel Layout = FlowLayout)
		//panel.setLayout(null); //necessary to use custom Boundaries for Labels
		
	//--------------------------------------------------------------------------------------
		
		txtlabel1.setText("Beschreibung der Task:");
		txtlabel1.setForeground(new Color(0,0,0));
		txtlabel1.setFont(new Font("Domani", Font.BOLD, 20));
		txtlabel1.setPreferredSize(new Dimension(500,40));

		txtlabel2.setText("Übergeordnetes Projekt (optional):");
		txtlabel2.setForeground(new Color(0,0,0));
		txtlabel2.setFont(new Font("Domani", Font.BOLD, 20));
		txtlabel2.setPreferredSize(new Dimension(500,40));
		
		txtlabel3.setText("Priorität (1 bis 3):");
		txtlabel3.setForeground(new Color(0,0,0));
		txtlabel3.setFont(new Font("Domani", Font.BOLD, 20));
		txtlabel3.setPreferredSize(new Dimension(500,40));
		
		txtlabel4.setText("Fällig bis (TT.MM.JJJJ):");
		txtlabel4.setForeground(new Color(0,0,0));
		txtlabel4.setFont(new Font("Domani", Font.BOLD, 20));
		txtlabel4.setPreferredSize(new Dimension(500,40));
		
	
		txtlabel1.setVerticalAlignment(JLabel.BOTTOM);
		txtlabel1.setHorizontalAlignment(JLabel.LEFT);
		txtlabel2.setVerticalAlignment(JLabel.BOTTOM);
		txtlabel2.setHorizontalAlignment(JLabel.LEFT);
		txtlabel3.setVerticalAlignment(JLabel.BOTTOM);
		txtlabel3.setHorizontalAlignment(JLabel.LEFT);
		txtlabel4.setVerticalAlignment(JLabel.BOTTOM);
		txtlabel4.setHorizontalAlignment(JLabel.LEFT);
			
	//--------------------------------------------------------------------------------------
		
		txtfield1.setPreferredSize(new Dimension(500,50));
		txtfield2.setPreferredSize(new Dimension(500,50));
		txtfield3.setPreferredSize(new Dimension(500,50));
		txtfield4.setPreferredSize(new Dimension(500,50));
		
		txtfield1.setFont(new Font("Domani", Font.PLAIN, 20));
		txtfield2.setFont(new Font("Domani", Font.PLAIN, 20));
		txtfield3.setFont(new Font("Domani", Font.PLAIN, 20));
		txtfield4.setFont(new Font("Domani", Font.PLAIN, 20));
		
		panel.add(txtlabel1);
		panel.add(txtfield1);
		
		panel.add(txtlabel2);
		panel.add(txtfield2);
		
		panel.add(txtlabel3);
		panel.add(txtfield3);
		
		panel.add(txtlabel4);
		panel.add(txtfield4);
		
	//--------------------------------------------------------------------------------------	
		
		buttonAddTask.setPreferredSize(new Dimension(500,50));
		buttonAddTask.setText("Task anlegen");
		buttonAddTask.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		buttonAddTask.setFont(new Font("Domani", Font.BOLD, 20));
		buttonAddTask.setHorizontalTextPosition(JButton.LEFT);
		
		returnToMainMenu.setPreferredSize(new Dimension(500,50));
		returnToMainMenu.setText("Zurück zum Hauptmenü");
		returnToMainMenu.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		returnToMainMenu.setFont(new Font("Domani", Font.BOLD, 20));
		returnToMainMenu.setHorizontalTextPosition(JButton.LEFT);
		
		buttonAddTask.addActionListener(func -> addTaskButtonAction());
		returnToMainMenu.addActionListener(func -> 	new GUI().createGUI());
		returnToMainMenu.addActionListener(func -> frame.dispose());
		
		panel.add(buttonAddTask);
		panel.add(returnToMainMenu);
	
	//--------------------------------------------------------------------------------------
		
		frame.setVisible(true);
		frame.pack();
	}



	public void addTaskButtonAction() {
		String title = txtfield1.getText();
		String project = txtfield2.getText();
		String strPrio = txtfield3.getText();
		String strDueDate = txtfield4.getText();		
		this.checkInputs(title, project, strPrio, strDueDate);

	}
	
	public void checkInputs(String title, String project, String strPrio, String strDueDate) {
		if (title.length() > 50) {
			String Message = "<html>Die eingegebene Beschreibung der Task ist zu lang!<br />Bitte verwenden Sie 50 Zeichen oder weniger.</html>";
			JOptionPane.showMessageDialog(null, Message, "Achtung", JOptionPane.PLAIN_MESSAGE);
		} else if (title.length() == 0){
			String Message = "<html>Bitte geben Sie eine Beschreibung für die Task</html>";
			JOptionPane.showMessageDialog(null, Message, "Achtung", JOptionPane.PLAIN_MESSAGE);
		}else if (project.length() > 15){
			String Message = "<html>Bitte verwenden sie eine Projektbeschreibung mit 15 Zeichen oder weniger!</html>";
			JOptionPane.showMessageDialog(null, Message, "Achtung", JOptionPane.PLAIN_MESSAGE);
		}else if (this.checkPrioInput(strPrio)){
			String Message = "<html>Bitte geben Sie für die Prioriät eine Zahl zwischen 1 und 3 (inkl.) an!</html>";
			JOptionPane.showMessageDialog(null, Message, "Achtung", JOptionPane.PLAIN_MESSAGE);
		}else if (Integer.parseInt(strPrio) > 3 || Integer.parseInt(strPrio) < 1){
			String Message = "<html>Bitte geben Sie für die Prioriät eine Zahl zwischen 1 und 3 (inkl.) an!</html>";
			JOptionPane.showMessageDialog(null, Message, "Achtung", JOptionPane.PLAIN_MESSAGE);
		}else if (this.checkDueDateInput(strDueDate)){
			String Message = "<html>Bitte geben Sie ein gütiges Datum im Format TT.MM.JJJJ an!<br />(z.B. 24.10.2010)</html>";
			JOptionPane.showMessageDialog(null, Message, "Achtung", JOptionPane.PLAIN_MESSAGE);
		}else {
			
			int priotity = Integer.parseInt(strPrio);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			LocalDate DueDate = LocalDate.parse(strDueDate, formatter);
			
			Task newTask = new Task(title, project, priotity, DueDate);
			ToDo_Array loadedTaskList = new ToDo_Array();
			loadedTaskList.readToDoListFile();
			loadedTaskList.addTaskToList(newTask);
			loadedTaskList.writeToDoListFile();
			
			String Message = "<html>Task \"" + newTask.getTitle() + "\" erfolgreich angelegt.</html>";
			JOptionPane.showMessageDialog(null, Message, "", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public boolean checkPrioInput(String strPrio) {
		try {
		   Integer.parseInt(strPrio);
		   return false;
		} catch (Exception e){
			return true;
			}	
	}
	
	public boolean checkDueDateInput(String strDueDate) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			LocalDate.parse(strDueDate, formatter);
		   return false;
		} catch (Exception e){
			return true;
			}	
	}

}
