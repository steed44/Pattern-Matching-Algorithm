import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BMPanel extends JPanel implements Runnable, ActionListener {

	/**
	 * Create the panel.
	 */
	String isStar;

	public BMPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		ControlBtnPanel controlBtnPanel = new ControlBtnPanel();
		add(controlBtnPanel, BorderLayout.SOUTH);

	}

	public void paint(Graphics g) {
		super.paint(g);

		// g.drawOval(10, 10, 30, 30);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}