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

public class Lainnya extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNamaLainnya;
	private JTextField textPekerjaanLainnya;
	private JTextField textBiayaLainnya;
	private JTextField textBiayaLainnya2;
	private JTextField textPekerjaanLainnya2;
	private JTextField textNamaLainnya2;
	private JTextField textPekerjaanLainnya3;
	private JTextField textBiayaLainnya3;
	private JTextField textNamaLainnya3;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lainnya frame = new Lainnya();
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
	public Lainnya() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArrowLainnya = new JLabel("");
		lblArrowLainnya.setIcon(new ImageIcon(Home.class.getResource("/img/arrow-back-circle-sharp.png")));
		lblArrowLainnya.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrowLainnya.setBounds(15, 25, 49, 40);
		contentPane.add(lblArrowLainnya);
		
		lblArrowLainnya.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home homeFrame = new Home();
				homeFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		textBiayaLainnya3 = new JTextField();
		textBiayaLainnya3.setOpaque(false);
		textBiayaLainnya3.setForeground(Color.BLACK);
		textBiayaLainnya3.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaLainnya3.setColumns(10);
		textBiayaLainnya3.setBorder(null);
		textBiayaLainnya3.setEditable(false);
		textBiayaLainnya3.setBackground(Color.WHITE);
		textBiayaLainnya3.setBounds(70, 440, 180, 18);
		contentPane.add(textBiayaLainnya3);
		
		textNamaLainnya3 = new JTextField();
		textNamaLainnya3.setOpaque(false);
		textNamaLainnya3.setForeground(Color.BLUE);
		textNamaLainnya3.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaLainnya3.setColumns(10);
		textNamaLainnya3.setBorder(null);
		textNamaLainnya3.setEditable(false);
		textNamaLainnya3.setBackground(Color.WHITE);
		textNamaLainnya3.setBounds(70, 400, 180, 18);
		contentPane.add(textNamaLainnya3);
		
		textPekerjaanLainnya3 = new JTextField();
		textPekerjaanLainnya3.setOpaque(false);
		textPekerjaanLainnya3.setForeground(Color.BLACK);
		textPekerjaanLainnya3.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanLainnya3.setColumns(10);
		textPekerjaanLainnya3.setBorder(null);
		textPekerjaanLainnya3.setEditable(false);
		textPekerjaanLainnya3.setBackground(Color.WHITE);
		textPekerjaanLainnya3.setBounds(70, 420, 180, 18);
		contentPane.add(textPekerjaanLainnya3);
		
		textPekerjaanLainnya2 = new JTextField();
		textPekerjaanLainnya2.setOpaque(false);
		textPekerjaanLainnya2.setForeground(Color.BLACK);
		textPekerjaanLainnya2.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanLainnya2.setColumns(10);
		textPekerjaanLainnya2.setBorder(null);
		textPekerjaanLainnya2.setEditable(false);
		textPekerjaanLainnya2.setBackground(Color.WHITE);
		textPekerjaanLainnya2.setBounds(70, 300, 180, 18);
		contentPane.add(textPekerjaanLainnya2);
		
		textBiayaLainnya2 = new JTextField();
		textBiayaLainnya2.setOpaque(false);
		textBiayaLainnya2.setForeground(Color.BLACK);
		textBiayaLainnya2.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaLainnya2.setColumns(10);
		textBiayaLainnya2.setBorder(null);
		textBiayaLainnya2.setEditable(false);
		textBiayaLainnya2.setBackground(Color.WHITE);
		textBiayaLainnya2.setBounds(70, 320, 180, 18);
		contentPane.add(textBiayaLainnya2);
		
		textNamaLainnya2 = new JTextField();
		textNamaLainnya2.setOpaque(false);
		textNamaLainnya2.setForeground(Color.BLUE);
		textNamaLainnya2.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaLainnya2.setColumns(10);
		textNamaLainnya2.setBorder(null);
		textNamaLainnya2.setEditable(false);
		textNamaLainnya2.setBackground(Color.WHITE);
		textNamaLainnya2.setBounds(70, 280, 180, 18);
		contentPane.add(textNamaLainnya2);
		
		textBiayaLainnya = new JTextField();
		textBiayaLainnya.setOpaque(false);
		textBiayaLainnya.setForeground(Color.BLACK);
		textBiayaLainnya.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaLainnya.setColumns(10);
		textBiayaLainnya.setBorder(null);
		textBiayaLainnya.setEditable(false);
		textBiayaLainnya.setBackground(Color.WHITE);
		textBiayaLainnya.setBounds(70, 210, 180, 18);
		contentPane.add(textBiayaLainnya);
		
		textPekerjaanLainnya = new JTextField();
		textPekerjaanLainnya.setOpaque(false);
		textPekerjaanLainnya.setForeground(Color.BLACK);
		textPekerjaanLainnya.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanLainnya.setColumns(10);
		textPekerjaanLainnya.setBorder(null);
		textPekerjaanLainnya.setEditable(false);
		textPekerjaanLainnya.setBackground(Color.WHITE);
		textPekerjaanLainnya.setBounds(70, 190, 180, 18);
		contentPane.add(textPekerjaanLainnya);
		
		textNamaLainnya = new JTextField();
		textNamaLainnya.setOpaque(false);
		textNamaLainnya.setForeground(Color.BLUE);
		textNamaLainnya.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaLainnya.setColumns(10);
		textNamaLainnya.setBorder(null);
		textNamaLainnya.setEditable(false);
		textNamaLainnya.setBackground(Color.WHITE);
		textNamaLainnya.setBounds(70, 170, 180, 18);
		contentPane.add(textNamaLainnya);
		
		JLabel lblAvatarLainnya3 = new JLabel("");
		lblAvatarLainnya3.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarLainnya3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarLainnya3.setBounds(15, 411, 50, 50);
		contentPane.add(lblAvatarLainnya3);
		
		JLabel lblAvatarLainnya2 = new JLabel("");
		lblAvatarLainnya2.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarLainnya2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarLainnya2.setBounds(15, 290, 50, 50);
		contentPane.add(lblAvatarLainnya2);
		
		JLabel lblAvatarLainnya = new JLabel("");
		lblAvatarLainnya.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarLainnya.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarLainnya.setBounds(15, 180, 50, 50);
		contentPane.add(lblAvatarLainnya);
		
		JLabel lblIconAkun_5 = new JLabel("");
		lblIconAkun_5.setIcon(new ImageIcon(Home.class.getResource("/img/person-sharp.png")));
		lblIconAkun_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAkun_5.setBounds(270, 512, 65, 68);
		contentPane.add(lblIconAkun_5);
		
		JLabel lblIconNotif_5 = new JLabel("");
		lblIconNotif_5.setIcon(new ImageIcon(Home.class.getResource("/img/notifications-sharp.png")));
		lblIconNotif_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconNotif_5.setBounds(185, 512, 65, 68);
		contentPane.add(lblIconNotif_5);
		
		JLabel lblIconDiskusi_5 = new JLabel("");
		lblIconDiskusi_5.setIcon(new ImageIcon(Home.class.getResource("/img/at-circle-sharp.png")));
		lblIconDiskusi_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDiskusi_5.setBounds(100, 512, 65, 68);
		contentPane.add(lblIconDiskusi_5);

		JLabel lblIconHome_5 = new JLabel("");
		lblIconHome_5.setIcon(new ImageIcon(Home.class.getResource("/img/iconHome.jpg")));
		lblIconHome_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHome_5.setBounds(15, 512, 65, 68);
		contentPane.add(lblIconHome_5);
		
		JLabel lblNavbar_2 = new JLabel("");
		lblNavbar_2.setIcon(new ImageIcon(Home.class.getResource("/img/navbar.jpg")));
		lblNavbar_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNavbar_2.setBounds(0, 510, 380, 70);
		contentPane.add(lblNavbar_2);
		
		JLabel lblBGLainnya = new JLabel("");
		lblBGLainnya.setIcon(new ImageIcon(Lainnya.class.getResource("/img/bgLainnya2.jpg")));
		lblBGLainnya.setBounds(0, 0, 360, 620);
		contentPane.add(lblBGLainnya);
		
		addLainnya();
	}
	
	public void addLainnya (){
	    try {
	        // Buat koneksi ke database
	        con = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

	        // Buat query SQL 
	        String query = "SELECT pekerja.namalengkap_pekerja, pekerjaan.nama_pekerjaan, pekerjaan.biaya_pekerjaan " +
	                        "FROM hireme.pekerjaan " +
	                        "INNER JOIN hireme.pekerja ON pekerjaan.id_pekerja = pekerja.id_pekerja " +
	                        "WHERE pekerjaan.kategori_pekerjaan NOT IN (?, ?) " + // Kategori_pekerjaan bukan "Elektronik" dan "Bangunan"
	                        "ORDER BY pekerjaan.biaya_pekerjaan ASC LIMIT 3";

	        // Persiapkan statement SQL
	        PreparedStatement statementLainnya = con.prepareStatement(query);
	        statementLainnya.setString(1, "Elektronik");
	        statementLainnya.setString(2, "Bangunan");

            // Eksekusi query
            ResultSet resultSet = statementLainnya.executeQuery();

            // Tampilkan hasil ke text fields
            int count = 0;
            while (resultSet.next() && count < 3) {
                if (count == 0) {
                	textNamaLainnya.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanLainnya.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaLainnya.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 1) {
                	textNamaLainnya2.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanLainnya2.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaLainnya2.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 2) {
                	textNamaLainnya3.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanLainnya3.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaLainnya3.setText(resultSet.getString("biaya_pekerjaan"));
                }
                count++;
            }

            // Tutup koneksi dan statement
            resultSet.close();
            statementLainnya.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
