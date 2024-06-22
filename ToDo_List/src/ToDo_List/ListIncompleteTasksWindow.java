package ToDo_List;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.SortOrder;
import javax.swing.JScrollPane;
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
import java.util.List;
import java.util.ArrayList;

public class ListIncompleteTasksWindow {

	private static final int frameWidth = 1000;
	private static final int frameHeight = 600;
	
	private JFrame frame = new JFrame();

	private JButton returnToMainMenu = new JButton();
	
	private ImageIcon logo = new ImageIcon("ToDo_Icon.png");
	private ImageIcon returnToMain = new ImageIcon("Return.png");

	
	ListIncompleteTasksWindow(){
		
		
		frame.setSize(frameWidth,frameHeight);
		frame.setTitle("alle Tasks anzeigen");
		frame.setResizable(false);
		
		frame.setIconImage(logo.getImage());
		
		frame.getContentPane().setBackground(new Color(150,150,150));
		
		frame.setLayout(new FlowLayout(FlowLayout.LEADING,20,10));
		
		//frame.add(panel1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//-> beenden über Button, der das initiale Fenster wieder aufruft
	

	//--------------------------------------------------------------------------------------	
		
		String[] col;
		Object[][] data;
		
		col = new String[] {"Titel", "Projekt", "Priorität", "Status", "erstellt am", "fällig bis"};
		data = this.getData();
	
		DefaultTableModel tableModel = new DefaultTableModel(data, col);
		
		//needs adjustment, if the field will be replaces by Icons/Checkboxes
		for (int i =0; i < data.length; i++) {
			if (data[i][3] == "erledigt") {	
				tableModel.removeRow(i);
			}
		}
		
		JTable table = new JTable(tableModel);
		table.setVisible(true);
		table.setDefaultEditor(Object.class, null);
		table.setFont(new Font("Domani", Font.BOLD, 15));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		
		table.setAutoCreateRowSorter(true);
		
		//for specified columns only (i guess???)
//		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
//		table.setRowSorter(sorter);
//		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
//		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
//		sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
//		sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
//		sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
//		sortKeys.add(new RowSorter.SortKey(5, SortOrder.ASCENDING));
//		sorter.setSortKeys(sortKeys);
		
	//--------------------------------------------------------------------------------------		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVisible(true);
		scrollPane.setPreferredSize(new Dimension(frameWidth - 50, 400));
		scrollPane.setBackground(Color.lightGray);
		
		//scrollPane.setLayout(new FlowLayout(FlowLayout.LEADING,20,10));
	//--------------------------------------------------------------------------------------	
		
		returnToMainMenu.setPreferredSize(new Dimension(550,50));
		returnToMainMenu.setText("Zurück zum Hauptmenü");
		returnToMainMenu.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		returnToMainMenu.setFont(new Font("Domani", Font.BOLD, 20));
		returnToMainMenu.setHorizontalTextPosition(JButton.LEFT);
		returnToMain = this.rescaleImage(40,40, returnToMain);
		returnToMainMenu.setIcon(returnToMain);
		
		returnToMainMenu.addActionListener(func -> 	new GUI());
		returnToMainMenu.addActionListener(func -> frame.dispose());
		
	//--------------------------------------------------------------------------------------	
		
		frame.add(scrollPane);
		
		frame.add(returnToMainMenu);
		frame.setVisible(true);
	
	
	
	}
	
	
	
	public Object[][] getData(){
		
		ToDo_Array currentTaskList = new ToDo_Array();
		currentTaskList.readToDoListFile();
		
		int rows  = currentTaskList.countAllTasksInList();
		int cols = new Task().getAttributeCount(); 				
		Object[][] data  = new Object[rows][cols];
		
		Task[] currentTaskArray = currentTaskList.turnArrayListIntoArray();
		
		for (int i=0; i < rows; i++) {
			Task currentTask = currentTaskArray[i];
			data[i] = currentTask.turnTaskIntoArray();
		}
		return data;
	}
	

	
	
	public ImageIcon rescaleImage(int x, int y, ImageIcon imgc) {
		Image img = imgc.getImage();
		Image newImg = img.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newImgIcon = new ImageIcon(newImg);
		return newImgIcon;
	}
	
}
