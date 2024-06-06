package start;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Transaksi extends JFrame {

	private static final long serialVersionUID = 1L;
	public static String selectedName;
	public static String selectedPekerjaan;
	public static String selectedBiaya;
	public static String selectedDeskripsi;
	public static String selectEmail;
	private JTextField textMetodeTransaksi;
	private JTextField textBayarTransaksi;
	private JTextField textTotalTransaksi;
	private JTextField textPonselTransaksi;
	private JTextField textNamaTransaksi;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaksi frame = new Transaksi();
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
	public Transaksi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNamaTransaksi = new JTextField();
		textNamaTransaksi.setOpaque(false);
		textNamaTransaksi.setForeground(Color.BLUE);
		textNamaTransaksi.setFont(new Font("Roboto", Font.BOLD, 13));
		textNamaTransaksi.setBorder(null);
		textNamaTransaksi.setEditable(false);
		textNamaTransaksi.setColumns(10);
		textNamaTransaksi.setBounds(23, 142, 96, 20);
		contentPane.add(textNamaTransaksi);
		
		textTotalTransaksi = new JTextField();
		textTotalTransaksi.setHorizontalAlignment(SwingConstants.CENTER);
		textTotalTransaksi.setOpaque(false);
		textTotalTransaksi.setForeground(Color.BLUE);
		textTotalTransaksi.setFont(new Font("Roboto", Font.BOLD, 12));
		textTotalTransaksi.setBorder(null);
		textTotalTransaksi.setEditable(false);
		textTotalTransaksi.setColumns(10);
		textTotalTransaksi.setBounds(240, 264, 96, 20);
		contentPane.add(textTotalTransaksi);
		
		textBayarTransaksi = new JTextField();
		textBayarTransaksi.setHorizontalAlignment(SwingConstants.CENTER);
		textBayarTransaksi.setOpaque(false);
		textBayarTransaksi.setForeground(Color.BLACK);
		textBayarTransaksi.setFont(new Font("Roboto", Font.BOLD, 12));
		textBayarTransaksi.setBorder(null);
		textBayarTransaksi.setEditable(false);
		textBayarTransaksi.setColumns(10);
		textBayarTransaksi.setBounds(42, 552, 96, 20);
		contentPane.add(textBayarTransaksi);
		
		textPonselTransaksi = new JTextField();
		textPonselTransaksi.setOpaque(false);
		textPonselTransaksi.setForeground(Color.BLUE);
		textPonselTransaksi.setFont(new Font("Roboto", Font.BOLD, 13));
		textPonselTransaksi.setBorder(null);
		textPonselTransaksi.setEditable(false);
		textPonselTransaksi.setColumns(10);
		textPonselTransaksi.setBounds(23, 210, 96, 20);
		contentPane.add(textPonselTransaksi);
		
		textMetodeTransaksi = new JTextField();
		textMetodeTransaksi.setHorizontalAlignment(SwingConstants.CENTER);
		textMetodeTransaksi.setOpaque(false);
		textMetodeTransaksi.setForeground(Color.BLUE);
		textMetodeTransaksi.setFont(new Font("Roboto", Font.BOLD, 12));
		textMetodeTransaksi.setBorder(null);
		textMetodeTransaksi.setEditable(false);
		textMetodeTransaksi.setBounds(240, 317, 96, 20);
		contentPane.add(textMetodeTransaksi);
		textMetodeTransaksi.setColumns(10);
		
		JLabel btnBayarTransaksi = new JLabel("");
		btnBayarTransaksi.setIcon(new ImageIcon(Transaksi.class.getResource("/img/btnBayarTransaksi.jpg")));
		btnBayarTransaksi.setHorizontalAlignment(SwingConstants.CENTER);
		btnBayarTransaksi.setBounds(179, 522, 180, 61);
		contentPane.add(btnBayarTransaksi);
		
		btnBayarTransaksi.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "")) {
		            // Operasi SQL untuk tabel proyek
		            String kodeProyek = KodeGenerator.generateKode("KP"); // Fungsi untuk membuat kode acak
		            
		            // Operasi SQL untuk tabel transaksi
		            String kodeTransaksi = KodeGenerator.generateKode("KT"); // Fungsi untuk membuat kode acak
		            String waktuSaatIni = Waktu.getCurrentTime(); // Fungsi untuk mendapatkan waktu saat ini

		            String insertTransaksiQuery = "INSERT INTO transaksi (kode_transaksi, metode_transaksi, waktu_transaksi, id_pengguna, kode_proyek) " +
		            	    "VALUES (?, ?, ?, (SELECT id_pengguna FROM pengguna WHERE email_pengguna = ?), ?)";

		            	try (PreparedStatement statementTransaksi = con.prepareStatement(insertTransaksiQuery)) {
		            		statementTransaksi.setString(1, kodeTransaksi);
		            		statementTransaksi.setString(2, "QRIS");
		            		statementTransaksi.setString(3, waktuSaatIni);
		            	    statementTransaksi.setString(4, selectEmail);
		            	    statementTransaksi.setString(5, kodeProyek);

		            	    int rowsAffected = statementTransaksi.executeUpdate();
		            	    if (rowsAffected > 0) {
		            	        System.out.println("Data berhasil dimasukkan ke tabel transaksi.");
		            	    } else {
		            	        System.out.println("Gagal memasukkan data ke tabel transaksi.");
		            	    }
		            	}

		            Home homeFrame = new Home();
		            homeFrame.setVisible(true);
		            dispose();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		
		JLabel lblTotalTransaksi = new JLabel("");
		lblTotalTransaksi.setIcon(new ImageIcon(Transaksi.class.getResource("/img/TotalTransaksi.jpg")));
		lblTotalTransaksi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalTransaksi.setBounds(0, 522, 180, 61);
		contentPane.add(lblTotalTransaksi);
		
		JLabel lblArrowPembayaran = new JLabel("");
		lblArrowPembayaran.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Search searchFrame = new Search();
				searchFrame.setVisible(true);
                dispose(); 
			}
		});
		
		lblArrowPembayaran.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrowPembayaran.setIcon(new ImageIcon(Transaksi.class.getResource("/img/arrow-back-circle-sharp.png")));
		lblArrowPembayaran.setBounds(10, 41, 59, 49);
		contentPane.add(lblArrowPembayaran);
		
		JLabel lblBGTransaksi = new JLabel("");
		lblBGTransaksi.setIcon(new ImageIcon(Transaksi.class.getResource("/img/bgTransaksi2.jpg")));
		lblBGTransaksi.setBounds(0, 0, 454, 620);
		lblBGTransaksi.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBGTransaksi);
		
		datatransaksi();
	}
	
	public void datatransaksi() {
		try {
	        con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        // Mengambil username_pengguna dan notelp_pengguna berdasarkan selectEmail
	        String queryPengguna = "SELECT username_pengguna, notelp_pengguna FROM pengguna WHERE email_pengguna = ?";
	        PreparedStatement statementPengguna = con.prepareStatement(queryPengguna);
	        statementPengguna.setString(1, selectEmail);

	        ResultSet resultSetPengguna = statementPengguna.executeQuery();
	        if (resultSetPengguna.next()) {
	            textNamaTransaksi.setText(resultSetPengguna.getString("username_pengguna"));
	            textPonselTransaksi.setText(resultSetPengguna.getString("notelp_pengguna"));
	        }

	        // Mengatur textTotalTransaksi dan textBayarTransaksi sesuai dengan selectedBiaya
	        textTotalTransaksi.setText(selectedBiaya);
	        textBayarTransaksi.setText(selectedBiaya);

	        // Mengatur textMetodeTransaksi menjadi "QRIS"
	        textMetodeTransaksi.setText("QRIS");

	        // Tutup koneksi dan statement
	        resultSetPengguna.close();
	        statementPengguna.close();
	        con.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		
	}
	
	public class KodeGenerator {
	    // Fungsi untuk membuat kode acak dengan format KPxxx atau KTxxx
	    public static String generateKode(String prefix) {
	        Random random = new Random();
	        int randomNum = random.nextInt(900) + 100; // Angka tiga digit acak (100-999)
	        return prefix + randomNum; // Menggabungkan prefix dengan angka acak
	    }
	}
	
	public class Waktu {
	    // Fungsi untuk mendapatkan waktu saat ini dalam format(hh:mm)
	    public static String getCurrentTime() {
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // Format jam:menit
	        return now.format(formatter); // Mengembalikan waktu saat ini dalam format yang diinginkan
	    }
	}
}
