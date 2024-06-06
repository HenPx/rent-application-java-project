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

public class Bangunan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNamaBangunan;
	private JTextField textPekerjaanBangunan;
	private JTextField textBiayaBangunan;
	private JTextField textBiayaBangunan2;
	private JTextField textPekerjaanBangunan2;
	private JTextField textNamaBangunan2;
	private JTextField textPekerjaanBangunan3;
	private JTextField textBiayaBangunan3;
	private JTextField textNamaBangunan3;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bangunan frame = new Bangunan();
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
	public Bangunan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArrowBangunan = new JLabel("");
		lblArrowBangunan.setIcon(new ImageIcon(Home.class.getResource("/img/arrow-back-circle-sharp.png")));
		lblArrowBangunan.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrowBangunan.setBounds(15, 25, 49, 40);
		contentPane.add(lblArrowBangunan);
		
		lblArrowBangunan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home homeFrame = new Home();
				homeFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		textBiayaBangunan3 = new JTextField();
		textBiayaBangunan3.setOpaque(false);
		textBiayaBangunan3.setForeground(Color.BLACK);
		textBiayaBangunan3.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaBangunan3.setColumns(10);
		textBiayaBangunan3.setBorder(null);
		textBiayaBangunan3.setEditable(false);
		textBiayaBangunan3.setBackground(Color.WHITE);
		textBiayaBangunan3.setBounds(70, 440, 180, 18);
		contentPane.add(textBiayaBangunan3);
		
		textNamaBangunan3 = new JTextField();
		textNamaBangunan3.setOpaque(false);
		textNamaBangunan3.setForeground(Color.BLUE);
		textNamaBangunan3.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaBangunan3.setColumns(10);
		textNamaBangunan3.setBorder(null);
		textNamaBangunan3.setEditable(false);
		textNamaBangunan3.setBackground(Color.WHITE);
		textNamaBangunan3.setBounds(70, 400, 180, 18);
		contentPane.add(textNamaBangunan3);
		
		textPekerjaanBangunan3 = new JTextField();
		textPekerjaanBangunan3.setOpaque(false);
		textPekerjaanBangunan3.setForeground(Color.BLACK);
		textPekerjaanBangunan3.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanBangunan3.setColumns(10);
		textPekerjaanBangunan3.setBorder(null);
		textPekerjaanBangunan3.setEditable(false);
		textPekerjaanBangunan3.setBackground(Color.WHITE);
		textPekerjaanBangunan3.setBounds(70, 420, 180, 18);
		contentPane.add(textPekerjaanBangunan3);
		
		textPekerjaanBangunan2 = new JTextField();
		textPekerjaanBangunan2.setOpaque(false);
		textPekerjaanBangunan2.setForeground(Color.BLACK);
		textPekerjaanBangunan2.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanBangunan2.setColumns(10);
		textPekerjaanBangunan2.setBorder(null);
		textPekerjaanBangunan2.setEditable(false);
		textPekerjaanBangunan2.setBackground(Color.WHITE);
		textPekerjaanBangunan2.setBounds(70, 300, 180, 18);
		contentPane.add(textPekerjaanBangunan2);
		
		textBiayaBangunan2 = new JTextField();
		textBiayaBangunan2.setOpaque(false);
		textBiayaBangunan2.setForeground(Color.BLACK);
		textBiayaBangunan2.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaBangunan2.setColumns(10);
		textBiayaBangunan2.setBorder(null);
		textBiayaBangunan2.setEditable(false);
		textBiayaBangunan2.setBackground(Color.WHITE);
		textBiayaBangunan2.setBounds(70, 320, 180, 18);
		contentPane.add(textBiayaBangunan2);
		
		textNamaBangunan2 = new JTextField();
		textNamaBangunan2.setOpaque(false);
		textNamaBangunan2.setForeground(Color.BLUE);
		textNamaBangunan2.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaBangunan2.setColumns(10);
		textNamaBangunan2.setBorder(null);
		textNamaBangunan2.setEditable(false);
		textNamaBangunan2.setBackground(Color.WHITE);
		textNamaBangunan2.setBounds(70, 280, 180, 18);
		contentPane.add(textNamaBangunan2);
		
		textBiayaBangunan = new JTextField();
		textBiayaBangunan.setOpaque(false);
		textBiayaBangunan.setForeground(Color.BLACK);
		textBiayaBangunan.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaBangunan.setColumns(10);
		textBiayaBangunan.setBorder(null);
		textBiayaBangunan.setEditable(false);
		textBiayaBangunan.setBackground(Color.WHITE);
		textBiayaBangunan.setBounds(70, 210, 180, 18);
		contentPane.add(textBiayaBangunan);
		
		textPekerjaanBangunan = new JTextField();
		textPekerjaanBangunan.setHorizontalAlignment(SwingConstants.LEFT);
		textPekerjaanBangunan.setOpaque(false);
		textPekerjaanBangunan.setForeground(Color.BLACK);
		textPekerjaanBangunan.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanBangunan.setColumns(10);
		textPekerjaanBangunan.setBorder(null);
		textPekerjaanBangunan.setEditable(false);
		textPekerjaanBangunan.setBackground(Color.WHITE);
		textPekerjaanBangunan.setBounds(70, 190, 180, 18);
		contentPane.add(textPekerjaanBangunan);
		
		textNamaBangunan = new JTextField();
		textNamaBangunan.setOpaque(false);
		textNamaBangunan.setForeground(Color.BLUE);
		textNamaBangunan.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaBangunan.setColumns(10);
		textNamaBangunan.setBorder(null);
		textNamaBangunan.setEditable(false);
		textNamaBangunan.setBackground(Color.WHITE);
		textNamaBangunan.setBounds(70, 170, 180, 18);
		contentPane.add(textNamaBangunan);
		
		JLabel lblAvatarBangunan3 = new JLabel("");
		lblAvatarBangunan3.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarBangunan3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarBangunan3.setBounds(15, 411, 50, 50);
		contentPane.add(lblAvatarBangunan3);
		
		JLabel lblAvatarBangunan2 = new JLabel("");
		lblAvatarBangunan2.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarBangunan2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarBangunan2.setBounds(15, 290, 50, 50);
		contentPane.add(lblAvatarBangunan2);
		
		JLabel lblAvatarBangunan = new JLabel("");
		lblAvatarBangunan.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarBangunan.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarBangunan.setBounds(15, 180, 50, 50);
		contentPane.add(lblAvatarBangunan);
		
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
		
		JLabel lblBGBangunan = new JLabel("");
		lblBGBangunan.setIcon(new ImageIcon(Bangunan.class.getResource("/img/bgBangunan2.jpg")));
		lblBGBangunan.setBounds(0, 0, 360, 620);
		contentPane.add(lblBGBangunan);
		
		addBangunan();
	}
	
	public void addBangunan (){
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
            statement.setString(1, "Bangunan"); // Mengatur nilai parameter untuk kategori_pekerjaan

            // Eksekusi query
            ResultSet resultSet = statement.executeQuery();

            // Tampilkan hasil ke text fields
            int count = 0;
            while (resultSet.next() && count < 3) {
                if (count == 0) {
                	textNamaBangunan.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanBangunan.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaBangunan.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 1) {
                	textNamaBangunan2.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanBangunan2.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaBangunan2.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 2) {
                	textNamaBangunan3.setText(resultSet.getString("namalengkap_pekerja"));
                    textPekerjaanBangunan3.setText(resultSet.getString("nama_pekerjaan"));
                    textBiayaBangunan3.setText(resultSet.getString("biaya_pekerjaan"));
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
