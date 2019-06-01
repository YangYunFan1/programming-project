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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(210, 180, 140));
		setTitle("Update");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 337);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(119, 135, 115, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 186, 286, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(388, 24, 115, 28);
		contentPane.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(205, 133, 63));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Humanities", "Natural"}));
		comboBox.setBounds(119, 81, 104, 29);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Book number:");
		lblNewLabel.setBackground(new Color(205, 133, 63));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 140, 104, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book name:");
		lblNewLabel_1.setBackground(new Color(205, 133, 63));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 191, 93, 15);
		contentPane.add(lblNewLabel_1);
		//文本为空的话提示输入相应信息，打开文本检查有编号与textField_2.getText()相同的编号，将其他用户信息存入ArrayList数组，将与textField_2.getText()相同信息修改后存入ArrayList数组，将ArrayList数组里的数据覆盖原来文本
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().equals(""))
				{
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					JOptionPane.showMessageDialog(null, "Please enter the book number to be modified:", "Title",JOptionPane.WARNING_MESSAGE);
				}
				else {
					String Booknumber = textField.getText();
					String Bookname = textField_1.getText();
					String compile = textField_2.getText();
					String Booktype = comboBox.getSelectedItem().toString();
					String line = null;
					int flag = 0;
				    File file = new File("Book.txt"); 
				    List list = new ArrayList();
				    BufferedReader content;
					try {
						content = new BufferedReader(new FileReader(file.getAbsolutePath()));
						
						while( (line=content.readLine()) != null )
						{
							String[] data = line.split(" ");
							if(data[0].equals(compile))
							{
								flag = 1;
								if(Booknumber.equals(""))
									Booknumber = data[0];
								if(Bookname.equals(""))
									Bookname = data[1];
								line =Booknumber+" "+Bookname+" "+Booktype ;   
								list.add(line);
							}
							else
								list.add(line);
						} 
						if(flag == 0)
						{
							JOptionPane.showMessageDialog(null, "No Book.", "Title",JOptionPane.WARNING_MESSAGE);
						}
						else{
						BufferedWriter wcontent ;
						try {
							wcontent = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
							for( int i=0;i<list.size();i++ ){
								wcontent.write(list.get(i).toString());
								wcontent.newLine();
								}
							wcontent.flush();
							wcontent.close();
							textField.setText("");
							JOptionPane.showMessageDialog(null, "Successful Update");
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "Write failure", "Title",JOptionPane.WARNING_MESSAGE);
						}
						}
						}catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "File not found,Please Add", "Title",JOptionPane.WARNING_MESSAGE);
					}
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(205, 133, 63));
		btnNewButton.setBounds(496, 232, 93, 23);
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
		btnReturn.setBounds(496, 265, 93, 23);
		contentPane.add(btnReturn);
		
		JLabel lblBookType = new JLabel("Book type:");
		lblBookType.setFont(new Font("宋体", Font.PLAIN, 16));
		lblBookType.setBackground(new Color(205, 133, 63));
		lblBookType.setBounds(10, 87, 96, 15);
		contentPane.add(lblBookType);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the book number to be modified:");
		lblPleaseEnterThe.setFont(new Font("宋体", Font.PLAIN, 16));
		lblPleaseEnterThe.setBackground(new Color(205, 133, 63));
		lblPleaseEnterThe.setBounds(10, 29, 368, 15);
		contentPane.add(lblPleaseEnterThe);
	}
}
