package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainInterface() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(210, 180, 140));
		setTitle("Library Book Registration System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 493, 476);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(205, 133, 63));
		scrollPane.setViewportView(table);
		//每次search前会先清空Jtable里数据，通过split(" ")分割字符串，将用户相应信息显示在相应位置
		JButton btnNewButton_2 = new JButton("search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Book Name cannot be empty.", "Title",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					tableModel.setRowCount(0);
					Vector vData = new Vector();
					Vector vName = new Vector();
					vName.add("Book Number");
					vName.add("Book Name");
					vName.add("Book Type");
					File file = new File("Book.txt"); 
					int flag = 0;
					String line = null;
					BufferedReader content;
					try {
						content = new BufferedReader(new FileReader(file.getAbsolutePath()));
							while( (line =content.readLine()) != null )
							{
								String[] data = line.split(" ");
								if(data[0].equals(textField.getText()))
								{
									flag = 1;
									Vector vRow = new Vector();
								
									for(int x = 0; x < 3; x++)
									{
										vRow.add(data[x]);
									}
									vData.add(vRow.clone());
								}
							} 
							if(flag == 0)
								JOptionPane.showMessageDialog(null, "No Book.", "Title",JOptionPane.WARNING_MESSAGE);
							}catch (IOException e2) {
								JOptionPane.showMessageDialog(null, "File not found,Please Add", "Title",JOptionPane.WARNING_MESSAGE);
					}
					DefaultTableModel model = new DefaultTableModel(vData, vName);
					table.setModel(model);
				}
			}
		});
		btnNewButton_2.setBackground(new Color(205, 133, 63));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_2.setBounds(415, 78, 105, 27);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update update = new Update();
			    update.setVisible(true);
				dispose();
			}
		});
		button.setBackground(new Color(205, 133, 63));
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(547, 451, 93, 36);
		contentPane.add(button);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete delete = new Delete();
			    delete.setVisible(true);
				dispose();
			}
		});
		btnDelete.setBackground(new Color(205, 133, 63));
		btnDelete.setFont(new Font("宋体", Font.PLAIN, 16));
		btnDelete.setBounds(547, 343, 93, 36);
		contentPane.add(btnDelete);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add add = new Add();
			    add.setVisible(true);
				dispose();
			}
		});
		btnAdd.setBackground(new Color(205, 133, 63));
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 16));
		btnAdd.setBounds(547, 236, 93, 36);
		contentPane.add(btnAdd);
		
		textField = new JTextField();
		textField.setBounds(113, 79, 275, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Number:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(23, 78, 65, 24);
		contentPane.add(lblNewLabel);
		//清空Jtable里数据
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				tableModel.setRowCount(0);
			}
		});
		btnClear.setFont(new Font("宋体", Font.PLAIN, 16));
		btnClear.setBackground(new Color(205, 133, 63));
		btnClear.setBounds(547, 561, 93, 36);
		contentPane.add(btnClear);
		//将文本里所有信息显示在jtable里
		JButton btnShowAll = new JButton("Show all");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				tableModel.setRowCount(0);
				Vector vData = new Vector();
				Vector vName = new Vector();
				vName.add("Book Number");
				vName.add("Book Name");
				vName.add("Book Type");
				File file = new File("Book.txt"); 
				String line = null;
				BufferedReader content;
				try {
					content = new BufferedReader(new FileReader(file.getAbsolutePath()));
						while( (line=content.readLine()) != null )
						{
							Vector vRow = new Vector();
							String[] data = line.split(" ");
							for(int x = 0; x < 3; x++)
							{
								vRow.add(data[x]);
								
							}
							vData.add(vRow.clone());
						} 
						}catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "File not found,Please Add", "Title",JOptionPane.WARNING_MESSAGE);
				}
				DefaultTableModel model = new DefaultTableModel(vData, vName);
				table.setModel(model);
			}
		});
		btnShowAll.setFont(new Font("宋体", Font.PLAIN, 16));
		btnShowAll.setBackground(new Color(205, 133, 63));
		btnShowAll.setBounds(546, 78, 105, 27);
		contentPane.add(btnShowAll);

	}
}
