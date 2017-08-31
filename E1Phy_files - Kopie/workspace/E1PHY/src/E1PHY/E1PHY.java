package E1PHY;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class E1PHY extends JFrame implements ActionListener{
	
	//Definieren
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double height = screenSize.getHeight();
	
	String[] Letter = {"A.jpg" ,"B.jpg" ,"C.jpg", "D.jpg" ,"E.jpg" ,"F.jpg" ,"G.jpg" ,"H.jpg" ,"I.jpg" ,"J.jpg" ,"K.jpg" ,"L.jpg" ,"M.jpg" ,"N.jpg" ,"O.jpg" ,"P.jpg" ,"Q.jpg" ,"R.jpg" ,"S.jpg" ,"T.jpg" ,"U.jpg" ,"V.jpg" ,"W.jpg" ,"X.jpg" ,"Y.jpg" ,"Z.jpg"};
	final int FMax = 26;
	public JButton Knopf = new JButton("Starten");
	public Graphics Grafik;
	public Graphics Grafik_num;
	public Graphics weiss;
	public Image Bild;
	public Image pic;
	public Image pic1;
	public Image pic2;
	public Image white;
	public int Strecke;
	final String Pfad = "D:\\E1Phy_files\\";
	public int x = 30 , Dicke = 200;
	public double y = 175;
	int yy = (int) y;
	Dimension size = getSize();
	int Breite = size.width;
	int High = size.height;
	
	
	public static void main (String [] args){
		E1PHY Rahmen = new E1PHY();
		Rahmen.setSize(450,350);
		//Rahmen.setUndecorated(true);
		Rahmen.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Rahmen.setVisible(true);
	}
	public E1PHY(){
		 super("E1PHY");
		 JPanel Platte = new JPanel();
		 Platte.setBackground(Color.white);
		 Platte.setLayout(new FlowLayout());
		 
		 Knopf.addActionListener(this);
		  Platte.add(Knopf);
		  setContentPane(Platte);
		 
	}
	
	public void actionPerformed(ActionEvent e) {
		
	Object Quelle = e.getSource();
	if (Quelle == Knopf) start();
	}
	
	
	public void start()
		{	
					Toolkit Werkzeug = Toolkit.getDefaultToolkit();
					pic = Werkzeug.getImage(Pfad + "1.jpg");
					pic1 = Werkzeug.getImage(Pfad + "2.jpg");
					pic2 = Werkzeug.getImage(Pfad + "3.jpg");
					
					white = Werkzeug.getImage(Pfad + "z-weiß.png");
					
					MediaTracker Transporter1 = new MediaTracker (this);
					Transporter1.addImage(pic2, 1);
					try{
						Transporter1.waitForID(1);
					}
					catch (InterruptedException x)
					{
						setTitle("Bildstörung"); 
					}
					Grafik_num = getGraphics();
					Grafik_num.drawImage(pic2, x, yy, null);
					try
					 {
						 Thread.sleep (1000);
					 }
					 catch (InterruptedException x)
					 {
						 setTitle("Schlafstörung");
					 }
					
					
					weiss = getGraphics();
					weiss.drawImage(white, x,yy, null);
					
						
						try
						 {
							 Thread.sleep (1000);
						 }
						 catch (InterruptedException x)
						 {
							 setTitle("Schlafstörung");
						 }
					
							
							MediaTracker Transporter2 = new MediaTracker (this);
							Transporter2.addImage(pic1, 1);
							try{
								Transporter2.waitForID(1);
							}
							catch (InterruptedException x)
							{
								setTitle("Bildstörung"); 
							}
							Grafik_num = getGraphics();
							Grafik_num.drawImage(pic1, x+150, yy, null);
							try
							 {
								 Thread.sleep (1000);
							 }
							 catch (InterruptedException x)
							 {
								 setTitle("Schlafstörung");
							 }
							
							
							repaint();
						
							
									MediaTracker Transporter3 = new MediaTracker (this);
									Transporter3.addImage(pic, 1);
									try{
										Transporter3.waitForID(1);
									}
									catch (InterruptedException x)
									{
										setTitle("Bildstörung"); 
									}
									repaint();
									Grafik_num = getGraphics();
									Grafik_num.drawImage(pic, x+300, yy, null);
									try
									 {
										 Thread.sleep (1000);
									 }
									 catch (InterruptedException x)
									 {
										 setTitle("Schlafstörung");
									 }
												for(int b = 0; b < 10; b++){
												showImage();
												}
			}
	public void showImage() {
		repaint();

		
		String Let = (Letter[(int)(Math.random()*FMax)]);
		Toolkit Werkzeug = Toolkit.getDefaultToolkit();
		Bild = Werkzeug.getImage(Pfad + Let);
		MediaTracker Transporter = new MediaTracker (this);
		Transporter.addImage(Bild, 1);
		try{
			Transporter.waitForID(1);
		}
		catch (InterruptedException x)
		{
			setTitle("Bildstörung"); 
		}
		Grafik = getGraphics();
		Grafik.drawImage(Bild, x, yy, null);
		
		Strecke = getWidth ();
		 for(int i = x-1; i-200 < Strecke-Dicke-x-1; i++){
			 
			 Grafik.copyArea(i, yy, Dicke+2, Dicke+2, 1, 0);
		 try
		 {
			 Thread.sleep (10);
		 }
		 catch (InterruptedException x)
		 {
			 setTitle("Schlafstörung");
		 }
		 repaint();
		 }
			 
		 }
	}
