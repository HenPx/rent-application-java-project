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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class RegisterPekerja extends JFrame {

	private static final long serialVersionUID = 1L;
	Connection con;
	private JPanel contentPane;
	private JTextField textNameRegisterPekerja;
	private JTextField textAlamatRegisterPekerja;
	private JTextField textPhoneRegisterPekerja;
	private JTextField textEmailRegisterPekerja;
	private JTextField textUsernameRegisterPekerja;
	private JPasswordField textPasswordRegisterPekerja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPekerja frame = new RegisterPekerja();
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
	public RegisterPekerja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPasswordRegisterPekerja = new JPasswordField();
		textPasswordRegisterPekerja.setOpaque(false);
		textPasswordRegisterPekerja.setForeground(Color.BLACK);
		textPasswordRegisterPekerja.setFont(new Font("Arial", Font.BOLD, 13));
		textPasswordRegisterPekerja.setColumns(10);
		textPasswordRegisterPekerja.setBorder(null);
		textPasswordRegisterPekerja.setBackground(Color.WHITE);
		textPasswordRegisterPekerja.setBounds(64, 449, 218, 32);
		contentPane.add(textPasswordRegisterPekerja);
		
		textUsernameRegisterPekerja = new JTextField();
		textUsernameRegisterPekerja.setOpaque(false);
		textUsernameRegisterPekerja.setForeground(Color.BLACK);
		textUsernameRegisterPekerja.setFont(new Font("Arial", Font.BOLD, 13));
		textUsernameRegisterPekerja.setColumns(10);
		textUsernameRegisterPekerja.setBorder(null);
		textUsernameRegisterPekerja.setBackground(Color.WHITE);
		textUsernameRegisterPekerja.setBounds(64, 390, 218, 32);
		contentPane.add(textUsernameRegisterPekerja);
		
		textEmailRegisterPekerja = new JTextField();
		textEmailRegisterPekerja.setOpaque(false);
		textEmailRegisterPekerja.setForeground(Color.BLACK);
		textEmailRegisterPekerja.setFont(new Font("Arial", Font.BOLD, 13));
		textEmailRegisterPekerja.setColumns(10);
		textEmailRegisterPekerja.setBorder(null);
		textEmailRegisterPekerja.setBackground(Color.WHITE);
		textEmailRegisterPekerja.setBounds(64, 330, 218, 32);
		contentPane.add(textEmailRegisterPekerja);
		
		textPhoneRegisterPekerja = new JTextField();
		textPhoneRegisterPekerja.setOpaque(false);
		textPhoneRegisterPekerja.setForeground(Color.BLACK);
		textPhoneRegisterPekerja.setFont(new Font("Arial", Font.BOLD, 13));
		textPhoneRegisterPekerja.setColumns(10);
		textPhoneRegisterPekerja.setBorder(null);
		textPhoneRegisterPekerja.setBackground(Color.WHITE);
		textPhoneRegisterPekerja.setBounds(64, 270, 218, 32);
		contentPane.add(textPhoneRegisterPekerja);
		
		textAlamatRegisterPekerja = new JTextField();
		textAlamatRegisterPekerja.setOpaque(false);
		textAlamatRegisterPekerja.setForeground(Color.BLACK);
		textAlamatRegisterPekerja.setFont(new Font("Arial", Font.BOLD, 13));
		textAlamatRegisterPekerja.setColumns(10);
		textAlamatRegisterPekerja.setBorder(null);
		textAlamatRegisterPekerja.setBackground(Color.WHITE);
		textAlamatRegisterPekerja.setBounds(64, 210, 218, 32);
		contentPane.add(textAlamatRegisterPekerja);
		
		textNameRegisterPekerja = new JTextField();
		textNameRegisterPekerja.setBounds(64, 150, 218, 32);
		contentPane.add(textNameRegisterPekerja);
		textNameRegisterPekerja.setFont(new Font("Arial", Font.BOLD, 13));
		textNameRegisterPekerja.setBackground(new Color(255, 255, 255));
		textNameRegisterPekerja.setForeground(Color.BLACK);
		textNameRegisterPekerja.setOpaque(false);
		textNameRegisterPekerja.setBorder(null);
		textNameRegisterPekerja.setColumns(10);
		
		JButton btnSignupRegisterPekerja = new JButton("");
		btnSignupRegisterPekerja.setIcon(new ImageIcon(RegisterPekerja.class.getResource("/img/btndaftarPekerja.png")));
		btnSignupRegisterPekerja.setBounds(60, 500, 226, 39);
		contentPane.add(btnSignupRegisterPekerja);
		
		btnSignupRegisterPekerja.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
			     int checkRegister = addRegister(0); // Panggil method addRegister()
			                
			      if (checkRegister == 1) {
	                  AkunPekerja.selectEmail = textEmailRegisterPekerja.getText();
	                  AkunPekerja.selectPassword = textPasswordRegisterPekerja.getPassword();
	                  HomePekerja.selectEmail = textEmailRegisterPekerja.getText();
		              TambahPekerjaan.selectEmail = textEmailRegisterPekerja.getText();
	                  HomePekerja homePekerjaFrame = new HomePekerja();
	                  homePekerjaFrame.setVisible(true);
	                  dispose();
			       } 
			      else {
			        }
			     }
			   }
			);
		
		JLabel barPasswordPasswordPekerja = new JLabel("");
		barPasswordPasswordPekerja.setIcon(new ImageIcon(RegisterPekerja.class.getResource("/img/Password_RegistPekerja.png")));
		barPasswordPasswordPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		barPasswordPasswordPekerja.setBounds(60, 435, 226, 51);
		contentPane.add(barPasswordPasswordPekerja);
		
		JLabel barUsernamePasswordPekerja = new JLabel("");
		barUsernamePasswordPekerja.setIcon(new ImageIcon(RegisterPekerja.class.getResource("/img/Username_RegistPekerja.png")));
		barUsernamePasswordPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		barUsernamePasswordPekerja.setBounds(60, 375, 226, 51);
		contentPane.add(barUsernamePasswordPekerja);
		
		JLabel barEmailPasswordPekerja = new JLabel("");
		barEmailPasswordPekerja.setIcon(new ImageIcon(RegisterPekerja.class.getResource("/img/Email_RegistPekerja.png")));
		barEmailPasswordPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		barEmailPasswordPekerja.setBounds(60, 315, 226, 51);
		contentPane.add(barEmailPasswordPekerja);
		
		JLabel barPhonePasswordPekerja = new JLabel("");
		barPhonePasswordPekerja.setIcon(new ImageIcon(RegisterPekerja.class.getResource("/img/Telpon_RegistPekerja.png")));
		barPhonePasswordPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		barPhonePasswordPekerja.setBounds(60, 255, 226, 51);
		contentPane.add(barPhonePasswordPekerja);
		
		JLabel barAlamatPasswordPekerja = new JLabel("");
		barAlamatPasswordPekerja.setIcon(new ImageIcon(RegisterPekerja.class.getResource("/img/Alamat_RegistPekerja.png")));
		barAlamatPasswordPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		barAlamatPasswordPekerja.setBounds(60, 195, 226, 51);
		contentPane.add(barAlamatPasswordPekerja);
		
		JLabel barNamaPasswordPekerja = new JLabel("");
		barNamaPasswordPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		barNamaPasswordPekerja.setIcon(new ImageIcon(RegisterPekerja.class.getResource("/img/Nama_RegistPekerja.png")));
		barNamaPasswordPekerja.setBounds(60, 135, 226, 51);
		contentPane.add(barNamaPasswordPekerja);
		
		JLabel lblLoginRegisterPekerja = new JLabel("");
		lblLoginRegisterPekerja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPekerja loginPekerjaFrame = new LoginPekerja();
				loginPekerjaFrame.setVisible(true);
                dispose(); 
			}
		});
		lblLoginRegisterPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginRegisterPekerja.setIcon(new ImageIcon(Register.class.getResource("/img/Confirm_Login.png")));
		lblLoginRegisterPekerja.setBounds(103, 550, 140, 13);
		contentPane.add(lblLoginRegisterPekerja);
		
		JLabel lblBGRegisterPekerja = new JLabel("");
		lblBGRegisterPekerja.setIcon(new ImageIcon(RegisterPekerja.class.getResource("/img/bgregister_pekerja.jpg")));
		lblBGRegisterPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGRegisterPekerja.setBounds(-7, 0, 360, 620);
		contentPane.add(lblBGRegisterPekerja);
	}
	
	public int addRegister(int data) {
	    int checkRegister = 0; // Inisialisasi nilai checkRegister dengan default 0

	    try {
	        String nama = textUsernameRegisterPekerja.getText();
	        String alamat = textAlamatRegisterPekerja.getText();
	        String phone = textPhoneRegisterPekerja.getText();
	        String email = textEmailRegisterPekerja.getText();
	        String username = textUsernameRegisterPekerja.getText();
	        char[] password = textPasswordRegisterPekerja.getPassword();

	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        String duplicateCheckQuery = "SELECT * FROM pekerja WHERE email_pekerja = ? OR username_pekerja = ? OR notelp_pekerja = ?";
	        PreparedStatement statementCekDuplikat = con.prepareStatement(duplicateCheckQuery);
	        statementCekDuplikat.setString(1, email);
	        statementCekDuplikat.setString(2, username);
	        statementCekDuplikat.setString(3, phone);

	        ResultSet duplicateCheckResult = statementCekDuplikat.executeQuery();

	        if (duplicateCheckResult.next()) {
	            // Jika ada duplikat, set nilai checkRegister ke 0
	            checkRegister = 0;
	        } else {
	            String idPekerja = idGenerate(); // Memanggil fungsi untuk menghasilkan ID pengguna unik
	            String admin = admin(); // Memanggil fungsi admin
	            String insertQuery = "INSERT INTO pekerja (id_pekerja, namalengkap_pekerja, alamat_pekerja, notelp_pekerja, email_pekerja, username_pekerja, password_pekerja, id_admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement statementRegisterPekerja = con.prepareStatement(insertQuery);
	            statementRegisterPekerja.setString(1, idPekerja);
	            statementRegisterPekerja.setString(2, nama);
	            statementRegisterPekerja.setString(3, alamat);
	            statementRegisterPekerja.setString(4, phone);
	            statementRegisterPekerja.setString(5, email);
	            statementRegisterPekerja.setString(6, username);
	            statementRegisterPekerja.setString(7, new String(password));
	            statementRegisterPekerja.setString(8, admin);

	            int rowsAffected = statementRegisterPekerja.executeUpdate(); // Eksekusi pernyataan SQL untuk menyimpan data ke dalam tabel

	            if (rowsAffected > 0) {
	                // Jika penyimpanan berhasil, set checkRegister ke 1
	                checkRegister = 1;
	            }

	            statementRegisterPekerja.close();
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
		        uniqueID = "PKJ" + randomID; // Tambahkan "PKJ" di depan randomID
		    } while (idCheck(uniqueID)); // Memeriksa apakah ID sudah ada dalam tabel

		    return uniqueID;
		}

		// Fungsi untuk memeriksa keberadaan ID dalam tabel pengguna
		public boolean idCheck(String idPekerja) {
		    boolean exists = false;

		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

		        String checkQuery = "SELECT * FROM pekerja WHERE id_pekerja = ?";
		        PreparedStatement checkStatement = con.prepareStatement(checkQuery);
		        checkStatement.setString(1, idPekerja);

		        ResultSet checkResult = checkStatement.executeQuery();

		        exists = checkResult.next(); // Mengatur exists ke true jika ID sudah ada dalam tabel

		    } catch (ClassNotFoundException | SQLException e) {
		        System.err.println(e);
		    }

		    return exists;
		}
		
		public String admin() {
		    String[] adminOptions = {"ADM001", "ADM002"};
		    String randomAdmin;
		    
		    // Menghasilkan nilai acak dari adminOptions
		    int randomIndex = (int) (Math.random() * adminOptions.length);
		    randomAdmin = adminOptions[randomIndex];
		    
		    return randomAdmin;
		}

}
