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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HomePekerja extends JFrame {

	private static final long serialVersionUID = 1L;
	public static String selectEmail;
	private JTextField textNamaPekerjaan;
	private JTextField textDeskripsiPekerjaan;
	private JTextField textBiayaPekerjaan;
	private JTextField textNamaPekerjaan2;
	private JTextField textDeskripsiPekerjaan2;
	private JTextField textBiayaPekerjaan2;
	private JTextField textNamaPekerjaan3;
	private JTextField textDeskripsiPekerjaan3;
	private JTextField textBiayaPekerjaan3;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePekerja frame = new HomePekerja();
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
	public HomePekerja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textBiayaPekerjaan3 = new JTextField();
		textBiayaPekerjaan3.setOpaque(false);
		textBiayaPekerjaan3.setForeground(Color.BLACK);
		textBiayaPekerjaan3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textBiayaPekerjaan3.setEditable(false);
		textBiayaPekerjaan3.setColumns(10);
		textBiayaPekerjaan3.setBorder(null);
		textBiayaPekerjaan3.setBackground(Color.WHITE);
		textBiayaPekerjaan3.setBounds(50, 400, 180, 18);
		contentPane.add(textBiayaPekerjaan3);
		
		textDeskripsiPekerjaan3 = new JTextField();
		textDeskripsiPekerjaan3.setOpaque(false);
		textDeskripsiPekerjaan3.setForeground(Color.BLACK);
		textDeskripsiPekerjaan3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textDeskripsiPekerjaan3.setEditable(false);
		textDeskripsiPekerjaan3.setColumns(10);
		textDeskripsiPekerjaan3.setBorder(null);
		textDeskripsiPekerjaan3.setBackground(Color.WHITE);
		textDeskripsiPekerjaan3.setBounds(50, 370, 250, 18);
		contentPane.add(textDeskripsiPekerjaan3);
		
		textNamaPekerjaan3 = new JTextField();
		textNamaPekerjaan3.setOpaque(false);
		textNamaPekerjaan3.setForeground(Color.WHITE);
		textNamaPekerjaan3.setFont(new Font("Dialog", Font.BOLD, 14));
		textNamaPekerjaan3.setEditable(false);
		textNamaPekerjaan3.setColumns(10);
		textNamaPekerjaan3.setBorder(null);
		textNamaPekerjaan3.setBackground(Color.WHITE);
		textNamaPekerjaan3.setBounds(50, 350, 180, 18);
		contentPane.add(textNamaPekerjaan3);
		
		textBiayaPekerjaan2 = new JTextField();
		textBiayaPekerjaan2.setOpaque(false);
		textBiayaPekerjaan2.setForeground(Color.BLACK);
		textBiayaPekerjaan2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textBiayaPekerjaan2.setEditable(false);
		textBiayaPekerjaan2.setColumns(10);
		textBiayaPekerjaan2.setBorder(null);
		textBiayaPekerjaan2.setBackground(Color.WHITE);
		textBiayaPekerjaan2.setBounds(50, 290, 180, 18);
		contentPane.add(textBiayaPekerjaan2);
		
		textDeskripsiPekerjaan2 = new JTextField();
		textDeskripsiPekerjaan2.setOpaque(false);
		textDeskripsiPekerjaan2.setForeground(Color.BLACK);
		textDeskripsiPekerjaan2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textDeskripsiPekerjaan2.setEditable(false);
		textDeskripsiPekerjaan2.setColumns(10);
		textDeskripsiPekerjaan2.setBorder(null);
		textDeskripsiPekerjaan2.setBackground(Color.WHITE);
		textDeskripsiPekerjaan2.setBounds(50, 260, 250, 18);
		contentPane.add(textDeskripsiPekerjaan2);
		
		textNamaPekerjaan2 = new JTextField();
		textNamaPekerjaan2.setOpaque(false);
		textNamaPekerjaan2.setForeground(Color.WHITE);
		textNamaPekerjaan2.setFont(new Font("Dialog", Font.BOLD, 14));
		textNamaPekerjaan2.setEditable(false);
		textNamaPekerjaan2.setColumns(10);
		textNamaPekerjaan2.setBorder(null);
		textNamaPekerjaan2.setBackground(Color.WHITE);
		textNamaPekerjaan2.setBounds(50, 240, 180, 18);
		contentPane.add(textNamaPekerjaan2);
		
		textBiayaPekerjaan = new JTextField();
		textBiayaPekerjaan.setOpaque(false);
		textBiayaPekerjaan.setForeground(Color.BLACK);
		textBiayaPekerjaan.setFont(new Font("Dialog", Font.PLAIN, 12));
		textBiayaPekerjaan.setEditable(false);
		textBiayaPekerjaan.setColumns(10);
		textBiayaPekerjaan.setBorder(null);
		textBiayaPekerjaan.setBackground(Color.WHITE);
		textBiayaPekerjaan.setBounds(50, 180, 180, 18);
		contentPane.add(textBiayaPekerjaan);
		
		textDeskripsiPekerjaan = new JTextField();
		textDeskripsiPekerjaan.setOpaque(false);
		textDeskripsiPekerjaan.setForeground(Color.BLACK);
		textDeskripsiPekerjaan.setFont(new Font("Dialog", Font.PLAIN, 12));
		textDeskripsiPekerjaan.setEditable(false);
		textDeskripsiPekerjaan.setColumns(10);
		textDeskripsiPekerjaan.setBorder(null);
		textDeskripsiPekerjaan.setBackground(Color.WHITE);
		textDeskripsiPekerjaan.setBounds(50, 150, 250, 18);
		contentPane.add(textDeskripsiPekerjaan);
		
		textNamaPekerjaan = new JTextField();
		textNamaPekerjaan.setOpaque(false);
		textNamaPekerjaan.setForeground(Color.WHITE);
		textNamaPekerjaan.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaPekerjaan.setColumns(10);
		textNamaPekerjaan.setBorder(null);
		textNamaPekerjaan.setEditable(false);
		textNamaPekerjaan.setBackground(Color.WHITE);
		textNamaPekerjaan.setBounds(50, 130, 180, 18);
		contentPane.add(textNamaPekerjaan);
		
		JLabel btnTambahPekerjaan = new JLabel ("");
		btnTambahPekerjaan.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/btnTambahPekerjaan.png")));
		btnTambahPekerjaan.setBackground(null);
		btnTambahPekerjaan.setBounds(47, 440, 251, 60);
		contentPane.add(btnTambahPekerjaan);
		btnTambahPekerjaan.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnTambahPekerjaan.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnTambahPekerjaan.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				TambahPekerjaan tambahPekerjaanFrame = new TambahPekerjaan();
				tambahPekerjaanFrame.setVisible(true);
	            dispose();     
			}
		}
		);
		
		JLabel lblBarPekerjaan3 = new JLabel("");
		lblBarPekerjaan3.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/barHomePekerja2.png")));
		lblBarPekerjaan3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarPekerjaan3.setBounds(-15, 341, 376, 91);
		contentPane.add(lblBarPekerjaan3);
		
		JLabel lblBarPekerjaan2 = new JLabel("");
		lblBarPekerjaan2.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/barHomePekerja2.png")));
		lblBarPekerjaan2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarPekerjaan2.setBounds(-15, 231, 376, 91);
		contentPane.add(lblBarPekerjaan2);
		
		JLabel lblBarPekerjaan = new JLabel("");
		lblBarPekerjaan.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarPekerjaan.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/barHomePekerja2.png")));
		lblBarPekerjaan.setBounds(-15, 121, 376, 91);
		contentPane.add(lblBarPekerjaan);
		
		JLabel lblPekerjaan = new JLabel("");
		lblPekerjaan.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/iconPekerjaan.png")));
		lblPekerjaan.setBounds(54, 80, 238, 30);
		contentPane.add(lblPekerjaan);
		
		JLabel lblAkunHomePekerja = new JLabel("");
		lblAkunHomePekerja.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/person-sharp.png")));
		lblAkunHomePekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblAkunHomePekerja.setBounds(200, 513, 65, 68);
		contentPane.add(lblAkunHomePekerja);
		lblAkunHomePekerja.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblAkunHomePekerja.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblAkunHomePekerja.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				AkunPekerja akunPekerjaFrame = new AkunPekerja();
				akunPekerjaFrame.setVisible(true);
	            dispose();     
			}
		}
		);
		
		JLabel lblHomeHomePekerja = new JLabel("");
		lblHomeHomePekerja.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/iconHome.jpg")));
		lblHomeHomePekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeHomePekerja.setBounds(55, 512, 65, 68);
		contentPane.add(lblHomeHomePekerja);
		
		JLabel lblNavbarHomePekerja = new JLabel("");
		lblNavbarHomePekerja.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/navbarPekerja.png")));
		lblNavbarHomePekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblNavbarHomePekerja.setBounds(0, 510, 380, 70);
		contentPane.add(lblNavbarHomePekerja);
		
		JLabel lblBGHomePekerja = new JLabel("");
		lblBGHomePekerja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGHomePekerja.setIcon(new ImageIcon(HomePekerja.class.getResource("/img/bg homepagepekerja.jpg")));
		lblBGHomePekerja.setBounds(-7, 0, 360, 620);
		contentPane.add(lblBGHomePekerja);		
		
		viewDaftarPekerjaan();
	}
	
	public void viewDaftarPekerjaan() {
	    try {
	        // Buat koneksi ke database
	        con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        // Query SQL untuk mengambil data pekerjaan berdasarkan id_pekerja dari email_pekerja yang sedang login
	        String query = "SELECT pekerjaan.nama_pekerjaan, pekerjaan.deskripsi_pekerjaan, pekerjaan.biaya_pekerjaan " +
	                       "FROM pekerjaan " +
	                       "INNER JOIN pekerja ON pekerjaan.id_pekerja = pekerja.id_pekerja " +
	                       "WHERE pekerja.email_pekerja = ?";

	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, selectEmail); // Menggunakan nilai selectEmail

	        // Eksekusi query
	        ResultSet rs = pstmt.executeQuery();

	        // Mengambil data pertama
	        if (rs.next()) {
	            textNamaPekerjaan.setText(rs.getString("nama_pekerjaan"));
	            textDeskripsiPekerjaan.setText(rs.getString("deskripsi_pekerjaan"));
	            textBiayaPekerjaan.setText(rs.getString("biaya_pekerjaan"));
	        }

	        // Mengambil data kedua
	        if (rs.next()) {
	            textNamaPekerjaan2.setText(rs.getString("nama_pekerjaan"));
	            textDeskripsiPekerjaan2.setText(rs.getString("deskripsi_pekerjaan"));
	            textBiayaPekerjaan2.setText(rs.getString("biaya_pekerjaan"));
	        }

	        // Mengambil data ketiga
	        if (rs.next()) {
	            textNamaPekerjaan3.setText(rs.getString("nama_pekerjaan"));
	            textDeskripsiPekerjaan3.setText(rs.getString("deskripsi_pekerjaan"));
	            textBiayaPekerjaan3.setText(rs.getString("biaya_pekerjaan"));
	        }

	        // Tutup koneksi dan result set
	        rs.close();
	        pstmt.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
