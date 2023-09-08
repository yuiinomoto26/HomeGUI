package designGui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class home extends JFrame {

	private JPanel contentPane;
	JEditorPane editorPane;
	 final static int C00 = 1000;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new OverlayLayout(contentPane));
		
		setContentPane(contentPane);
		
		ImageIcon icon1 = new ImageIcon(System.getProperty("user.dir") +"/img/ダウンロード.png");
	    setIconImage(icon1.getImage());
		
		ImageIcon icon = new ImageIcon("img/flower-back0923.png");
		Image image = icon.getImage();
		Image newImg = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		
     	JPanel panel = new JPanel();
     	contentPane.add(panel);
     	panel.setLayout(null);
     	
     	JButton btnNewButton = new JButton("Phone");
     	btnNewButton.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     			phone p = new phone();
     			p.setVisible(true);
     		}
     	});
    	
     	btnNewButton.setForeground(new Color(73, 37, 37));
     	btnNewButton.setFont(new Font("Nirmala UI", Font.BOLD, 16));
     	btnNewButton.setBackground(new Color(193, 218, 234));
     	btnNewButton.setBounds(25, 420, 120, 40);
     	panel.add(btnNewButton);
     	
     	JButton btnNewButton_1 = new JButton("Mail");
     	btnNewButton_1.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     		     // アプリ起動やフォルダを開く
     	     	Runtime r = Runtime.getRuntime();
     	     	try {
     	     		r.exec("C:\\Program Files\\Microsoft Office\\root\\Office16\\OUTLOOK.EXE");
     	     		
    	     	} catch (IOException e1) {
    	     		
     	     		e1.printStackTrace();
     	     	}
     		}
     	});
    	btnNewButton_1.setForeground(new Color(73, 37, 37));
     	btnNewButton_1.setFont(new Font("Nirmala UI", Font.BOLD, 16));
     	btnNewButton_1.setBackground(new Color(193, 218, 234));
     	btnNewButton_1.setBounds(180, 420, 120, 40);
     	panel.add(btnNewButton_1);
     	
     	JButton btnNewButton_2 = new JButton("Gallery");
     	btnNewButton_2.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     			
     			 Desktop desktop = Desktop.getDesktop();
                 try {
                     desktop.open(new File("C:\\Users\\3030926\\Pictures\\Camera Roll\\005_s.png"));
                 } catch (IOException ex) {
                     ex.printStackTrace();
                 }
    		}
     	});
     	btnNewButton_2.setForeground(new Color(73, 37, 37));
     	btnNewButton_2.setFont(new Font("Nirmala UI", Font.BOLD, 16));
     	btnNewButton_2.setToolTipText("");
     	btnNewButton_2.setBackground(new Color(193, 218, 234));
     	btnNewButton_2.setBounds(335, 420, 120, 40);
     	panel.add(btnNewButton_2);
     	
     	JPanel haikeiPnl = new JPanel();
     	haikeiPnl.setBounds(0, 0, 476, 503);
     	haikeiPnl.setBackground(new Color(228, 222, 207));
     	
     	JLabel lblNewLabel = new JLabel("");
     	lblNewLabel.setBackground(new Color(73, 37, 37));
     	lblNewLabel.setForeground(new Color(73, 37, 37));
     	lblNewLabel.setIcon(new ImageIcon(newImg));
     	haikeiPnl.add(lblNewLabel);
     	
     	editorPane = new JEditorPane();
     	editorPane.setFont(new Font("Nirmala UI", Font.PLAIN, 14));
     	editorPane.setForeground(new Color(73, 37, 37));
     	editorPane.setBackground(new Color(228, 222, 207));
     	editorPane.setBounds(280, 200, 160, 180);
     	panel.add(editorPane);
     	
     	DrawPanel draw = new DrawPanel();
     	draw.setBackground(new Color(228, 222, 207));
     	draw.setForeground(new Color(73, 37, 37));
     	draw.setFont(new Font("Arial Black", Font.BOLD, 30));
     	draw.setBounds(282, 58, 173, 68);
     	panel.add(draw);
     	new Timer(C00, draw).start();
     	draw.setLayout(null);
     	panel.add(haikeiPnl);
     	
     	JButton btnNewButton_3 = new JButton("");
     	btnNewButton_3.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     			String filePath = "C:\\Users\\3030926\\Desktop\\MEMO\\memo.txt";
     			try(FileWriter fw = new FileWriter(filePath);
    					BufferedWriter bw = new BufferedWriter(fw);) {
    				
    				bw.write(editorPane.getText());
    				bw.newLine();
    				editorPane.setText("");
     			} catch (IOException e1) {
     				
					e1.printStackTrace();
				}
    			
     		}
     	});
     	btnNewButton_3.setForeground(new Color(73, 37, 37));
     	btnNewButton_3.setBackground(new Color(73, 37, 37));
     	btnNewButton_3.setBounds(230, 10, 30, 20);
     	panel.add(btnNewButton_3);
     	
     	
     	
	}
}
class DrawPanel extends JPanel implements ActionListener {

    public DrawPanel() {
        setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent A00) {
        repaint();
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);

        String L00 = String.format("%1$tI:%1$tM", new Date());    // 

        FontMetrics L01 = A00.getFontMetrics();

        A00.drawString(L00, (getWidth() - L01.stringWidth(L00)) / 2,
                (getHeight() + L01.getAscent() - L01.getDescent()) / 2);
    }
}
