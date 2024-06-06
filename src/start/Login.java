package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textEmailLogin;
	private JPasswordField textPassLogin;
	Connection con;

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

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textEmailLogin = new JTextField();
		textEmailLogin.setBounds(23, 293, 300, 40);
		textEmailLogin.setFont(new Font("Arial", Font.BOLD, 15));
		textEmailLogin.setBackground(new Color(255, 255, 255));
		textEmailLogin.setForeground(Color.BLACK);
		textEmailLogin.setOpaque(false);
		textEmailLogin.setBorder(null);
		contentPane.add(textEmailLogin);
		textEmailLogin.setColumns(10);
		
        textPassLogin = new JPasswordField();
        textPassLogin.setBounds(23, 374, 300, 40);
        textPassLogin.setFont(new Font("Arial", Font.BOLD, 15));
        textPassLogin.setForeground(Color.BLACK);
        textPassLogin.setOpaque(false);
        textPassLogin.setBorder(null);
        contentPane.add(textPassLogin);
		
		JLabel lblSignupLogin = new JLabel("");
		lblSignupLogin.setBounds(103, 557, 140, 14);
		lblSignupLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register registerFrame = new Register();
                registerFrame.setVisible(true);
                dispose(); 
			}
		});
		
		lblSignupLogin.setIcon(new ImageIcon(Login.class.getResource("/img/SignUp.png")));
		lblSignupLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSignupLogin);
		
		JButton btnLogin = new JButton("");
		btnLogin.setBounds(79, 477, 188, 50);
	    btnLogin.setIcon(new ImageIcon(Login.class.getResource("/img/Login Button.png")));
	    contentPane.add(btnLogin);
	   
	    btnLogin.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
	          int checkLogin = addLogin(0); // Panggil method addLogin()
	                
	          if (checkLogin == 1) {
	              Akun.selectEmail = textEmailLogin.getText();
	              Akun.selectPassword = textPassLogin.getPassword();
	              Transaksi.selectEmail = textEmailLogin.getText();
		          Home homeFrame = new Home();
		          homeFrame.setVisible(true);
		          dispose();
	             } 
	          else {
	             }
	            }
	           }
	        );

        btnLogin.setIcon(new ImageIcon(Login.class.getResource("/img/Login Button.png")));
        contentPane.add(btnLogin);
		
		JLabel lblTextPassword = new JLabel("");
		lblTextPassword.setBounds(23, 353, 73, 10);
		lblTextPassword.setIcon(new ImageIcon(Login.class.getResource("/img/PassLogin.png")));
		lblTextPassword.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblTextPassword);
		
		JLabel lblTextEmail = new JLabel("");
		lblTextEmail.setBounds(23, 272, 73, 10);
		lblTextEmail.setIcon(new ImageIcon(Login.class.getResource("/img/Email address.png")));
		lblTextEmail.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblTextEmail);
		
		JLabel barPasswordLogin = new JLabel("");
		barPasswordLogin.setBounds(17, 368, 312, 50);
		barPasswordLogin.setIcon(new ImageIcon(Login.class.getResource("/img/Rectangle 3.png")));
		barPasswordLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(barPasswordLogin);
		
		JLabel barEmailLogin = new JLabel("");
		barEmailLogin.setBounds(17, 288, 312, 50);
		barEmailLogin.setIcon(new ImageIcon(Login.class.getResource("/img/Rectangle 3.png")));
		barEmailLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(barEmailLogin);
		
		JLabel lblBGLogin = new JLabel("");
		lblBGLogin.setBounds(0, 0, 360, 620);
		lblBGLogin.setIcon(new ImageIcon(Login.class.getResource("/img/bg login.png")));
		lblBGLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBGLogin);
	}

	public int addLogin(int data) {
	    int checkLogin = 0; // Inisialisasi checkLogin dengan nilai default

	    try {
	        String email = textEmailLogin.getText();
	        char[] password = textPassLogin.getPassword();
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        String query = "SELECT * FROM pengguna WHERE email_pengguna = ? AND password_pengguna = ?";
	        PreparedStatement statementLogin = con.prepareStatement(query);
	        statementLogin.setString(1, email);
	        statementLogin.setString(2, new String(password));

	        ResultSet resultSet = statementLogin.executeQuery();

	        if (resultSet.next()) {
	            System.out.println("Login berhasil!");
	            checkLogin = 1; // Jika login berhasil, set checkLogin ke 1
	        } else {
	            // Tidak perlu melakukan apa-apa karena checkLogin sudah bernilai 0 secara default
	        }

	        resultSet.close();
	        statementLogin.close();
	        con.close();
	    } catch (ClassNotFoundException e) {
	        System.err.println(e);
	    } catch (SQLException e) {
	        System.err.println(e);
	    }

	    return checkLogin; // Mengembalikan nilai checkLogin setelah query dieksekusi
	}

}
