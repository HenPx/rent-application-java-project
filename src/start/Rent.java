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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Rent extends JFrame {

	private static final long serialVersionUID = 1L;
    public static String selectedNama;
    public static String selectedPekerjaan;
    public static String selectedBiaya;
    Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rent frame = new Rent();
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
	public Rent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArrowRent = new JLabel("");
		lblArrowRent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Search searchFrame = new Search();
				searchFrame.setVisible(true);
                dispose(); 
			}
		});
		
		JTextField textDeskripsiRent = new JTextField();
		textDeskripsiRent.setOpaque(false);
		textDeskripsiRent.setForeground(Color.BLACK);
		textDeskripsiRent.setFont(new Font("Roboto", Font.PLAIN, 13));
		textDeskripsiRent.setColumns(10);
		textDeskripsiRent.setBorder(null);
		textDeskripsiRent.setEditable(false);
		String deskripsiPekerjaan = getDeskripsiPekerjaan(selectedPekerjaan);
		textDeskripsiRent.setText(deskripsiPekerjaan);
		textDeskripsiRent.setBackground(Color.WHITE);
		textDeskripsiRent.setBounds(50, 255, 252, 18);
		contentPane.add(textDeskripsiRent);

		
		JTextField textBiayaRent = new JTextField();
		textBiayaRent.setOpaque(false);
		textBiayaRent.setForeground(Color.BLACK);
		textBiayaRent.setFont(new Font("Roboto", Font.BOLD, 15));
		textBiayaRent.setColumns(10);
		textBiayaRent.setBorder(null);
		textBiayaRent.setEditable(false);
        textBiayaRent.setText(selectedBiaya);
		textBiayaRent.setBackground(Color.WHITE);
		textBiayaRent.setBounds(50, 220, 252, 18);
		contentPane.add(textBiayaRent);
		
		JTextField textPekerjaanRent = new JTextField();
		textPekerjaanRent.setOpaque(false);
		textPekerjaanRent.setForeground(Color.BLACK);
		textPekerjaanRent.setFont(new Font("Roboto", Font.BOLD, 15));
		textPekerjaanRent.setColumns(10);
		textPekerjaanRent.setBorder(null);
		textPekerjaanRent.setEditable(false);
        textPekerjaanRent.setText(selectedPekerjaan);
		textPekerjaanRent.setBackground(Color.WHITE);
		textPekerjaanRent.setBounds(50, 200, 252, 18);
		contentPane.add(textPekerjaanRent);
		
		JTextField textNamaRent = new JTextField();
		textNamaRent.setOpaque(false);
		textNamaRent.setForeground(Color.BLUE);
		textNamaRent.setFont(new Font("Roboto", Font.BOLD, 18));
		textNamaRent.setColumns(10);
		textNamaRent.setBorder(null);
		textNamaRent.setEditable(false);
        textNamaRent.setText(selectedNama);
		textNamaRent.setBackground(Color.WHITE);
		textNamaRent.setBounds(50, 178, 252, 18);
		contentPane.add(textNamaRent);
		
		JLabel btnRent = new JLabel("");
		btnRent.setIcon(new ImageIcon(Rent.class.getResource("/img/btnRent.png")));
		btnRent.setHorizontalAlignment(SwingConstants.CENTER);
		btnRent.setBounds(-2, 520, 350, 65);
		contentPane.add(btnRent);
		
		btnRent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Transaksi.selectedName = textNamaRent.getText();
                Transaksi.selectedPekerjaan = textPekerjaanRent.getText();
                Transaksi.selectedBiaya = textBiayaRent.getText();
                Transaksi.selectedDeskripsi = textDeskripsiRent.getText();
                
                Transaksi transaksiFrame = new Transaksi();
                transaksiFrame.setVisible(true);
                dispose();
            }
        });
		
		lblArrowRent.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrowRent.setIcon(new ImageIcon(Transaksi.class.getResource("/img/arrow-back-circle-sharp.png")));
		lblArrowRent.setBounds(5, 8, 59, 49);
		contentPane.add(lblArrowRent);
		
		JLabel lblBGRent = new JLabel("");
		lblBGRent.setIcon(new ImageIcon(Rent.class.getResource("/img/bgRent.jpg")));
		lblBGRent.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGRent.setBounds(-2, -30, 350, 615);
		contentPane.add(lblBGRent);
	}

	private String getDeskripsiPekerjaan(String selectedPekerjaan) {
	    String deskripsiPekerjaan = ""; // Inisialisasi deskripsi pekerjaan

	    try {
	        // Buat koneksi ke database
	    	con  = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        // Buat query SQL untuk mengambil deskripsi pekerjaan berdasarkan nama pekerjaan
	        String query = "SELECT deskripsi_pekerjaan FROM hireme.pekerjaan WHERE nama_pekerjaan = ?";
	        PreparedStatement statementRent = con.prepareStatement(query);
	        statementRent.setString(1, selectedPekerjaan);

	        // Eksekusi query
	        ResultSet resultSet = statementRent.executeQuery();

	        // Jika ada hasil dari query, ambil deskripsi pekerjaan dari hasil query
	        if (resultSet.next()) {
	            deskripsiPekerjaan = resultSet.getString("deskripsi_pekerjaan");
	        }

	        // Tutup koneksi dan statement
	        resultSet.close();
	        statementRent.close();
	        con.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return deskripsiPekerjaan;
	}

}
