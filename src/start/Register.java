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

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNameRegister;
	private JTextField textUsernameRegister;
	private JTextField textEmailRegister;
	private JTextField textPhoneRegister;
	private JPasswordField textPassRegister;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNameRegister = new JTextField();
		textNameRegister.setBounds(25, 158, 296, 40);
		contentPane.add(textNameRegister);
		textNameRegister.setFont(new Font("Arial", Font.BOLD, 15));
		textNameRegister.setBackground(new Color(255, 255, 255));
		textNameRegister.setForeground(Color.BLACK);
		textNameRegister.setOpaque(false);
		textNameRegister.setBorder(null);
		textNameRegister.setColumns(10);
		
		textUsernameRegister = new JTextField();
		textUsernameRegister.setBounds(25, 227, 296, 40);
		contentPane.add(textUsernameRegister);
		textUsernameRegister.setFont(new Font("Arial", Font.BOLD, 15));
		textUsernameRegister.setBackground(new Color(255, 255, 255));
		textUsernameRegister.setForeground(Color.BLACK);
		textUsernameRegister.setOpaque(false);
		textUsernameRegister.setBorder(null);
		textUsernameRegister.setColumns(10);
		
		textEmailRegister = new JTextField();
		textEmailRegister.setBounds(25, 296, 296, 40);
		contentPane.add(textEmailRegister);
		textEmailRegister.setFont(new Font("Arial", Font.BOLD, 15));
		textEmailRegister.setBackground(new Color(255, 255, 255));
		textEmailRegister.setForeground(Color.BLACK);
		textEmailRegister.setOpaque(false);
		textEmailRegister.setBorder(null);
		textEmailRegister.setColumns(10);
		
		textPhoneRegister = new JTextField();
		textPhoneRegister.setBounds(25, 366, 296, 40);
		contentPane.add(textPhoneRegister);
		textPhoneRegister.setFont(new Font("Arial", Font.BOLD, 15));
		textPhoneRegister.setBackground(new Color(255, 255, 255));
		textPhoneRegister.setForeground(Color.BLACK);
		textPhoneRegister.setOpaque(false);
		textPhoneRegister.setBorder(null);
		textPhoneRegister.setColumns(10);
		
		textPassRegister = new JPasswordField();
		textPassRegister.setBounds(25, 436, 296, 40);
		textPassRegister.setFont(new Font("Arial", Font.BOLD, 15));
		textPassRegister.setBackground(new Color(255, 255, 255));
		textPassRegister.setForeground(Color.BLACK);
		textPassRegister.setOpaque(false);
		textPassRegister.setBorder(null);
		textPassRegister.setColumns(10);
		contentPane.add(textPassRegister);
		
		JLabel barNameRegister = new JLabel("");
		barNameRegister.setIcon(new ImageIcon(Register.class.getResource("/img/Nama_Regist.png")));
		barNameRegister.setHorizontalAlignment(SwingConstants.CENTER);
		barNameRegister.setBounds(17, 136, 312, 67);
		contentPane.add(barNameRegister);
		
		JLabel barUsernameRegister = new JLabel("");
		barUsernameRegister.setIcon(new ImageIcon(Register.class.getResource("/img/Username_Regis.png")));
		barUsernameRegister.setHorizontalAlignment(SwingConstants.CENTER);
		barUsernameRegister.setBounds(17, 205, 312, 67);
		contentPane.add(barUsernameRegister);
		
		JLabel barEmailRegister = new JLabel("");
		barEmailRegister.setIcon(new ImageIcon(Register.class.getResource("/img/Email_Regist.png")));
		barEmailRegister.setHorizontalAlignment(SwingConstants.CENTER);
		barEmailRegister.setBounds(17, 275, 312, 67);
		contentPane.add(barEmailRegister);
		
		JLabel barPhoneRegister = new JLabel("");
		barPhoneRegister.setIcon(new ImageIcon(Register.class.getResource("/img/Phonenumber_Regist.png")));
		barPhoneRegister.setHorizontalAlignment(SwingConstants.CENTER);
		barPhoneRegister.setBounds(17, 345, 312, 67);
		contentPane.add(barPhoneRegister);
		
		JLabel barPasswordRegister = new JLabel("");
		barPasswordRegister.setIcon(new ImageIcon(Register.class.getResource("/img/Password_Regist.png")));
		barPasswordRegister.setHorizontalAlignment(SwingConstants.CENTER);
		barPasswordRegister.setBounds(17, 415, 312, 67);
		contentPane.add(barPasswordRegister);
		
		JButton btnSignupRegister = new JButton("");
		btnSignupRegister.setIcon(new ImageIcon(Register.class.getResource("/img/Signupbutton.png")));
		btnSignupRegister.setBounds(80, 495, 186, 50);
	    contentPane.add(btnSignupRegister);
		   
	    btnSignupRegister.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		     int checkRegister = addRegister(0); // Panggil method addRegister()
		                
		      if (checkRegister == 1) {
                  Akun.selectEmail = textEmailRegister.getText();
                  Akun.selectPassword = textPassRegister.getPassword();
                  Transaksi.selectEmail = textEmailRegister.getText();
			  Home homeFrame = new Home();
			  homeFrame.setVisible(true);
			  dispose();
		       } 
		      else {
		        }
		     }
		   }
		);
		
		JLabel lblLoginRegister = new JLabel("");
		lblLoginRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login loginFrame = new Login();
                loginFrame.setVisible(true);
                dispose(); 
			}
		});
		lblLoginRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginRegister.setIcon(new ImageIcon(Register.class.getResource("/img/Confirm_Login.png")));
		lblLoginRegister.setBounds(103, 558, 140, 13);
		contentPane.add(lblLoginRegister);
		
		JLabel lblBGRegister = new JLabel("");
		lblBGRegister.setIcon(new ImageIcon(Register.class.getResource("/img/bg register.png")));
		lblBGRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGRegister.setBounds(-7, 0, 360, 620);
		contentPane.add(lblBGRegister);
	}
	
	public int addRegister(int data) {
	    int checkRegister = 0; // Inisialisasi nilai checkRegister dengan default 0

	    try {
	        String username = textUsernameRegister.getText();
	        String email = textEmailRegister.getText();
	        String phone = textPhoneRegister.getText();
	        char[] password = textPassRegister.getPassword();
	        String kategori = "Reguler";

	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        String duplicateCheckQuery = "SELECT * FROM pengguna WHERE email_pengguna = ? OR username_pengguna = ? OR notelp_pengguna = ?";
	        PreparedStatement statementCekDuplikat = con.prepareStatement(duplicateCheckQuery);
	        statementCekDuplikat.setString(1, email);
	        statementCekDuplikat.setString(2, username);
	        statementCekDuplikat.setString(3, phone);

	        ResultSet duplicateCheckResult = statementCekDuplikat.executeQuery();

	        if (duplicateCheckResult.next()) {
	            // Jika ada duplikat, set nilai checkRegister ke 0
	            checkRegister = 0;
	        } else {
	            String idPengguna = idGenerate(); // Memanggil fungsi untuk menghasilkan ID pengguna unik
	            String insertQuery = "INSERT INTO pengguna (id_pengguna, username_pengguna, email_pengguna, notelp_pengguna, password_pengguna, kategori_pengguna) VALUES (?, ?, ?, ?, ?, ?)";
	            PreparedStatement statementRegister = con.prepareStatement(insertQuery);
	            statementRegister.setString(1, idPengguna);
	            statementRegister.setString(2, username);
	            statementRegister.setString(3, email);
	            statementRegister.setString(4, phone);
	            statementRegister.setString(5, new String(password));
	            statementRegister.setString(6, kategori);

	            int rowsAffected = statementRegister.executeUpdate(); // Eksekusi pernyataan SQL untuk menyimpan data ke dalam tabel

	            if (rowsAffected > 0) {
	                // Jika penyimpanan berhasil, set checkRegister ke 1
	                checkRegister = 1;
	            }

	            statementRegister.close();
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        System.err.println(e);
	    }

	    return checkRegister; // Mengembalikan nilai checkRegister setelah proses selesai
	}

	// Fungsi untuk menghasilkan ID pengguna yang unik
	public String idGenerate() {
	    String uniqueID;
	    do {
	        int randomID = (int) (Math.random() * 900) + 100;
	        uniqueID = "PN" + randomID; // Tambahkan "PN" di depan randomID
	    } while (idCheck(uniqueID)); // Memeriksa apakah ID sudah ada dalam tabel

	    return uniqueID;
	}

	// Fungsi untuk memeriksa keberadaan ID dalam tabel pengguna
	public boolean idCheck(String idPengguna) {
	    boolean exists = false;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        String checkQuery = "SELECT * FROM pengguna WHERE id_pengguna = ?";
	        PreparedStatement checkStatement = con.prepareStatement(checkQuery);
	        checkStatement.setString(1, idPengguna);

	        ResultSet checkResult = checkStatement.executeQuery();

	        exists = checkResult.next(); // Mengatur exists ke true jika ID sudah ada dalam tabel

	    } catch (ClassNotFoundException | SQLException e) {
	        System.err.println(e);
	    }

	    return exists;
	}
	
}