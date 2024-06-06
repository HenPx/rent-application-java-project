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

public class Riwayat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textMetodeTransaksi3;
	private JTextField textMetodeTransaksi2;
	private JTextField textMetodeTransaksi1;
	private JTextField textWaktuTransaksi3;
	private JTextField textWaktuTransaksi2;
	private JTextField textWaktuTransaksi1;
	private JTextField textKodeTransaksi3;
	private JTextField textKodeTransaksi2;
	private JTextField textKodeTransaksi1;
	private JTextField textKodeProyek3;
	private JTextField textKodeProyek2;
	private JTextField textKodeProyek1;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Riwayat frame = new Riwayat();
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
	public Riwayat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMetodeTransaksi3 = new JTextField();
		textMetodeTransaksi3.setHorizontalAlignment(SwingConstants.CENTER);
		textMetodeTransaksi3.setOpaque(false);
		textMetodeTransaksi3.setForeground(Color.BLACK);
		textMetodeTransaksi3.setFont(new Font("Roboto", Font.BOLD, 13));
		textMetodeTransaksi3.setColumns(10);
		textMetodeTransaksi3.setBorder(null);
		textMetodeTransaksi3.setEditable(false);
		textMetodeTransaksi3.setBackground(Color.WHITE);
		textMetodeTransaksi3.setBounds(230, 450, 100, 18);
		contentPane.add(textMetodeTransaksi3);
		
		textMetodeTransaksi2 = new JTextField();
		textMetodeTransaksi2.setHorizontalAlignment(SwingConstants.CENTER);
		textMetodeTransaksi2.setOpaque(false);
		textMetodeTransaksi2.setForeground(Color.BLACK);
		textMetodeTransaksi2.setFont(new Font("Roboto", Font.BOLD, 13));
		textMetodeTransaksi2.setColumns(10);
		textMetodeTransaksi2.setBorder(null);
		textMetodeTransaksi2.setEditable(false);
		textMetodeTransaksi2.setBackground(Color.WHITE);
		textMetodeTransaksi2.setBounds(230, 310, 100, 18);
		contentPane.add(textMetodeTransaksi2);
		
		textMetodeTransaksi1 = new JTextField();
		textMetodeTransaksi1.setHorizontalAlignment(SwingConstants.CENTER);
		textMetodeTransaksi1.setOpaque(false);
		textMetodeTransaksi1.setForeground(Color.BLACK);
		textMetodeTransaksi1.setFont(new Font("Roboto", Font.BOLD, 13));
		textMetodeTransaksi1.setColumns(10);
		textMetodeTransaksi1.setBorder(null);
		textMetodeTransaksi1.setEditable(false);
		textMetodeTransaksi1.setBackground(Color.WHITE);
		textMetodeTransaksi1.setBounds(230, 170, 100, 18);
		contentPane.add(textMetodeTransaksi1);
		
		textWaktuTransaksi3 = new JTextField();
		textWaktuTransaksi3.setOpaque(false);
		textWaktuTransaksi3.setForeground(Color.BLACK);
		textWaktuTransaksi3.setFont(new Font("Roboto", Font.PLAIN, 13));
		textWaktuTransaksi3.setColumns(10);
		textWaktuTransaksi3.setBorder(null);
		textWaktuTransaksi3.setEditable(false);
		textWaktuTransaksi3.setBackground(Color.WHITE);
		textWaktuTransaksi3.setBounds(90, 420, 100, 18);
		contentPane.add(textWaktuTransaksi3);

		textWaktuTransaksi2 = new JTextField();
		textWaktuTransaksi2.setOpaque(false);
		textWaktuTransaksi2.setForeground(Color.BLACK);
		textWaktuTransaksi2.setFont(new Font("Roboto", Font.PLAIN, 13));
		textWaktuTransaksi2.setColumns(10);
		textWaktuTransaksi2.setBorder(null);
		textWaktuTransaksi2.setEditable(false);
		textWaktuTransaksi2.setBackground(Color.WHITE);
		textWaktuTransaksi2.setBounds(90, 280, 100, 18);
		contentPane.add(textWaktuTransaksi2);
		
		textWaktuTransaksi1 = new JTextField();
		textWaktuTransaksi1.setOpaque(false);
		textWaktuTransaksi1.setForeground(Color.BLACK);
		textWaktuTransaksi1.setFont(new Font("Roboto", Font.PLAIN, 13));
		textWaktuTransaksi1.setColumns(10);
		textWaktuTransaksi1.setBorder(null);
		textWaktuTransaksi1.setEditable(false);
		textWaktuTransaksi1.setBackground(Color.WHITE);
		textWaktuTransaksi1.setBounds(90, 140, 100, 18);
		contentPane.add(textWaktuTransaksi1);
		
		textKodeProyek3 = new JTextField();
		textKodeProyek3.setOpaque(false);
		textKodeProyek3.setForeground(Color.BLACK);
		textKodeProyek3.setFont(new Font("Roboto", Font.BOLD, 13));
		textKodeProyek3.setColumns(10);
		textKodeProyek3.setBorder(null);
		textKodeProyek3.setEditable(false);
		textKodeProyek3.setBackground(Color.WHITE);
		textKodeProyek3.setBounds(90, 400, 100, 18);
		contentPane.add(textKodeProyek3);
		
		textKodeProyek2 = new JTextField();
		textKodeProyek2.setOpaque(false);
		textKodeProyek2.setForeground(Color.BLACK);
		textKodeProyek2.setFont(new Font("Roboto", Font.BOLD, 13));
		textKodeProyek2.setColumns(10);
		textKodeProyek2.setBorder(null);
		textKodeProyek2.setEditable(false);
		textKodeProyek2.setBackground(Color.WHITE);
		textKodeProyek2.setBounds(90, 260, 100, 18);
		contentPane.add(textKodeProyek2);
		
		textKodeProyek1 = new JTextField();
		textKodeProyek1.setOpaque(false);
		textKodeProyek1.setForeground(Color.BLACK);
		textKodeProyek1.setFont(new Font("Roboto", Font.BOLD, 13));
		textKodeProyek1.setColumns(10);
		textKodeProyek1.setBorder(null);
		textKodeProyek1.setEditable(false);
		textKodeProyek1.setBackground(Color.WHITE);
		textKodeProyek1.setBounds(90, 120, 100, 18);
		contentPane.add(textKodeProyek1);
		
		textKodeTransaksi3 = new JTextField();
		textKodeTransaksi3.setOpaque(false);
		textKodeTransaksi3.setForeground(Color.WHITE);
		textKodeTransaksi3.setFont(new Font("Roboto", Font.BOLD, 15));
		textKodeTransaksi3.setColumns(10);
		textKodeTransaksi3.setBorder(null);
		textKodeTransaksi3.setEditable(false);
		textKodeTransaksi3.setBackground(Color.WHITE);
		textKodeTransaksi3.setBounds(30, 370, 110, 18);
		contentPane.add(textKodeTransaksi3);
		
		textKodeTransaksi2 = new JTextField();
		textKodeTransaksi2.setOpaque(false);
		textKodeTransaksi2.setForeground(Color.WHITE);
		textKodeTransaksi2.setFont(new Font("Roboto", Font.BOLD, 15));
		textKodeTransaksi2.setColumns(10);
		textKodeTransaksi2.setBorder(null);
		textKodeTransaksi2.setEditable(false);
		textKodeTransaksi2.setBackground(Color.WHITE);
		textKodeTransaksi2.setBounds(30, 230, 110, 18);
		contentPane.add(textKodeTransaksi2);

		textKodeTransaksi1 = new JTextField();
		textKodeTransaksi1.setOpaque(false);
		textKodeTransaksi1.setForeground(Color.WHITE);
		textKodeTransaksi1.setFont(new Font("Roboto", Font.BOLD, 15));
		textKodeTransaksi1.setColumns(10);
		textKodeTransaksi1.setBorder(null);
		textKodeTransaksi1.setEditable(false);
		textKodeTransaksi1.setBackground(Color.WHITE);
		textKodeTransaksi1.setBounds(30, 90, 110, 18);
		contentPane.add(textKodeTransaksi1);
		
		JLabel printSelesai3 = new JLabel("");
		printSelesai3.setHorizontalAlignment(SwingConstants.CENTER);
		printSelesai3.setIcon(new ImageIcon(Riwayat.class.getResource("/img/printSelesai.png")));
		printSelesai3.setBounds(260, 370, 49, 14);
		contentPane.add(printSelesai3);
		
		JLabel printSelesai2 = new JLabel("");
		printSelesai2.setHorizontalAlignment(SwingConstants.CENTER);
		printSelesai2.setIcon(new ImageIcon(Riwayat.class.getResource("/img/printSelesai.png")));
		printSelesai2.setBounds(260, 230, 49, 14);
		contentPane.add(printSelesai2);
		
		JLabel printSelesai1 = new JLabel("");
		printSelesai1.setHorizontalAlignment(SwingConstants.CENTER);
		printSelesai1.setIcon(new ImageIcon(Riwayat.class.getResource("/img/printSelesai.png")));
		printSelesai1.setBounds(260, 90, 49, 14);
		contentPane.add(printSelesai1);
		
		JLabel lblholderRiwayat_1 = new JLabel("");
		lblholderRiwayat_1.setIcon(new ImageIcon(Riwayat.class.getResource("/img/holderRiwayat.jpg")));
		lblholderRiwayat_1.setBounds(21, 220, 303, 120);
		contentPane.add(lblholderRiwayat_1);
		
		JLabel lblholderRiwayat_1_1 = new JLabel("");
		lblholderRiwayat_1_1.setIcon(new ImageIcon(Riwayat.class.getResource("/img/holderRiwayat.jpg")));
		lblholderRiwayat_1_1.setBounds(21, 360, 303, 120);
		contentPane.add(lblholderRiwayat_1_1);
		
		JLabel lblholderRiwayat = new JLabel("");
		lblholderRiwayat.setIcon(new ImageIcon(Riwayat.class.getResource("/img/holderRiwayat.jpg")));
		lblholderRiwayat.setBounds(21, 80, 303, 120);
		contentPane.add(lblholderRiwayat);
		
		JLabel lblIconRiwayatRiwayat = new JLabel("");
		lblIconRiwayatRiwayat.setIcon(new ImageIcon(Riwayat.class.getResource("/img/iconRiwayatBlue.jpg")));
		lblIconRiwayatRiwayat.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRiwayatRiwayat.setBounds(185, 512, 65, 68);
		contentPane.add(lblIconRiwayatRiwayat);
		
		lblIconRiwayatRiwayat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconRiwayatRiwayat.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconRiwayatRiwayat.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Riwayat riwayatFrame = new Riwayat();
				riwayatFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconAkunRiwayat = new JLabel("");
		lblIconAkunRiwayat.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblIconAkunRiwayat.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAkunRiwayat.setBounds(270, 512, 65, 68);
		contentPane.add(lblIconAkunRiwayat);
		
		lblIconAkunRiwayat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconAkunRiwayat.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconAkunRiwayat.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Akun akunFrame = new Akun();
				akunFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconSearchRiwayat = new JLabel("");
		lblIconSearchRiwayat.setIcon(new ImageIcon(Riwayat.class.getResource("/img/iconSearch.jpg")));
		lblIconSearchRiwayat.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSearchRiwayat.setBounds(100, 512, 65, 68);
		contentPane.add(lblIconSearchRiwayat);
		
		lblIconSearchRiwayat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconSearchRiwayat.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconSearchRiwayat.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Search searchFrame = new Search();
				searchFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconHomeRiwayat = new JLabel("");
		lblIconHomeRiwayat.setIcon(new ImageIcon(Home.class.getResource("/img/home.jpg")));
		lblIconHomeRiwayat.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHomeRiwayat.setBounds(15, 512, 65, 68);
		contentPane.add(lblIconHomeRiwayat);
		
		lblIconHomeRiwayat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconHomeRiwayat.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconHomeRiwayat.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Home homeFrame = new Home();
				homeFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblNavBarRiwayat = new JLabel("");
		lblNavBarRiwayat.setIcon(new ImageIcon(Home.class.getResource("/img/navbar.jpg")));
		lblNavBarRiwayat.setHorizontalAlignment(SwingConstants.CENTER);
		lblNavBarRiwayat.setBounds(0, 510, 380, 70);
		contentPane.add(lblNavBarRiwayat);
		
		JLabel lblBGRiwayat = new JLabel("");
		lblBGRiwayat.setIcon(new ImageIcon(Riwayat.class.getResource("/img/bgRiwayat.jpg")));
		lblBGRiwayat.setBounds(0, 0, 350, 615);
		contentPane.add(lblBGRiwayat);
		
		viewDataTransaksi();
	}
	
	private void viewDataTransaksi() {
        con = null;
        PreparedStatement statementRiwayat = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");
            
            // Query untuk mengambil 3 baris teratas dari tabel transaksi
            String query = "SELECT kode_transaksi, kode_proyek, waktu_transaksi, metode_transaksi FROM transaksi ORDER BY waktu_transaksi DESC LIMIT 3";
            statementRiwayat = con.prepareStatement(query);
            rs = statementRiwayat.executeQuery();

            int counter = 1;
            while (rs.next()) {
                // Mengisi JTextField dengan data dari database
                setTextFieldValues(counter, rs.getString("kode_transaksi"), rs.getString("kode_proyek"),
                        rs.getString("waktu_transaksi"), rs.getString("metode_transaksi"));
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        	} finally {
            try {
                if (rs != null) rs.close();
                if (statementRiwayat != null) statementRiwayat.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            	}
        	}
    	}
	
		private void setTextFieldValues(int counter, String kodeTransaksi, String kodeProyek,
            String waktuTransaksi, String metodeTransaksi) {
		if (counter == 1) {
			textKodeTransaksi1.setText(kodeTransaksi);
			textKodeProyek1.setText(kodeProyek);
			textWaktuTransaksi1.setText(waktuTransaksi);
			textMetodeTransaksi1.setText(metodeTransaksi);
			} else if (counter == 2) {
			textKodeTransaksi2.setText(kodeTransaksi);
			textKodeProyek2.setText(kodeProyek);
			textWaktuTransaksi2.setText(waktuTransaksi);
			textMetodeTransaksi2.setText(metodeTransaksi);
			} else if (counter == 3) {
			textKodeTransaksi3.setText(kodeTransaksi);
			textKodeProyek3.setText(kodeProyek);
			textWaktuTransaksi3.setText(waktuTransaksi);
			textMetodeTransaksi3.setText(metodeTransaksi);
			}
		}
}
