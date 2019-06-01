package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(210, 180, 140));
		setTitle("Add");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 248);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(119, 70, 115, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 117, 286, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(205, 133, 63));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Humanities", "Natural"}));
		comboBox.setBounds(121, 20, 96, 29);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Book number:");
		lblNewLabel.setBackground(new Color(205, 133, 63));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 75, 104, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book name:");
		lblNewLabel_1.setBackground(new Color(205, 133, 63));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 122, 93, 15);
		contentPane.add(lblNewLabel_1);
		//文本为空的话提示输入相应信息，先试图打开Book文本检查是否有相同的用户编号，有的话会有消息框提示错误，打不开会创建一个Book文本将信息保存
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Book Number cannot be empty", "Title",JOptionPane.WARNING_MESSAGE);
				}
				else if(textField_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Book Name cannot be empty", "Title",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					String Booknumber = textField.getText();
					String Bookname = textField_1.getText();
					String Booktype = comboBox.getSelectedItem().toString();
					String line = null;
					int flag = 0;
				    File file = new File("Book.txt"); 
				    BufferedReader content;
					try {
						content = new BufferedReader(new FileReader(file.getAbsolutePath()));
						
						while( (line=content.readLine()) != null )
						{
							String[] data = line.split(" ");
							if(data[0].equals(Booknumber))
								flag = 1;
						} 
						}catch (IOException e2) {
						}
					if(flag == 0)
						{
						try {   
							FileOutputStream book = new FileOutputStream (new File("Book.txt"), true) ; 
							book.write((Booknumber+" ").getBytes());
							book.write((Bookname+" ").getBytes());
							book.write((Booktype).getBytes());	 
							book.write("\r\n".getBytes());
							book.close ();  
							JOptionPane.showMessageDialog(null, "Successful Add");
							} catch (IOException a) {   
								JOptionPane.showMessageDialog(null, "Write failure", "Title",JOptionPane.WARNING_MESSAGE);  
							} 
						}
					else
						JOptionPane.showMessageDialog(null, "Book Number cannot be the same", "Title",JOptionPane.WARNING_MESSAGE);
					textField.setText(""); 
					textField_1.setText(""); 
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(205, 133, 63));
		btnNewButton.setBounds(496, 149, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainInterface maininterface = new MainInterface();
				maininterface.setVisible(true);
				dispose();
			}
		});
		btnReturn.setFont(new Font("宋体", Font.PLAIN, 14));
		btnReturn.setBackground(new Color(205, 133, 63));
		btnReturn.setBounds(496, 182, 93, 23);
		contentPane.add(btnReturn);
		
		JLabel lblBookType = new JLabel("Book type:");
		lblBookType.setFont(new Font("宋体", Font.PLAIN, 16));
		lblBookType.setBackground(new Color(205, 133, 63));
		lblBookType.setBounds(10, 27, 96, 15);
		contentPane.add(lblBookType);
	}
}
