package stm.dev.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import stm.dev.game.Version;
import stm.dev.game.states.MainMenuState;

/**
 * 
 * @author smillet
 *
 */
public class MainMenu implements ActionListener {
	
	//
	private	JFrame jfr = null;
	
	//
	private MainMenuState MMS = null;

	//
	private JButton[] buttons = null;
	
	//
	private JLabel jlver = null;
	
	/**
	 * 
	 * @param _MMS
	 */
	public MainMenu(MainMenuState _MMS)
	{
		//
		MMS = _MMS;
		// 
		Font font = null;
		try {
			font = new Font("Bauhaus 93",Font.BOLD, 28);
		} catch(Exception e) {
			font = new Font("System",Font.BOLD, 28);
		}
		//
		jfr = new JFrame();
		//
		JPanel jpm = new JPanel();
		jfr.getContentPane().add(jpm, BorderLayout.CENTER);
		BoxLayout BL =  new BoxLayout(jpm, BoxLayout.Y_AXIS);
		jpm.setLayout(BL);
		//
		String[]choices = MMS.getChoices();
		boolean[]enabled = MMS.getEnabled();
		buttons = new JButton[choices.length];
		int bbw=0, bbh=0;
		//
		for (int i=0; i<choices.length; i++)
		{
			//
			JButton b = new JButton(choices[i]);
			b.setFont(font);
			b.setAlignmentX(Component.LEFT_ALIGNMENT);
			b.setMaximumSize(new Dimension(300,50));
			b.setEnabled(enabled[i]);
			b.addActionListener(this);
			buttons[i] = b;
			jpm.add(b);
			//
			int bh = b.getPreferredSize().height;
			int bw = b.getPreferredSize().width;
			if (bw>bbw) bbw=bw;
			if (bh>bbh) bbh=bh;
		}
		//
		try {
			java.net.URL urlToImage = this.getClass().getResource("/stm/dev/resources/images/LogoMainMenu.png");
			BufferedImage BI = ImageIO.read(urlToImage);
			ImageIcon II = new ImageIcon(BI.getScaledInstance(bbw, BI.getHeight()* bbw/BI.getWidth(), BufferedImage.SCALE_SMOOTH));
			JLabel jpi = new JLabel(II);
			jpi.setMaximumSize(new Dimension(300,50));
			jpi.setAlignmentX(Component.CENTER_ALIGNMENT);
			jpi.setHorizontalTextPosition(SwingConstants.CENTER);
			jpi.setVerticalTextPosition(SwingConstants.CENTER);
			jfr.getContentPane().add(jpi, BorderLayout.NORTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//
		try {
			java.net.URL urlToImage = this.getClass().getResource("/stm/dev/resources/images/Icon.png");
			BufferedImage BI = ImageIO.read(urlToImage);
			jfr.setIconImage(BI);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//
		jlver = new JLabel(Version.copyright+"- version "+Version.version);
		jlver.setHorizontalTextPosition(SwingConstants.CENTER);
		jfr.getContentPane().add(jlver, BorderLayout.SOUTH);
		//
		jfr.pack();
		jfr.setVisible(false);
		//
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		int h = gd.getDisplayMode().getHeight();
		int w = gd.getDisplayMode().getWidth();
		Dimension dim = jfr.getSize();
		jfr.setBackground(Color.BLACK);
		jfr.setLocation(new Point(w/2-dim.width/2, h/2-dim.height/2));
		jfr.setAlwaysOnTop(true);
		jfr.setResizable(false);
		jfr.setTitle("eXplorer");
		jfr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	/**
	 * 
	 */
	public void enable() {
		//
		boolean[]enabled = MMS.getEnabled();
		//
		for (int i=0; i<buttons.length; i++)
		{
			buttons[i].setEnabled(enabled[i]);
		}
		//
		jfr.setVisible(true);
	
	}
	
	public void disable() {
		//
		jfr.setVisible(false);
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		MMS.action(command);
	}

	/**
	 * 
	 * @param string
	 */
	public boolean confirmAction(String string) {
		int r = JOptionPane.showConfirmDialog(jfr, string, null, JOptionPane.YES_NO_OPTION);
		return r == JOptionPane.YES_OPTION;
	}
}
