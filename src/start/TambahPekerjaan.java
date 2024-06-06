package start;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TambahPekerjaan extends JFrame {

	private static final long serialVersionUID = 1L;
	public static String selectEmail;
	Connection con;
	private JTextField textTambahNamaPekerjaan;
	private JTextField textTambahDeskripsiPekerjaan;
	private JTextField textTambahKategoriPekerjaan;
	private JTextField textTambahBiayaPekerjaan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TambahPekerjaan frame = new TambahPekerjaan();
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
	public TambahPekerjaan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textTambahBiayaPekerjaan = new JTextField();
		textTambahBiayaPekerjaan.setOpaque(false);
		textTambahBiayaPekerjaan.setForeground(Color.BLACK);
		textTambahBiayaPekerjaan.setFont(new Font("Arial", Font.BOLD, 13));
		textTambahBiayaPekerjaan.setColumns(10);
		textTambahBiayaPekerjaan.setBorder(null);
		textTambahBiayaPekerjaan.setBackground(Color.WHITE);
		textTambahBiayaPekerjaan.setBounds(68, 387, 210, 30);
		contentPane.add(textTambahBiayaPekerjaan);
		
		textTambahKategoriPekerjaan = new JTextField();
		textTambahKategoriPekerjaan.setOpaque(false);
		textTambahKategoriPekerjaan.setForeground(Color.BLACK);
		textTambahKategoriPekerjaan.setFont(new Font("Arial", Font.BOLD, 13));
		textTambahKategoriPekerjaan.setColumns(10);
		textTambahKategoriPekerjaan.setBorder(null);
		textTambahKategoriPekerjaan.setBackground(Color.WHITE);
		textTambahKategoriPekerjaan.setBounds(68, 317, 210, 30);
		contentPane.add(textTambahKategoriPekerjaan);
		
		textTambahDeskripsiPekerjaan = new JTextField();
		textTambahDeskripsiPekerjaan.setOpaque(false);
		textTambahDeskripsiPekerjaan.setForeground(Color.BLACK);
		textTambahDeskripsiPekerjaan.setFont(new Font("Arial", Font.BOLD, 13));
		textTambahDeskripsiPekerjaan.setColumns(10);
		textTambahDeskripsiPekerjaan.setBorder(null);
		textTambahDeskripsiPekerjaan.setBackground(Color.WHITE);
		textTambahDeskripsiPekerjaan.setBounds(68, 246, 210, 30);
		contentPane.add(textTambahDeskripsiPekerjaan);
		
		textTambahNamaPekerjaan = new JTextField();
		textTambahNamaPekerjaan.setBounds(68, 176, 210, 30);
		contentPane.add(textTambahNamaPekerjaan);
		textTambahNamaPekerjaan.setFont(new Font("Arial", Font.BOLD, 13));
		textTambahNamaPekerjaan.setBackground(new Color(255, 255, 255));
		textTambahNamaPekerjaan.setForeground(Color.BLACK);
		textTambahNamaPekerjaan.setOpaque(false);
		textTambahNamaPekerjaan.setBorder(null);
		textTambahNamaPekerjaan.setColumns(10);
		
		JLabel lblArrowTambahPekerjaan = new JLabel("");
		lblArrowTambahPekerjaan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePekerja homePekerjaFrame = new HomePekerja();
				homePekerjaFrame.setVisible(true);
                dispose(); 
			}
		});
		
		lblArrowTambahPekerjaan.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrowTambahPekerjaan.setIcon(new ImageIcon(Transaksi.class.getResource("/img/arrow-back-circle-sharp.png")));
		lblArrowTambahPekerjaan.setBounds(15, 65, 40, 40);
		contentPane.add(lblArrowTambahPekerjaan);
		
	    JLabel btnTambahPekerjaan = new JLabel("");
	    btnTambahPekerjaan.setIcon(new ImageIcon(TambahPekerjaan.class.getResource("/img/btnTambahPekerjaan2.png")));
	    btnTambahPekerjaan.setBounds(59, 470, 227, 40);
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
	            int rowsAffected = addPekerjaan(); // Panggil addPekerjaan saat tombol diklik

	            // Jika penambahan berhasil
	            if (rowsAffected > 0) {
	                HomePekerja homePekerjaFrame = new HomePekerja();
	                homePekerjaFrame.setVisible(true);
	                dispose(); // Tutup frame saat ini
	            } else {
	                // Penambahan gagal
	            }
	        }
	    });
		
		JLabel barTambahKategoriPekerjaan_1 = new JLabel("");
		barTambahKategoriPekerjaan_1.setIcon(new ImageIcon(TambahPekerjaan.class.getResource("/img/tambahBiayaPekerjaan.png")));
		barTambahKategoriPekerjaan_1.setBounds(59, 370, 227, 52);
		contentPane.add(barTambahKategoriPekerjaan_1);
		
		JLabel barTambahKategoriPekerjaan = new JLabel("");
		barTambahKategoriPekerjaan.setIcon(new ImageIcon(TambahPekerjaan.class.getResource("/img/tambahKategoriPekerjaan.png")));
		barTambahKategoriPekerjaan.setBounds(59, 300, 227, 52);
		contentPane.add(barTambahKategoriPekerjaan);
		
		JLabel barTambahDeskripsiPekerjaan = new JLabel("");
		barTambahDeskripsiPekerjaan.setIcon(new ImageIcon(TambahPekerjaan.class.getResource("/img/tambahDeskripsiPekerjaan.png")));
		barTambahDeskripsiPekerjaan.setBounds(59, 230, 227, 52);
		contentPane.add(barTambahDeskripsiPekerjaan);
		
		JLabel barTambahNamaPekerjaan = new JLabel("");
		barTambahNamaPekerjaan.setIcon(new ImageIcon(TambahPekerjaan.class.getResource("/img/tambahNamaPekerjaan.png")));
		barTambahNamaPekerjaan.setBounds(59, 160, 227, 52);
		contentPane.add(barTambahNamaPekerjaan);
		
		JLabel lblBGTambahPekerjaan = new JLabel("");
		lblBGTambahPekerjaan.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGTambahPekerjaan.setIcon(new ImageIcon(TambahPekerjaan.class.getResource("/img/bg tambahpekerjaan.jpg")));
		lblBGTambahPekerjaan.setBounds(-7, 0, 360, 620);
		contentPane.add(lblBGTambahPekerjaan);	
	}
	
	public int addPekerjaan() {
	    int rowsAffected = 0;

	    try {
	        // Koneksi ke database
	    	con  = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        // Query untuk menyisipkan data ke tabel pekerjaan
	        String query = "INSERT INTO pekerjaan (id_pekerja, id_pekerjaan, nama_pekerjaan, deskripsi_pekerjaan, kategori_pekerjaan, biaya_pekerjaan) VALUES ((SELECT id_pekerja FROM pekerja WHERE email_pekerja = ?), ?, ?, ?, ?, ?)";

	        // Membuat PreparedStatement
	        PreparedStatement statementTambahPekerjaan = con.prepareStatement(query);
	        statementTambahPekerjaan.setString(1, selectEmail); // selectEmail dari variabel static
	        statementTambahPekerjaan.setString(2, generateIDPekerjaan());
	        statementTambahPekerjaan.setString(3, textTambahNamaPekerjaan.getText());
	        statementTambahPekerjaan.setString(4, textTambahDeskripsiPekerjaan.getText());
	        statementTambahPekerjaan.setString(5, textTambahKategoriPekerjaan.getText());
	        statementTambahPekerjaan.setString(6, textTambahBiayaPekerjaan.getText());

	        // Eksekusi query
	        rowsAffected = statementTambahPekerjaan.executeUpdate();

	        // Menutup PreparedStatement
	        statementTambahPekerjaan.close();

	        // Menutup koneksi ke database
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rowsAffected;
	}
	
	// Fungsi untuk generate ID pekerjaan secara acak dari PJ000 hingga PJ999
	public String generateIDPekerjaan() {
	    String prefix = "PJ";
	    Random rand = new Random();
	    int randomNumber = rand.nextInt(1000); // Menghasilkan angka antara 0 hingga 999

	    // Format angka ke tiga digit (dengan leading zeros jika diperlukan)
	    String formattedNumber = String.format("%03d", randomNumber);

	    return prefix + formattedNumber;
	}

}
