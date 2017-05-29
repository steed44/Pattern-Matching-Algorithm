import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class VariablePanel extends JScrollPane {

	/**
	 * Create the panel.
	 */
	// Thread t = new Thread(this);
	protected VarPanel panel = new VarPanel();

	public VariablePanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setViewportView(panel);
		setPreferredSize(new Dimension(getWidth(), 45));
		setSize(getWidth(), 45); // 两句一起写才有效果，不知道为什么
		// t.start();

	}

	public void paint(Graphics g) {
		super.paint(g);
	}

}
