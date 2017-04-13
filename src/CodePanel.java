import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.paint.gjt.PaintIndicator;

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

	public CodePanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setViewportView(panel);
		// panel.setPreferredSize(new Dimension(500, 1000));
		// panel.setSize(500, 1000); // 两句一起写才有效果，不知道为什么
		setBackground(Color.WHITE);

	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
