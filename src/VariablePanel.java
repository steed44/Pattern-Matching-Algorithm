import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class VariablePanel extends JScrollPane implements Runnable {

	/**
	 * Create the panel.
	 */
	Thread t = new Thread(this);
	protected VarPanel panel = new VarPanel();

	public VariablePanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setViewportView(panel);
		t.start();

	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	class MyTask extends TimerTask {
		@Override
		public void run() {

			if (panel.k * 16 + 200 >= panel.getWidth()) {
				panel.setPreferredSize(new Dimension(panel.k * 25 + 200, getHeight()));
				panel.setSize(panel.k * 25 + 200, getHeight()); // 两句一起写才有效果，不知道为什么
			}
			if (panel.getWidth() - panel.k * 25 + 200 > 150) {
				panel.setPreferredSize(new Dimension(panel.k * 25 + 200, getHeight()));
				panel.setSize(panel.k * 25 + 200, getHeight()); // 两句一起写才有效果，不知道为什么
			}

			JScrollBar scrollBar = getHorizontalScrollBar(); // 得到水平方向的滚动条
			scrollBar.setValue(scrollBar.getMaximum()); // 设置滚动条为最大值
		}

	}

	@Override
	public void run() {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 0, 1000);
	}

}
