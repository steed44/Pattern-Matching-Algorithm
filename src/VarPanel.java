import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ght.model.com.BFAlgorithm;
import ght.model.com.KMPAlgorithm;

public class VarPanel extends JPanel implements Runnable, ActionListener, ChangeListener {

	/**
	 * Create the panel.
	 */
	private BFAlgorithm bfAlgorithm = null;
	private KMPAlgorithm kmpAlgorithm = null;
	int charY = 20, charX = 5;
	int panelNum = 0;
	int k = 0;
	int wideth;

	public VarPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.WHITE);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		g.setColor(Color.BLACK);

		if (bfAlgorithm != null) {
			switch (panelNum) {
			case 0:
				g.setColor(Color.CYAN);
				if (k != 0) {
					g.fillRect(charX + 25 * k + 50, 0, 25, 600);
				}
				g.setColor(Color.BLACK);
				for (int m = 0; m < k; m++) {
					g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
					g.drawString(String.valueOf(bfAlgorithm.getListI().get(m)), charX + 25 * m + 80, charY);
					g.drawString(String.valueOf(bfAlgorithm.getListCharI().get(m)), charX + 25 * m + 80, charY + 22);
					g.drawString(String.valueOf(bfAlgorithm.getListJ().get(m)), charX + 25 * m + 80, charY + 44);
					g.drawString(String.valueOf(bfAlgorithm.getListCharJ().get(m)), charX + 25 * m + 80, charY + 66);
				}
				break;
			case 1:
				g.setColor(Color.CYAN);
				if (k != 0) {
					g.fillRect(charX + 25 * k + 50, 0, 25, 600);
				}
				g.setColor(Color.BLACK);
				for (int m = 0; m < k; m++) {
					g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
					if (kmpAlgorithm.getListJ().get(m) >= 0) {
						g.drawString(String.valueOf(kmpAlgorithm.getListI().get(m)), charX + 25 * m + 80, charY);
						g.drawString(String.valueOf(kmpAlgorithm.getListCharI().get(m)), charX + 25 * m + 80,
								charY + 22);
						g.drawString(String.valueOf(kmpAlgorithm.getListJ().get(m)), charX + 25 * m + 80, charY + 44);
						g.drawString(String.valueOf(kmpAlgorithm.getListCharJ().get(m)), charX + 25 * m + 80,
								charY + 66);
						g.drawString(String.valueOf(kmpAlgorithm.getNext()[kmpAlgorithm.getListJ().get(m)]),
								charX + 25 * m + 80, charY + 88);
					}
				}
				break;
			case 2:
				break;
			default:
				break;
			}
		}
		switch (panelNum) {
		case 0:
			g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
			g.drawString("i", charX + 40, charY);
			g.drawString("charAt(i)", charX, charY + 22);
			g.drawString("j", charX + 40, charY + 44);
			g.drawString("charAt(j)", charX, charY + 66);
			// 添加设置jspanel大小的代码
			break;
		case 1:
			g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
			g.drawString("i", charX + 40, charY);
			g.drawString("charAt(i)", charX, charY + 22);
			g.drawString("j", charX + 40, charY + 44);
			g.drawString("charAt(j)", charX, charY + 66);
			g.drawString("next[i]", charX, charY + 88);
			// 添加设置jspanel大小的代码

			break;
		case 2:
			break;
		default:
			break;
		}

	}

	public void reset() {
		bfAlgorithm = BFAlgorithm.parseGson();
		kmpAlgorithm = KMPAlgorithm.parseGson();
		k = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (bfAlgorithm != null) {
			if (e.getActionCommand().equals("上一步")) {
				if (k > 0 && k < bfAlgorithm.getListI().size() - 1) {
					k--;
					repaint();
				}

			}
			if (e.getActionCommand().equals("下一步")) {
				if (k >= 0 && k < bfAlgorithm.getListI().size() - 2) {
					k++;
					repaint();
				}

			}

		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		k++;
		repaint();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
		panelNum = tabbedPane.getSelectedIndex();
		k = 0;
		repaint();
	}

}
