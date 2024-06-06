package start;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginPekerja extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEmailLoginPekerja;
	private JPasswordField textPassLoginPekerja;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPekerja frame = new LoginPekerja();
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
	public LoginPekerja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textEmailLoginPekerja = new JTextField();
		textEmailLoginPekerja.setBounds(28, 323, 290, 38);
		textEmailLoginPekerja.setFont(new Font("Arial", Font.BOLD, 15));
		textEmailLoginPekerja.setBackground(new Color(255, 255, 255));
		textEmailLoginPekerja.setForeground(Color.BLACK);
		textEmailLoginPekerja.setOpaque(false);
		textEmailLoginPekerja.setBorder(null);
		contentPane.add(textEmailLoginPekerja);
		textEmailLoginPekerja.setColumns(10);
		
        textPassLoginPekerja = new JPasswordField();
        textPassLoginPekerja.setBounds(28, 415, 290, 38);
        textPassLoginPekerja.setFont(new Font("Arial", Font.BOLD, 15));
        textPassLoginPekerja.setForeground(Color.BLACK);
        textPassLoginPekerja.setOpaque(false);
        textPassLoginPekerja.setBorder(null);
        contentPane.add(textPassLoginPekerja);
		
		JLabel lblSignupLoginPekerja = new JLabel("");
		lblSignupLoginPekerja.setBounds(103, 557, 140, 14);
		lblSignupLoginPekerja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterPekerja registerPekerjaFrame = new RegisterPekerja();
				registerPekerjaFrame.setVisible(true);
                dispose(); 
			}
		});
		
		lblSignupLoginPekerja.setIcon(new ImageIcon(Login.class.getResource("/img/SignUp.png")));
		lblSignupLoginPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSignupLoginPekerja);
        
		JLabel barPasswordLoginPekerja = new JLabel("");
		barPasswordLoginPekerja.setIcon(new ImageIcon(LoginPekerja.class.getResource("/img/Password.png")));
		barPasswordLoginPekerja.setBounds(17, 395, 312, 64);
		contentPane.add(barPasswordLoginPekerja);
		
		JLabel barEmailLoginPekerja = new JLabel("");
		barEmailLoginPekerja.setIcon(new ImageIcon(LoginPekerja.class.getResource("/img/Email.png")));
		barEmailLoginPekerja.setBounds(17, 303, 312, 64);
		contentPane.add(barEmailLoginPekerja);
		
		JButton btnLoginPekerja = new JButton("");
		btnLoginPekerja.setBounds(79, 495, 188, 50);
	    btnLoginPekerja.setIcon(new ImageIcon(Login.class.getResource("/img/Login Button.png")));
	    contentPane.add(btnLoginPekerja);
	    
	    btnLoginPekerja.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		          int checkLogin = addLogin(0); // Panggil method addLogin()
		                
		          if (checkLogin == 1) {
		              AkunPekerja.selectEmail = textEmailLoginPekerja.getText();
		              AkunPekerja.selectPassword = textPassLoginPekerja.getPassword();
		              HomePekerja.selectEmail = textEmailLoginPekerja.getText();
		              TambahPekerjaan.selectEmail = textEmailLoginPekerja.getText();
			          HomePekerja homePekerjaFrame = new HomePekerja();
			          homePekerjaFrame.setVisible(true);
			          dispose();
		             } 
		          else {
		             }
		            }
		           }
		        );
		
		JLabel lblBGLoginPekerja = new JLabel("");
		lblBGLoginPekerja.setIcon(new ImageIcon(LoginPekerja.class.getResource("/img/bgLoginPekerja.jpg")));
		lblBGLoginPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGLoginPekerja.setBounds(-7, 0, 360, 620);
		contentPane.add(lblBGLoginPekerja);
	}

	public int addLogin(int data) {
	    int checkLogin = 0; // Inisialisasi checkLogin dengan nilai default

	    try {
	        String email = textEmailLoginPekerja.getText();
	        char[] password = textPassLoginPekerja.getPassword();
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        String query = "SELECT * FROM pekerja WHERE email_pekerja = ? AND password_pekerja = ?";
	        PreparedStatement statementLoginPekerja = con.prepareStatement(query);
	        statementLoginPekerja.setString(1, email);
	        statementLoginPekerja.setString(2, new String(password));

	        ResultSet resultSet = statementLoginPekerja.executeQuery();

	        if (resultSet.next()) {
	            System.out.println("Login berhasil!");
	            checkLogin = 1; // Jika login berhasil, set checkLogin ke 1
	        } else {
	            // Tidak perlu melakukan apa-apa karena checkLogin sudah bernilai 0 secara default
	        }

	        resultSet.close();
	        statementLoginPekerja.close();
	        con.close();
	    } catch (ClassNotFoundException e) {
	        System.err.println(e);
	    } catch (SQLException e) {
	        System.err.println(e);
	    }

	    return checkLogin; // Mengembalikan nilai checkLogin setelah query dieksekusi
	}
	
}
