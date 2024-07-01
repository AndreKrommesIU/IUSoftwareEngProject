package ToDo_List;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableCellRenderer;
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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class ListAllTasksWindow {

	private static final int frameWidth = 1000;
	private static final int frameHeight = 520;
	
	private JFrame frame = new JFrame();

	private JButton buttonDeleteCompleted = new JButton();
	private JButton returnToMainMenu = new JButton();
	
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTable table = new JTable(){
	        @Override
			public Class getColumnClass(int column) {
	            switch (column) {
                	case 0:
                		return String.class;
	            	case 2:
	                    return Integer.class;
	                case 3:
	                    return Boolean.class;
	                default:
	                    return String.class;
	            }
	        }
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            if (column == 3) {
	            	return true;
	            }
	            return false;
			}
		};
	
	private String[] col;
	private Object[][] data;
	
	private ImageIcon logo = new ImageIcon("ToDo_Icon.png");
	private ImageIcon deleteCompletedTasks = new ImageIcon("ToDo_DeleteDone.png");
	private ImageIcon returnToMain = new ImageIcon("Return.png");

	private ImageIcon checkNo = new ImageIcon("CheckNo.png");
	private ImageIcon checkYes = new ImageIcon("CheckYes.png");
	
	
	ListAllTasksWindow(){
		
		frame.setSize(frameWidth,frameHeight);
		frame.setTitle("alle Tasks anzeigen");
		frame.setResizable(false);
		
		frame.setIconImage(logo.getImage());
		
		frame.getContentPane().setBackground(new Color(150,150,150));
		
		frame.setLayout(new FlowLayout(FlowLayout.LEADING,20,10));
		
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//-> beenden über Button, der das initiale Fenster wieder aufruft
	

	//--------------------------------------------------------------------------------------	
		
		col = new String[] {"Titel", "Projekt", "Priorität", "Status", "erstellt am", "fällig bis"};
		data = this.getData();
	
		tableModel.setDataVector(data, col);
		table.setModel(tableModel);
		table.setAutoCreateRowSorter(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		table.setVisible(true);
		table.setDefaultEditor(Object.class, null);
		table.setFont(new Font("Domani", Font.BOLD, 15));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		
		table.setAutoCreateRowSorter(true);
		
	//--------------------------Custom CheckBox Icons------------------------------------------------------------
		
		//BUG: while Mouse is pressed, the Icon shows the (pressed) default CheckBox Icon instead of the custom one
		//happens only for JCheckboxes in a Table!!
		//ums verrecken nicht hinbekommen das zu fixen, also nein!	
		
//		checkNo = this.rescaleImage(15, 15, checkNo);
//		checkYes = this.rescaleImage(15, 15, checkYes);
	
	//https://stackoverflow.com/questions/56877244/trying-to-replace-boolean-checkbox-renderer-editor-in-jtable
		
		//call and check the default editor component:
		//DefaultCellEditor dce = (DefaultCellEditor)table.getDefaultEditor(Boolean.class);
		//JCheckBox cbe = (JCheckBox)dce.getComponent();
        //frame.add(dce.getComponent());
		
		//change the default rendering method for Boolean values:
			//default check box -> custom unselected/selected Icons
//		TableCellRenderer tcr = table.getDefaultRenderer(Boolean.class);
//		JCheckBox cbr = (JCheckBox)tcr;
//        cbr.setSelectedIcon(checkYes);
//        cbr.setIcon(checkNo);
        
	//--------------------------------------------------------------------------------------		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVisible(true);
		scrollPane.setPreferredSize(new Dimension(frameWidth - 50, 400));
		scrollPane.setBackground(Color.lightGray);
		
		//scrollPane.setLayout(new FlowLayout(FlowLayout.LEADING,20,10));
	//--------------------------------------------------------------------------------------	
		
		buttonDeleteCompleted.setPreferredSize(new Dimension(465,50));
		buttonDeleteCompleted.setText("<html>Erledigte Tasks löschen</html>");//Erledigte Tasks löschen
		buttonDeleteCompleted.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		buttonDeleteCompleted.setFont(new Font("Domani", Font.BOLD, 20));
		buttonDeleteCompleted.setHorizontalTextPosition(JButton.LEFT);
		deleteCompletedTasks = this.rescaleImage(50,50, deleteCompletedTasks);
		buttonDeleteCompleted.setIcon(deleteCompletedTasks);
		
		
		returnToMainMenu.setPreferredSize(new Dimension(465,50));
		returnToMainMenu.setText("Zurück zum Hauptmenü");
		returnToMainMenu.setFocusable(false); //Can no longer get focused (e.g. by pressing tabulator)
		returnToMainMenu.setFont(new Font("Domani", Font.BOLD, 20));
		returnToMainMenu.setHorizontalTextPosition(JButton.LEFT);
		returnToMain = this.rescaleImage(40,40, returnToMain);
		returnToMainMenu.setIcon(returnToMain);
		
		returnToMainMenu.addActionListener(func -> saveTableCompletionStatusChangesToFile());
		returnToMainMenu.addActionListener(func -> new GUI());
		returnToMainMenu.addActionListener(func -> frame.dispose());
		
		buttonDeleteCompleted.addActionListener(func -> deleteCompletedTasksButton());
		
	//--------------------------------------------------------------------------------------	
		
		frame.add(scrollPane);
		
		frame.add(returnToMainMenu);
		frame.add(buttonDeleteCompleted);
	
		frame.setVisible(true);

	}
	
	//------------------------------------Methoden--------------------------------------------------
	
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
	
	public void saveTableCompletionStatusChangesToFile() {
		
		
		ToDo_Array currentTaskList = new ToDo_Array();
		currentTaskList.readToDoListFile();
		
//		ArrayList<String> titleList = new ArrayList<String>();
//		for (int i = 0; i < numberOfTasksInFile; i++) {
//			titleList.add(currentTaskList.getTask(i).getTitle());
//		}
		int numberOfTasksInFile = currentTaskList.getTaskList().size();
		int rowsInTable = table.getRowCount();
		
		for (int i = 0; i < numberOfTasksInFile; i++) {
			String currentTaskTitle = currentTaskList.getTask(i).getTitle();
			
			for (int j = 0; j < rowsInTable; j++) {
				String currentRowTitle = (String) table.getValueAt(j, 0);
				if (currentTaskTitle.equals(currentRowTitle)) {
					boolean currentRowCompletionStatus = (boolean) table.getValueAt(j, 3);
					currentTaskList.getTask(i).setCompletion_status(currentRowCompletionStatus);
					continue;
				}
				
			}
		}
		currentTaskList.writeToDoListFile();
	}

	public void deleteCompletedTasksButton(){
		
		this.saveTableCompletionStatusChangesToFile();
		
		ToDo_Array currentTaskList = new ToDo_Array();
		currentTaskList.readToDoListFile();
		
		int completedTasks = currentTaskList.countCompleteTasksInList();
		if (completedTasks == 0) {
			String Message = "<html>Keine erledigten Tasks zum Löschen vorhanden.</html>";
			JOptionPane.showMessageDialog(null, Message, "Achtung", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		String Message = "<html>" + completedTasks +" Task(s) werden mit dieser Aktion gelöscht."
				+ "<br />Fortfahren?</html>";
		int userCoice = JOptionPane.showConfirmDialog(null, Message, "Achtung", JOptionPane.YES_NO_OPTION);
		
		if (userCoice == 0) {
			currentTaskList.deleteCompletedTasks();
			currentTaskList.writeToDoListFile();
			
			data = this.getData();
			tableModel.setDataVector(data, col);
			table.setModel(tableModel);
			}
	}
	
	
	
	public ImageIcon rescaleImage(int x, int y, ImageIcon imgc) {
		Image img = imgc.getImage();
		Image newImg = img.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newImgIcon = new ImageIcon(newImg);
		return newImgIcon;
	}
	
}