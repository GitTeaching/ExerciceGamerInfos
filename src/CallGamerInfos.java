
import javax.swing.SwingUtilities;

public class CallGamerInfos {

	public static void main(String[] args) {
			
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){			
				GamerInfos frame = new GamerInfos();
				frame.setVisible(true);
			}
		});
	}
}
