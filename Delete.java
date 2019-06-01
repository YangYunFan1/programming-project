package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setTitle("Delete");
		setBackground(new Color(210, 180, 140));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 230);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(153, 73, 161, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//删除所有图书信息
		JButton btnNewButton = new JButton("Delete all");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter wcontent ;
				File file = new File("Book.txt"); 
				try {
					wcontent = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
					wcontent.write("");
					wcontent.flush();
					wcontent.close();
					JOptionPane.showMessageDialog(null, "Successful Delete");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "File not found,Please Add", "Title",JOptionPane.WARNING_MESSAGE);
				}	
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(205, 133, 63));
		btnNewButton.setBounds(273, 158, 101, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainInterface maininterface = new MainInterface();
				maininterface.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(205, 133, 63));
		btnNewButton_1.setBounds(384, 158, 93, 23);
		contentPane.add(btnNewButton_1);
		//文本为空的话提示输入相应信息，先打开Book文本，将不删除的信息保存到ArrayList数组里，删除的信息不保存，然后再打开Book文本，将ArrayList数组里的数据覆盖原来文本，完成删除。
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Book Number cannot be empty", "Title",JOptionPane.WARNING_MESSAGE);
				else
				{
					String Booknumber = textField.getText();
					String line = null;			
					File file = new File("Book.txt"); 
					int flag = 0;
					int m = 0;
					List list = new ArrayList();
					BufferedReader content;
					try {
						content = new BufferedReader(new FileReader(file.getAbsolutePath()));
						while( (line=content.readLine()) != null )
						{
							m++;
							String[] data = line.split(" ");
							if(!data[0].equals(Booknumber))
							{
								list.add(line);
								flag++;
							}
						}
						if(flag == m)
						{
							JOptionPane.showMessageDialog(null, "No book.", "Title",JOptionPane.WARNING_MESSAGE);
							textField.setText("");
						}
						else {
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
								JOptionPane.showMessageDialog(null, "Successful Delete");
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(null, "Delete failure", "Title",JOptionPane.WARNING_MESSAGE);
							}	
						}
						}catch (IOException e2) {
							textField.setText("");
							JOptionPane.showMessageDialog(null, "File not found,Please Add", "Title",JOptionPane.WARNING_MESSAGE);
						}
					
				}
			}
		});
		btnNewButton_2.setBackground(new Color(205, 133, 63));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_2.setBounds(335, 72, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Book Number:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 76, 93, 15);
		contentPane.add(lblNewLabel);
	}

}
