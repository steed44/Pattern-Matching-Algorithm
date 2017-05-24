import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


//import com.paint.ght.PaintIndicator;

import ght.model.com.BF;
import ght.model.com.BFAlgorithm;
import ght.model.com.KMP;
import ght.model.com.KMPAlgorithm;

import java.awt.BorderLayout;

public class CodePanel extends JScrollPane implements Runnable, ActionListener {

	/**
	 * Create the panel.
	 */

	protected CodeJSPane panel = new CodeJSPane();
//	Thread t = new Thread(this);
	public CodePanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setViewportView(panel);
		setPreferredSize(new Dimension(250, 1000));
		setSize(250, 1000); // 两句一起写才有效果，不知道为什么

		setBackground(Color.WHITE);

	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	class MyTask extends TimerTask {
		@Override
		public void run() {
//			int a = panel
//			if (panel.k * 16 + 200 >= panel.getWidth()) {
//				panel.setPreferredSize(new Dimension(panel.k * 25 + 200, getHeight()));
//				panel.setSize(panel.k * 25 + 200, getHeight()); // 两句一起写才有效果，不知道为什么
//			}
//			if (panel.getWidth() - panel.k * 25 + 200 > 150) {
//				panel.setPreferredSize(new Dimension(panel.k * 25 + 200, getHeight()));
//				panel.setSize(panel.k * 25 + 200, getHeight()); // 两句一起写才有效果，不知道为什么
//			}

//			JScrollBar scrollBar = getHorizontalScrollBar(); // 得到水平方向的滚动条
//			scrollBar.setValue(scrollBar.getMaximum()); // 设置滚动条为最大值
		}

	}

	@Override
	public void run() {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 0, 1000);
	}


}
