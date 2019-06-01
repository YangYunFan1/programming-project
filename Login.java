package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String username;
	String user="admin",password="123123";
	/**
	 * Create the frame.
	 */
	public Login() {
		setForeground(new Color(0, 0, 0));
		setBackground(new Color(210, 180, 140));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 267);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibraryBookRegistration = new JLabel("Library Book Registration System");
		lblLibraryBookRegistration.setForeground(new Color(128, 0, 0));
		lblLibraryBookRegistration.setFont(new Font("ËÎÌו", Font.BOLD, 18));
		lblLibraryBookRegistration.setBounds(71, 10, 338, 51);
		contentPane.add(lblLibraryBookRegistration);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setForeground(Color.BLACK);
		textField.setBounds(170, 81, 146, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(172, 127, 144, 21);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 14));
		lblNewLabel.setBounds(83, 84, 66, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(83, 130, 66, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username=textField.getText();
				String password1 = String.valueOf(passwordField.getPassword());
				if(user.equals(username)&&password.equals(password1))
				{
				MainInterface f2 = new MainInterface();
			    f2.setVisible(true);
				dispose();
				}
				else {
					passwordField.setText("");
					JOptionPane.showMessageDialog(null, "The account number or password is incorrect. Please re-enter", "Title",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		btnNewButton.setBackground(new Color(205, 133, 63));
		btnNewButton.setBounds(184, 180, 93, 23);
		contentPane.add(btnNewButton);
	}

}
