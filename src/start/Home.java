package start;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIconAkunHome = new JLabel("");
		lblIconAkunHome.setIcon(new ImageIcon(Home.class.getResource("/img/person-sharp.png")));
		lblIconAkunHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAkunHome.setBounds(270, 512, 65, 68);
		contentPane.add(lblIconAkunHome);
		
		lblIconAkunHome.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconAkunHome.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
			
		    @Override
		    public void mouseExited(MouseEvent e) {
		        lblIconAkunHome.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Akun akunFrame = new Akun();
				akunFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconRiwayatHome = new JLabel("");
		lblIconRiwayatHome.setIcon(new ImageIcon(Home.class.getResource("/img/iconRiwayat.jpg")));
		lblIconRiwayatHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRiwayatHome.setBounds(185, 512, 65, 68);
		contentPane.add(lblIconRiwayatHome);
		
		lblIconRiwayatHome.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconRiwayatHome.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconRiwayatHome.setBorder(null);
		    }
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Riwayat riwayatFrame = new Riwayat();
				riwayatFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconSearchHome = new JLabel("");
		lblIconSearchHome.setIcon(new ImageIcon(Home.class.getResource("/img/iconSearch.jpg")));
		lblIconSearchHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSearchHome.setBounds(100, 512, 65, 68);
		contentPane.add(lblIconSearchHome);
		
		lblIconSearchHome.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblIconSearchHome.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblIconSearchHome.setBorder(null);
		    }
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Search searchFrame = new Search();
				searchFrame.setVisible(true);
                dispose(); 
		    }
		});
		
		JLabel lblIconHomeHome = new JLabel("");
		lblIconHomeHome.setIcon(new ImageIcon(Home.class.getResource("/img/iconHome.jpg")));
		lblIconHomeHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHomeHome.setBounds(15, 512, 65, 68);
		contentPane.add(lblIconHomeHome);
		
		JLabel lblNavbarHome = new JLabel("");
		lblNavbarHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNavbarHome.setIcon(new ImageIcon(Home.class.getResource("/img/navbar.jpg")));
		lblNavbarHome.setBounds(0, 510, 380, 70);
		contentPane.add(lblNavbarHome);
		
		JLabel lblElektronik = new JLabel("");
		lblElektronik.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        lblElektronik.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        lblElektronik.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Elektronik elektronikFrame = new Elektronik();
				elektronikFrame.setVisible(true);
	            dispose();     
			}
		}
		);
		
		lblElektronik.setIcon(new ImageIcon(Home.class.getResource("/img/Elektronik.png")));
		lblElektronik.setHorizontalAlignment(SwingConstants.CENTER);
		lblElektronik.setBounds(220, 133, 93, 94);
		contentPane.add(lblElektronik);
		
		JLabel lblBangunan = new JLabel("");
		lblBangunan.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        lblBangunan.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblBangunan.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Bangunan bangunanFrame = new Bangunan();
				bangunanFrame.setVisible(true);
	            dispose();     
			}
		   }
		);
		
		lblBangunan.setIcon(new ImageIcon(Home.class.getResource("/img/Bangunan.png")));
		lblBangunan.setHorizontalAlignment(SwingConstants.CENTER);
		lblBangunan.setBounds(30, 133, 93, 94);
		contentPane.add(lblBangunan);
		
		JLabel lblLainnya = new JLabel("");
		lblLainnya.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	lblLainnya.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblLainnya.setBorder(null);
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) {
				Lainnya lainnyaFrame = new Lainnya();
				lainnyaFrame.setVisible(true);
	            dispose();     
			}
			}
		);
		lblLainnya.setIcon(new ImageIcon(Home.class.getResource("/img/Lainnya.png")));
		lblLainnya.setHorizontalAlignment(SwingConstants.CENTER);
		lblLainnya.setBounds(126, 283, 93, 94);
		contentPane.add(lblLainnya);
		
		JLabel lblBGHome = new JLabel("");
		lblBGHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGHome.setIcon(new ImageIcon(Home.class.getResource("/img/bgHome3.jpg")));
		lblBGHome.setBounds(0, 0, 360, 620);
		contentPane.add(lblBGHome);		
	}
}
