package zad1;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Info {
	
	public JDialog okno;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 250;
	public JLabel image, lblAutor, lblAutorI, lblAutorMail ;
	
	public Info() {

		okno = new JDialog(Apka.frame, "Info", false);
		okno.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		okno.setVisible(true);
		okno.setBounds(100, 100, 450, 300);
		okno.getContentPane().setLayout(null);
		
		Dimension frameSize  = new Dimension(WIDTH,HEIGHT);			
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if(frameSize.height > screenSize.height) frameSize.height = screenSize.height;
		if(frameSize.width > screenSize.width) frameSize.width = screenSize.width;
		okno.setSize(frameSize);	
		okno.setLocation((screenSize.width-frameSize.width)/2, 
					(screenSize.height-frameSize.height)/2);
		
		try {
			image = new JLabel(new ImageIcon("icons/logo.png"));
			image.setBounds(26, 36, 100, 120);
			okno.getContentPane().add(image);
			
			lblAutor = new JLabel("Autor:");
			lblAutor.setBounds(226, 36, 46, 14);
			okno.getContentPane().add(lblAutor);
			
			lblAutorI = new JLabel("   Dawid Szymoniak");
			lblAutorI.setBounds(180, 61, 164, 14);
			okno.getContentPane().add(lblAutorI);
			
			JLabel lblAutorMail = new JLabel("u20123@s.tu.koszalin.pl");
			lblAutorMail .setBounds(156, 87, 218, 14);
			okno.getContentPane().add(lblAutorMail);
		} catch (Exception e1) {
			System.out.println("Nie znaleziono zdjecia");
		}
	

	}
}
