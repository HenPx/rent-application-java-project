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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Search extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textSearch;
	private JTextField textNamaSearch;
	private JTextField textPekerjaanSearch;
	private JTextField textBiayaSearch;
	private JTextField textBiayaSearch2;
	private JTextField textPekerjaanSearch2;
	private JTextField textNamaSearch2;
	private JTextField textPekerjaanSearch3;
	private JTextField textBiayaSearch3;
	private JTextField textNamaSearch3;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel btnRent3 = new JLabel("");
        btnRent3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Rent.selectedNama = textNamaSearch3.getText();
                Rent.selectedPekerjaan = textPekerjaanSearch3.getText();
                Rent.selectedBiaya = textBiayaSearch3.getText();
                
                Rent rentFrame = new Rent();
                rentFrame.setVisible(true);
                dispose();
            }
        });
		
		JLabel btnCariSearch = new JLabel("");
		btnCariSearch.setIcon(new ImageIcon(Search.class.getResource("/img/btnCariSearch.png")));
		btnCariSearch.setHorizontalAlignment(SwingConstants.CENTER);
		btnCariSearch.setBounds(232, 65, 84, 44);
		contentPane.add(btnCariSearch);
		btnCariSearch.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	updateSearch();
		    }
		});
		
		btnRent3.setHorizontalAlignment(SwingConstants.CENTER);
		btnRent3.setIcon(new ImageIcon(Search.class.getResource("/img/btnRent.jpg")));
		btnRent3.setBounds(245, 412, 84, 44);
		contentPane.add(btnRent3);
		
		JLabel btnRent2 = new JLabel("");
        btnRent2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Rent.selectedNama = textNamaSearch2.getText();
            	Rent.selectedPekerjaan = textPekerjaanSearch2.getText();
            	Rent.selectedBiaya = textBiayaSearch2.getText();
                
                Rent rentFrame = new Rent();
                rentFrame.setVisible(true);
                dispose();
            }
        });
        
		btnRent2.setHorizontalAlignment(SwingConstants.CENTER);
		btnRent2.setIcon(new ImageIcon(Search.class.getResource("/img/btnRent.jpg")));
		btnRent2.setBounds(245, 276, 84, 44);
		contentPane.add(btnRent2);
		
		JLabel btnRent = new JLabel("");
        btnRent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Rent.selectedNama = textNamaSearch.getText();
            	Rent.selectedPekerjaan = textPekerjaanSearch.getText();
            	Rent.selectedBiaya = textBiayaSearch.getText();
                
                Rent rentFrame = new Rent();
                rentFrame.setVisible(true);
                dispose();
            }
        });
		btnRent.setHorizontalAlignment(SwingConstants.CENTER);
		btnRent.setIcon(new ImageIcon(Search.class.getResource("/img/btnRent.jpg")));
		btnRent.setBounds(245, 142, 84, 44);
		contentPane.add(btnRent);
		
		textBiayaSearch3 = new JTextField();
		textBiayaSearch3.setOpaque(false);
		textBiayaSearch3.setForeground(Color.BLACK);
		textBiayaSearch3.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaSearch3.setColumns(10);
		textBiayaSearch3.setBorder(null);
		textBiayaSearch3.setEditable(false);
		textBiayaSearch3.setBackground(Color.WHITE);
		textBiayaSearch3.setBounds(70, 451, 180, 18);
		contentPane.add(textBiayaSearch3);
		
		textNamaSearch3 = new JTextField();
		textNamaSearch3.setOpaque(false);
		textNamaSearch3.setForeground(Color.BLUE);
		textNamaSearch3.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaSearch3.setColumns(10);
		textNamaSearch3.setBorder(null);
		textNamaSearch3.setEditable(false);
		textNamaSearch3.setBackground(Color.WHITE);
		textNamaSearch3.setBounds(70, 414, 180, 18);
		contentPane.add(textNamaSearch3);
		
		textPekerjaanSearch3 = new JTextField();
		textPekerjaanSearch3.setOpaque(false);
		textPekerjaanSearch3.setForeground(Color.BLACK);
		textPekerjaanSearch3.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanSearch3.setColumns(10);
		textPekerjaanSearch3.setBorder(null);
		textPekerjaanSearch3.setEditable(false);
		textPekerjaanSearch3.setBackground(Color.WHITE);
		textPekerjaanSearch3.setBounds(70, 434, 180, 18);
		contentPane.add(textPekerjaanSearch3);
		
		textPekerjaanSearch2 = new JTextField();
		textPekerjaanSearch2.setOpaque(false);
		textPekerjaanSearch2.setForeground(Color.BLACK);
		textPekerjaanSearch2.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanSearch2.setColumns(10);
		textPekerjaanSearch2.setBorder(null);
		textPekerjaanSearch2.setEditable(false);
		textPekerjaanSearch2.setBackground(Color.WHITE);
		textPekerjaanSearch2.setBounds(70, 297, 180, 18);
		contentPane.add(textPekerjaanSearch2);
		
		textBiayaSearch2 = new JTextField();
		textBiayaSearch2.setOpaque(false);
		textBiayaSearch2.setForeground(Color.BLACK);
		textBiayaSearch2.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaSearch2.setColumns(10);
		textBiayaSearch2.setBorder(null);
		textBiayaSearch2.setEditable(false);
		textBiayaSearch2.setBackground(Color.WHITE);
		textBiayaSearch2.setBounds(70, 319, 180, 18);
		contentPane.add(textBiayaSearch2);
		
		textNamaSearch2 = new JTextField();
		textNamaSearch2.setOpaque(false);
		textNamaSearch2.setForeground(Color.BLUE);
		textNamaSearch2.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaSearch2.setColumns(10);
		textNamaSearch2.setBorder(null);
		textNamaSearch2.setEditable(false);
		textNamaSearch2.setBackground(Color.WHITE);
		textNamaSearch2.setBounds(70, 277, 180, 18);
		contentPane.add(textNamaSearch2);
		
		textBiayaSearch = new JTextField();
		textBiayaSearch.setOpaque(false);
		textBiayaSearch.setForeground(Color.BLACK);
		textBiayaSearch.setFont(new Font("Roboto", Font.PLAIN, 13));
		textBiayaSearch.setColumns(10);
		textBiayaSearch.setBorder(null);
		textBiayaSearch.setEditable(false);
		textBiayaSearch.setBackground(Color.WHITE);
		textBiayaSearch.setBounds(70, 185, 180, 18);
		contentPane.add(textBiayaSearch);
		
		textPekerjaanSearch = new JTextField();
		textPekerjaanSearch.setOpaque(false);
		textPekerjaanSearch.setForeground(Color.BLACK);
		textPekerjaanSearch.setFont(new Font("Roboto", Font.BOLD, 13));
		textPekerjaanSearch.setColumns(10);
		textPekerjaanSearch.setBorder(null);
		textPekerjaanSearch.setEditable(false);
		textPekerjaanSearch.setBackground(Color.WHITE);
		textPekerjaanSearch.setBounds(70, 163, 180, 18);
		contentPane.add(textPekerjaanSearch);
		
		textNamaSearch = new JTextField();
		textNamaSearch.setOpaque(false);
		textNamaSearch.setForeground(Color.BLUE);
		textNamaSearch.setFont(new Font("Roboto", Font.BOLD, 14));
		textNamaSearch.setColumns(10);
		textNamaSearch.setBorder(null);
		textNamaSearch.setEditable(false);
		textNamaSearch.setBackground(Color.WHITE);
		textNamaSearch.setBounds(70, 145, 180, 18);
		contentPane.add(textNamaSearch);
		
		textSearch = new JTextField();
		textSearch.setBounds(61, 36, 244, 18);
		textSearch.setFont(new Font("Arial", Font.BOLD, 15));
		textSearch.setBackground(new Color(255, 255, 255));
		textSearch.setForeground(Color.BLACK);
		textSearch.setOpaque(false);
		textSearch.setBorder(null);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		JLabel lblAvatarSearch3 = new JLabel("");
		lblAvatarSearch3.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarSearch3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarSearch3.setBounds(15, 411, 50, 50);
		contentPane.add(lblAvatarSearch3);
		
		JLabel lblAvatarSearch2 = new JLabel("");
		lblAvatarSearch2.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarSearch2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarSearch2.setBounds(15, 276, 50, 50);
		contentPane.add(lblAvatarSearch2);
		
		JLabel lblAvatarSearch = new JLabel("");
		lblAvatarSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvatarSearch.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblAvatarSearch.setBounds(15, 140, 50, 50);
		contentPane.add(lblAvatarSearch);
		
		JLabel lblBarSearch = new JLabel("");
		lblBarSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarSearch.setIcon(new ImageIcon(Search.class.getResource("/img/search bar.png")));
		lblBarSearch.setBounds(29, 30, 287, 30);
		contentPane.add(lblBarSearch);
		
		JLabel lblIconRiwayatSearch = new JLabel("");
		lblIconRiwayatSearch.setIcon(new ImageIcon(Akun.class.getResource("/img/iconRiwayat.jpg")));
		lblIconRiwayatSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRiwayatSearch.setBounds(185, 512, 65, 68);
		contentPane.add(lblIconRiwayatSearch);
		
		lblIconRiwayatSearch.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconRiwayatSearch.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconRiwayatSearch.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Riwayat riwayatFrame = new Riwayat();
				riwayatFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconAkunSearch = new JLabel("");
		lblIconAkunSearch.setIcon(new ImageIcon(Search.class.getResource("/img/person-sharp.png")));
		lblIconAkunSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAkunSearch.setBounds(270, 512, 65, 68);
		contentPane.add(lblIconAkunSearch);
		
		lblIconAkunSearch.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconAkunSearch.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconAkunSearch.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Akun akunFrame = new Akun();
				akunFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconSearchSearch = new JLabel("");
		lblIconSearchSearch.setIcon(new ImageIcon(Search.class.getResource("/img/iconSearchBlue.jpg")));
		lblIconSearchSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSearchSearch.setBounds(100, 512, 65, 68);
		contentPane.add(lblIconSearchSearch);
		
		JLabel lblIconHomeSearch = new JLabel("");
		lblIconHomeSearch.setIcon(new ImageIcon(Home.class.getResource("/img/home.jpg")));
		lblIconHomeSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHomeSearch.setBounds(15, 512, 65, 68);
		contentPane.add(lblIconHomeSearch);
		
		lblIconHomeSearch.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconHomeSearch.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconHomeSearch.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Home homeFrame = new Home();
				homeFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblNavBarSearch = new JLabel("");
		lblNavBarSearch.setIcon(new ImageIcon(Home.class.getResource("/img/navbar.jpg")));
		lblNavBarSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblNavBarSearch.setBounds(0, 510, 380, 70);
		contentPane.add(lblNavBarSearch);
		
		JLabel lblBGSearch = new JLabel("");
		lblBGSearch.setIcon(new ImageIcon(Home.class.getResource("/img/bgSearch.jpg")));
		lblBGSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGSearch.setBounds(0, -30, 350, 615);
		contentPane.add(lblBGSearch);
		
		viewSearch();	
	}
	
	public void updateSearch() {
    	String searchText = textSearch.getText().trim();

        try {
            // Buat koneksi ke database
            con  = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

            // Buat query SQL 
            String query = "SELECT pekerja.namalengkap_pekerja, pekerjaan.nama_pekerjaan, pekerjaan.biaya_pekerjaan " +
            			"FROM hireme.pekerjaan " +
            			"INNER JOIN hireme.pekerja ON pekerjaan.id_pekerja = pekerja.id_pekerja " +
            			"WHERE nama_pekerjaan LIKE ? OR kategori_pekerjaan LIKE ? " +
            			"ORDER BY pekerjaan.biaya_pekerjaan ASC LIMIT 3";

            // Persiapkan statement SQL
            PreparedStatement statementUpdateSearch = con.prepareStatement(query);
            statementUpdateSearch.setString(1, "%" + searchText + "%");
            statementUpdateSearch.setString(2, "%" + searchText + "%");

            // Eksekusi query
            ResultSet resultSet = statementUpdateSearch.executeQuery();
            
            // Bersihkan isi text fields sebelum menampilkan hasil baru
            textNamaSearch.setText("");
            textPekerjaanSearch.setText("");
            textBiayaSearch.setText("");
            textNamaSearch2.setText("");
            textPekerjaanSearch2.setText("");
            textBiayaSearch2.setText("");
            textNamaSearch3.setText("");
            textPekerjaanSearch3.setText("");
            textBiayaSearch3.setText("");

            // Tampilkan hasil ke text fields
            int count = 0;
            while (resultSet.next() && count < 3) {
                if (count == 0) {
                    textNamaSearch.setText(resultSet.getString("namalengkap_pekerja"));
                    textPekerjaanSearch.setText(resultSet.getString("nama_pekerjaan"));
                    textBiayaSearch.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 1) {
                    textNamaSearch2.setText(resultSet.getString("namalengkap_pekerja"));
                    textPekerjaanSearch2.setText(resultSet.getString("nama_pekerjaan"));
                    textBiayaSearch2.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 2) {
                    textNamaSearch3.setText(resultSet.getString("namalengkap_pekerja"));
                    textPekerjaanSearch3.setText(resultSet.getString("nama_pekerjaan"));
                    textBiayaSearch3.setText(resultSet.getString("biaya_pekerjaan"));
                }
                count++;
            }

            // Tutup koneksi dan statement
            resultSet.close();
            statementUpdateSearch.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    	}
	
	public void viewSearch (){
        try {
            // Buat koneksi ke database
            con  = DriverManager.getConnection("jdbc:mysql://localhost/hireme", "root", "");

            // Buat query SQL 
            String query = "SELECT pekerja.namalengkap_pekerja, pekerjaan.nama_pekerjaan, pekerjaan.biaya_pekerjaan " +
                            "FROM hireme.pekerjaan " +
                            "INNER JOIN hireme.pekerja ON pekerjaan.id_pekerja = pekerja.id_pekerja " +
                            "ORDER BY pekerjaan.biaya_pekerjaan ASC LIMIT 3";

            // Persiapkan statement SQL
            PreparedStatement statementViewSearch = con.prepareStatement(query);
            
            // Eksekusi query
            ResultSet resultSet = statementViewSearch.executeQuery();

            // Tampilkan hasil ke text fields
            int count = 0;
            while (resultSet.next() && count < 3) {
                if (count == 0) {
                	textNamaSearch.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanSearch.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaSearch.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 1) {
                	textNamaSearch2.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanSearch2.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaSearch2.setText(resultSet.getString("biaya_pekerjaan"));
                } else if (count == 2) {
                	textNamaSearch3.setText(resultSet.getString("namalengkap_pekerja"));
                	textPekerjaanSearch3.setText(resultSet.getString("nama_pekerjaan"));
                	textBiayaSearch3.setText(resultSet.getString("biaya_pekerjaan"));
                }
                count++;
            }

            // Tutup koneksi dan statement
            resultSet.close();
            statementViewSearch.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
