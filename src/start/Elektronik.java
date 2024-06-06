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

public class Elektronik extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNamaElektronik;
	private JTextField textPekerjaanElektronik;
	private JTextField textBiayaElektronik;
	private JTextField textBiayaElektronik2;
	private JTextField textPekerjaanElektronik2;
	private JTextField textNamaElektronik2;
	private JTextField textPekerjaanElektronik3;
	private JTextField textBiayaElektronik3;
	private JTextField textNamaElektronik3;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Elektronik frame = new Elektronik();
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
	public Elektronik() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArrowElektronik = new JLabel("");
		lblArrowElektronik.setIcon(new ImageIcon(Home.class.getResource("/img/arrow-back-circle-sharp.png")));
		lblArrowElektronik.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrowElektronik.setBounds(15, 25, 49, 40);
		contentPane.add(lblArrowElektronik);
		
		lblArrowElektronik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home homeFrame = new Home();
				homeFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		textBiayaElektronik3 = new JTextField();
		textBiayaElektronik3.setOpaque(false);
		textBiayaElektronik3.setForeground(Color.BLACK);
		textBiayaElektronik3.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaElektronik3.setColumns(10);
		textBiayaElektronik3.setBorder(null);
		textBiayaElektronik3.setEditable(false);
		textBiayaElektronik3.setBackground(Color.WHITE);
		textBiayaElektronik3.setBounds(70, 440, 180, 18);
		contentPane.add(textBiayaElektronik3);
		
		textNamaElektronik3 = new JTextField();
		textNamaElektronik3.setOpaque(false);
		textNamaElektronik3.setForeground(Color.BLUE);
		textNamaElektronik3.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaElektronik3.setColumns(10);
		textNamaElektronik3.setBorder(null);
		textNamaElektronik3.setEditable(false);
		textNamaElektronik3.setBackground(Color.WHITE);
		textNamaElektronik3.setBounds(70, 400, 180, 18);
		contentPane.add(textNamaElektronik3);
		
		textPekerjaanElektronik3 = new JTextField();
		textPekerjaanElektronik3.setOpaque(false);
		textPekerjaanElektronik3.setForeground(Color.BLACK);
		textPekerjaanElektronik3.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanElektronik3.setColumns(10);
		textPekerjaanElektronik3.setBorder(null);
		textPekerjaanElektronik3.setEditable(false);
		textPekerjaanElektronik3.setBackground(Color.WHITE);
		textPekerjaanElektronik3.setBounds(70, 420, 180, 18);
		contentPane.add(textPekerjaanElektronik3);
		
		textPekerjaanElektronik2 = new JTextField();
		textPekerjaanElektronik2.setOpaque(false);
		textPekerjaanElektronik2.setForeground(Color.BLACK);
		textPekerjaanElektronik2.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanElektronik2.setColumns(10);
		textPekerjaanElektronik2.setBorder(null);
		textPekerjaanElektronik2.setEditable(false);
		textPekerjaanElektronik2.setBackground(Color.WHITE);
		textPekerjaanElektronik2.setBounds(70, 300, 180, 18);
		contentPane.add(textPekerjaanElektronik2);
		
		textBiayaElektronik2 = new JTextField();
		textBiayaElektronik2.setOpaque(false);
		textBiayaElektronik2.setForeground(Color.BLACK);
		textBiayaElektronik2.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaElektronik2.setColumns(10);
		textBiayaElektronik2.setBorder(null);
		textBiayaElektronik2.setEditable(false);
		textBiayaElektronik2.setBackground(Color.WHITE);
		textBiayaElektronik2.setBounds(70, 320, 180, 18);
		contentPane.add(textBiayaElektronik2);
		
		textNamaElektronik2 = new JTextField();
		textNamaElektronik2.setOpaque(false);
		textNamaElektronik2.setForeground(Color.BLUE);
		textNamaElektronik2.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaElektronik2.setColumns(10);
		textNamaElektronik2.setBorder(null);
		textNamaElektronik2.setEditable(false);
		textNamaElektronik2.setBackground(Color.WHITE);
		textNamaElektronik2.setBounds(70, 280, 180, 18);
		contentPane.add(textNamaElektronik2);
		
		textBiayaElektronik = new JTextField();
		textBiayaElektronik.setOpaque(false);
		textBiayaElektronik.setForeground(Color.BLACK);
		textBiayaElektronik.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaElektronik.setColumns(10);
		textBiayaElektronik.setBorder(null);
		textBiayaElektronik.setEditable(false);
		textBiayaElektronik.setBackground(Color.WHITE);
		textBiayaElektronik.setBounds(70, 210, 180, 18);
		contentPane.add(textBiayaElektronik);
		
		textPekerjaanElektronik = new JTextField();
		textPekerjaanElektronik.setOpaque(false);
		textPekerjaanElektronik.setForeground(Color.BLACK);
		textPekerjaanElektronik.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanElektronik.setColumns(10);
		textPekerjaanElektronik.setBorder(null);
		textPekerjaanElektronik.setEditable(false);
		textPekerjaanElektronik.setBackground(Color.WHITE);
		textPekerjaanElektronik.setBounds(70, 190, 180, 18);
		contentPane.add(textPekerjaanElektronik);
		
		textNamaElektronik = new JTextField();
		textNamaElektronik.setOpaque(false);
		textNamaElektronik.setForeground(Color.BLUE);
		textNamaElektronik.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaElektronik.setColumns(10);
		textNamaElektronik.setBorder(null);
		textNamaElektronik.setEditable(false);
		textNamaElektronik.setBackground(Color.WHITE);
		textNamaElektronik.setBounds(70, 170, 180, 18);
		contentPane.add(textNamaElektronik);
		
		JLabel lblAvatarElektronik3 = new JLabel("");
		lblAvatarElektronik3.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarElektronik3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarElektronik3.setBounds(15, 411, 50, 50);
		contentPane.add(lblAvatarElektronik3);
		
		JLabel lblAvatarElektronik2 = new JLabel("");
		lblAvatarElektronik2.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarElektronik2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarElektronik2.setBounds(15, 290, 50, 50);
		contentPane.add(lblAvatarElektronik2);
		
		JLabel lblAvatarElektronik = new JLabel("");
		lblAvatarElektronik.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarElektronik.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarElektronik.setBounds(15, 180, 50, 50);
		contentPane.add(lblAvatarElektronik);
		
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
		
		JLabel lblBGElektronik = new JLabel("");
		lblBGElektronik.setIcon(new ImageIcon(Elektronik.class.getResource("/img/bgElektronik2.jpg")));
		lblBGElektronik.setBounds(0, 0, 360, 620);
		contentPane.add(lblBGElektronik);
		
		addElektronik();
	}
	
	public void addElektronik (){
        try {
            // Buat koneksi ke database
            con  = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

            // Buat query SQL 
            String query = "SELECT pekerja.namalengkap_pekerja, pekerjaan.nama_pekerjaan, pekerjaan.biaya_pekerjaan " +
                            "FROM hireme.pekerjaan " +
                            "INNER JOIN hireme.pekerja ON pekerjaan.id_pekerja = pekerja.id_pekerja " +
                            "WHERE pekerjaan.kategori_pekerjaan = ? " +  // Menambahkan kondisi WHERE
                            "ORDER BY pekerjaan.biaya_pekerjaan ASC LIMIT 3";

            // Persiapkan statement SQL
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, "Elektronik"); // Mengatur nilai parameter untuk kategori_pekerjaan

            // Eksekusi query
            ResultSet resultSet = statement.executeQuery();

            // Tampilkan hasil ke text fields
            int count = 0;
            while (resultSet.next() && count < 3) {
                if (count == 0) {
                	textNamaElektronik.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanElektronik.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaElektronik.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 1) {
                	textNamaElektronik2.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanElektronik2.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaElektronik2.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 2) {
                	textNamaElektronik3.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanElektronik3.setText(resultSet.getString("nama_pekerjaan"));
                    textBiayaElektronik3.setText(resultSet.getString("biaya_pekerjaan"));
                }
                count++;
            }

            // Tutup koneksi dan statement
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
