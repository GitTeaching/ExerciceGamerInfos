
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GamerInfos extends JFrame {
	
	public GamerInfos() {
		super();
		initJFrame();
	}

	private void initJFrame() {
		this.setTitle("My JFrame TP 10");
	    this.setSize(500, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);   
	    
	    JButton start = new JButton("Gamer Configuration");
	    this.getContentPane().setLayout(new FlowLayout());
	    this.getContentPane().add(start);
	    start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GamerInfoDialog gamer = new GamerInfoDialog();
				gamer.setVisible(true);
			}
	    	
	    });
	}

}
