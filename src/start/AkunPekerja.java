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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AkunPekerja extends JFrame {

	private static final long serialVersionUID = 1L;
	public static String selectEmail;
	public static char[] selectPassword;
	private JTextField textUsernameAkunPekerja;
	private JTextField textEmailAkunPekerja;
	private JTextField textPonselAkunPekerja;
	private JPasswordField textPassAkunPekerja;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AkunPekerja frame = new AkunPekerja();
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
	public AkunPekerja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        textPassAkunPekerja = new JPasswordField();
        textPassAkunPekerja.setBounds(76, 288, 200, 25);
        textPassAkunPekerja.setOpaque(false);
        textPassAkunPekerja.setForeground(Color.BLACK);
        textPassAkunPekerja.setFont(new Font("Arial", Font.BOLD, 15));
        textPassAkunPekerja.setBorder(null);
        textPassAkunPekerja.setBackground(Color.WHITE);
        textPassAkunPekerja.setEditable(false);
        textPassAkunPekerja.setText(String.valueOf(selectPassword));
		contentPane.add(textPassAkunPekerja);
		textPassAkunPekerja.setColumns(10);
		
		textPonselAkunPekerja = new JTextField();
		textPonselAkunPekerja.setOpaque(false);
		textPonselAkunPekerja.setForeground(Color.BLACK);
		textPonselAkunPekerja.setFont(new Font("Arial", Font.BOLD, 15));
		textPonselAkunPekerja.setEditable(false);
		textPonselAkunPekerja.setColumns(10);
		textPonselAkunPekerja.setBorder(null);
		textPonselAkunPekerja.setBackground(Color.WHITE);
		textPonselAkunPekerja.setBounds(73, 233, 200, 25);
		contentPane.add(textPonselAkunPekerja);
		
		textEmailAkunPekerja = new JTextField();
		textEmailAkunPekerja.setOpaque(false);
		textEmailAkunPekerja.setForeground(Color.BLACK);
		textEmailAkunPekerja.setFont(new Font("Arial", Font.BOLD, 15));
		textEmailAkunPekerja.setEditable(false);
		textEmailAkunPekerja.setColumns(10);
		textEmailAkunPekerja.setBorder(null);
		textEmailAkunPekerja.setBackground(Color.WHITE);
		textEmailAkunPekerja.setBounds(73, 178, 200, 25);
		contentPane.add(textEmailAkunPekerja);
		
		textUsernameAkunPekerja = new JTextField();
		textUsernameAkunPekerja.setBounds(73, 123, 200, 25);
		textUsernameAkunPekerja.setFont(new Font("Arial", Font.BOLD, 15));
		textUsernameAkunPekerja.setBackground(new Color(255, 255, 255));
		textUsernameAkunPekerja.setForeground(Color.BLACK);
		textUsernameAkunPekerja.setOpaque(false);
		textUsernameAkunPekerja.setBorder(null);
		textUsernameAkunPekerja.setEditable(false);
		contentPane.add(textUsernameAkunPekerja);
		textUsernameAkunPekerja.setColumns(10);
		
		isiDataPekerja();
		
		JLabel btnLogoutPekerja = new JLabel("");
		btnLogoutPekerja.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/btnLogoutPekerja.png")));
		btnLogoutPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogoutPekerja.setBounds(96, 411, 154, 40);
		contentPane.add(btnLogoutPekerja);
		
		btnLogoutPekerja.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnLogoutPekerja.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnLogoutPekerja.setBorder(null);
		    }
			
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPekerja loginPekerjaFrame = new LoginPekerja();
				loginPekerjaFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel btnDaftarPengguna = new JLabel("");
		btnDaftarPengguna.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/btnDaftarPengguna.png")));
		btnDaftarPengguna.setHorizontalAlignment(SwingConstants.CENTER);
		btnDaftarPengguna.setBounds(60, 342, 226, 39);
		contentPane.add(btnDaftarPengguna);
		
		btnDaftarPengguna.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnDaftarPengguna.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnDaftarPengguna.setBorder(null);
		    }
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Register registerFrame = new Register();
				registerFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblBarPasswordAkunPekerja = new JLabel("");
		lblBarPasswordAkunPekerja.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/barAkunPekerja.png")));
		lblBarPasswordAkunPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarPasswordAkunPekerja.setBounds(60, 280, 227, 40);
		contentPane.add(lblBarPasswordAkunPekerja);
		
		JLabel lblBarPonselAkunPekerja = new JLabel("");
		lblBarPonselAkunPekerja.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/barAkunPekerja.png")));
		lblBarPonselAkunPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarPonselAkunPekerja.setBounds(60, 225, 227, 40);
		contentPane.add(lblBarPonselAkunPekerja);
		
		JLabel lblBarEmailAkunPekerja = new JLabel("");
		lblBarEmailAkunPekerja.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/barAkunPekerja.png")));
		lblBarEmailAkunPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarEmailAkunPekerja.setBounds(60, 170, 227, 40);
		contentPane.add(lblBarEmailAkunPekerja);
		
		JLabel lblBarNamaAkunPekerja = new JLabel("");
		lblBarNamaAkunPekerja.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/barAkunPekerja.png")));
		lblBarNamaAkunPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarNamaAkunPekerja.setBounds(60, 115, 227, 40);
		contentPane.add(lblBarNamaAkunPekerja);
		
		JLabel lblAvatarAkunPekerja = new JLabel("");
		lblAvatarAkunPekerja.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/avatarPekerja.png")));
		lblAvatarAkunPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarAkunPekerja.setBounds(141, 35, 63, 61);
		contentPane.add(lblAvatarAkunPekerja);
		
		JLabel lblHomeAkunPekerja = new JLabel("");
		lblHomeAkunPekerja.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/home.jpg")));
		lblHomeAkunPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeAkunPekerja.setBounds(55, 512, 65, 68);
		contentPane.add(lblHomeAkunPekerja);
		lblHomeAkunPekerja.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblHomeAkunPekerja.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblHomeAkunPekerja.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePekerja homePekerjaFrame = new HomePekerja();
				homePekerjaFrame.setVisible(true);
	            dispose();     
			}
		}
		);
		
		JLabel lblAkunAkunPekerja = new JLabel("");
		lblAkunAkunPekerja.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/Group 37.jpg")));
		lblAkunAkunPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblAkunAkunPekerja.setBounds(200, 512, 65, 68);
		contentPane.add(lblAkunAkunPekerja);
		
		JLabel lblNavbarAkunPekerja = new JLabel("");
		lblNavbarAkunPekerja.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/navbarPekerja.png")));
		lblNavbarAkunPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblNavbarAkunPekerja.setBounds(0, 510, 380, 70);
		contentPane.add(lblNavbarAkunPekerja);
		
		JLabel lblBGAkunPekerja = new JLabel("");
		lblBGAkunPekerja.setIcon(new ImageIcon(AkunPekerja.class.getResource("/img/bg akunPekerja.jpg")));
		lblBGAkunPekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGAkunPekerja.setBounds(-2, 0, 350, 615);
		contentPane.add(lblBGAkunPekerja);
	}
	
	 private void isiDataPekerja() {
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            // Koneksi ke database
	            con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	            // Query untuk mengambil data pekerja berdasarkan email dan password
	            String query = "SELECT notelp_pekerja, username_pekerja, email_pekerja FROM pekerja WHERE email_pekerja = ? AND password_pekerja = ?";
	            ps = con.prepareStatement(query);
	            ps.setString(1, selectEmail);
	            ps.setString(2, String.valueOf(selectPassword)); // Convert char[] menjadi String

	            // Eksekusi query
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                // Mengisi textPhoneAkun dengan nomor telepon pekerja
	                textPonselAkunPekerja.setText(rs.getString("notelp_pekerja"));

	                // Mengisi textUsernameAkun dengan username pekerja
	                textUsernameAkunPekerja.setText(rs.getString("username_pekerja"));
	                
	                // Mengisi textEmailAkun dengan email pekerja
	                textEmailAkunPekerja.setText(rs.getString("email_pekerja"));
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
