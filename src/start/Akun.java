package start;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Akun extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textUsernameAkun;
	private JTextField textEmailAkun;
	private JTextField textPhoneAkun;
	private JPasswordField textPassAkun;
	public static String selectEmail;
	public static char[] selectPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Akun frame = new Akun();
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
	public Akun() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
        
        JLabel btnDaftarPekerja = new JLabel("");
        btnDaftarPekerja.setIcon(new ImageIcon(Akun.class.getResource("/img/btnDaftarPekerjaAkun.png")));
        btnDaftarPekerja.setHorizontalAlignment(SwingConstants.CENTER);
        btnDaftarPekerja.setBounds(79, 410, 187, 32);
        contentPane.add(btnDaftarPekerja);
        
        btnDaftarPekerja.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnDaftarPekerja.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnDaftarPekerja.setBorder(null);
		    }
			
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterPekerja registerPekerjaFrame = new RegisterPekerja();
				registerPekerjaFrame.setVisible(true);
                dispose(); 
		    }
		});
        
        JLabel lblAvatarAkun = new JLabel("");
        lblAvatarAkun.setHorizontalAlignment(SwingConstants.CENTER);
        lblAvatarAkun.setIcon(new ImageIcon(Akun.class.getResource("/img/avatarAkun.jpg")));
        lblAvatarAkun.setBounds(133, 106, 80, 77);
        contentPane.add(lblAvatarAkun);
		
        textPassAkun = new JPasswordField();
        textPassAkun.setBounds(63, 364, 194, 25);
        textPassAkun.setOpaque(false);
        textPassAkun.setForeground(Color.BLACK);
        textPassAkun.setFont(new Font("Arial", Font.BOLD, 15));
        textPassAkun.setBorder(null);
        textPassAkun.setBackground(Color.WHITE);
        textPassAkun.setEditable(false);
        textPassAkun.setText(String.valueOf(selectPassword));
		contentPane.add(textPassAkun);
		textPassAkun.setColumns(10);
		
		textPhoneAkun = new JTextField();
		textPhoneAkun.setBounds(63, 309, 194, 25);
		textPhoneAkun.setOpaque(false);
		textPhoneAkun.setForeground(Color.BLACK);
		textPhoneAkun.setFont(new Font("Arial", Font.BOLD, 15));
		textPhoneAkun.setBorder(null);
		textPhoneAkun.setBackground(Color.WHITE);
		textPhoneAkun.setEditable(false);
		contentPane.add(textPhoneAkun);
		textPhoneAkun.setColumns(10);
		
		textEmailAkun = new JTextField();
		textEmailAkun.setBounds(63, 254, 194, 25);
		textEmailAkun.setOpaque(false);
		textEmailAkun.setForeground(Color.BLACK);
		textEmailAkun.setFont(new Font("Arial", Font.BOLD, 15));
		textEmailAkun.setBorder(null);
		textEmailAkun.setBackground(Color.WHITE);
		textEmailAkun.setEditable(false);
		textEmailAkun.setText(selectEmail);
		contentPane.add(textEmailAkun);
		textEmailAkun.setColumns(10);
		
		textUsernameAkun = new JTextField();
		textUsernameAkun.setBounds(65, 198, 194, 25);
		textUsernameAkun.setFont(new Font("Arial", Font.BOLD, 15));
		textUsernameAkun.setBackground(new Color(255, 255, 255));
		textUsernameAkun.setForeground(Color.BLACK);
		textUsernameAkun.setOpaque(false);
		textUsernameAkun.setBorder(null);
		textUsernameAkun.setEditable(false);
		contentPane.add(textUsernameAkun);
		textUsernameAkun.setColumns(10);
		
		isiDataPengguna();
		
		JLabel btnLogoutAkun = new JLabel("");
		btnLogoutAkun.setIcon(new ImageIcon(Home.class.getResource("/img/logoutAkun.jpg")));
		btnLogoutAkun.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogoutAkun.setBounds(110, 455, 112, 40);
		contentPane.add(btnLogoutAkun);
		
		btnLogoutAkun.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnLogoutAkun.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnLogoutAkun.setBorder(null);
		    }
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblBarPassAkun = new JLabel("");
		lblBarPassAkun.setIcon(new ImageIcon(Home.class.getResource("/img/barAkun.jpg")));
		lblBarPassAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarPassAkun.setBounds(53, 356, 238, 40);
		contentPane.add(lblBarPassAkun);
		
		JLabel lblBarPhoneAkun = new JLabel("");
		lblBarPhoneAkun.setIcon(new ImageIcon(Home.class.getResource("/img/barAkun.jpg")));
		lblBarPhoneAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarPhoneAkun.setBounds(53, 301, 238, 40);
		contentPane.add(lblBarPhoneAkun);
		
		JLabel lblBarEmailAkun = new JLabel("");
		lblBarEmailAkun.setIcon(new ImageIcon(Home.class.getResource("/img/barAkun.jpg")));
		lblBarEmailAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarEmailAkun.setBounds(53, 246, 238, 40);
		contentPane.add(lblBarEmailAkun);
		
		JLabel lblBarNameAkun = new JLabel("");
		lblBarNameAkun.setIcon(new ImageIcon(Home.class.getResource("/img/barAkun.jpg")));
		lblBarNameAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarNameAkun.setBounds(53, 191, 238, 40);
		contentPane.add(lblBarNameAkun);
		
		JLabel lblIconRiwayatAkun = new JLabel("");
		lblIconRiwayatAkun.setIcon(new ImageIcon(Akun.class.getResource("/img/iconRiwayat.jpg")));
		lblIconRiwayatAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRiwayatAkun.setBounds(185, 512, 65, 68);
		contentPane.add(lblIconRiwayatAkun);
		
		lblIconRiwayatAkun.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconRiwayatAkun.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconRiwayatAkun.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Riwayat riwayatFrame = new Riwayat();
				riwayatFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconAkunAkun = new JLabel("");
		lblIconAkunAkun.setIcon(new ImageIcon(Home.class.getResource("/img/Group 37.jpg")));
		lblIconAkunAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAkunAkun.setBounds(270, 512, 65, 68);
		contentPane.add(lblIconAkunAkun);
		
		JLabel lblIconSearchAkun = new JLabel("");
		lblIconSearchAkun.setIcon(new ImageIcon(Akun.class.getResource("/img/iconSearch.jpg")));
		lblIconSearchAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSearchAkun.setBounds(100, 512, 65, 68);
		contentPane.add(lblIconSearchAkun);
		
		lblIconSearchAkun.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconSearchAkun.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconSearchAkun.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Search searchFrame = new Search();
				searchFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconHomeAkun = new JLabel("");
		lblIconHomeAkun.setIcon(new ImageIcon(Home.class.getResource("/img/home.jpg")));
		lblIconHomeAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHomeAkun.setBounds(15, 512, 65, 68);
		contentPane.add(lblIconHomeAkun);
		
		lblIconHomeAkun.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconHomeAkun.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconHomeAkun.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Home homeFrame = new Home();
				homeFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblNavBarAkun = new JLabel("");
		lblNavBarAkun.setIcon(new ImageIcon(Home.class.getResource("/img/navbar.jpg")));
		lblNavBarAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblNavBarAkun.setBounds(0, 510, 380, 70);
		contentPane.add(lblNavBarAkun);
		
		JLabel lblBGAkun = new JLabel("");
		lblBGAkun.setIcon(new ImageIcon(Home.class.getResource("/img/bgAkun.jpg")));
		lblBGAkun.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGAkun.setBounds(0, 0, 350, 615);
		contentPane.add(lblBGAkun);
		        }
	
	 private void isiDataPengguna() {
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            // Koneksi ke database
	            con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	            // Query untuk mengambil data pengguna berdasarkan email dan password
	            String query = "SELECT notelp_pengguna, username_pengguna FROM pengguna WHERE email_pengguna = ? AND password_pengguna = ?";
	            ps = con.prepareStatement(query);
	            ps.setString(1, selectEmail);
	            ps.setString(2, String.valueOf(selectPassword)); // Convert char[] menjadi String

	            // Eksekusi query
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                // Mengisi textPhoneAkun dengan nomor telepon pengguna
	                textPhoneAkun.setText(rs.getString("notelp_pengguna"));

	                // Mengisi textUsernameAkun dengan username pengguna
	                textUsernameAkun.setText(rs.getString("username_pengguna"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Tutup koneksi, statement, dan result set
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
