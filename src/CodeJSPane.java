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

import ght.model.com.BF;
import ght.model.com.BFAlgorithm;
import ght.model.com.BM;
import ght.model.com.BMAlgorithm;
import ght.model.com.KMP;
import ght.model.com.KMPAlgorithm;

public class CodeJSPane extends JPanel implements Runnable, ActionListener, ChangeListener {

	/**
	 * Create the panel.
	 */
	private BF bf = new BF();
	private KMP kmp = new KMP();
	private BM bm = new BM();
	private BFAlgorithm bfAlgorithm = null;
	private KMPAlgorithm kmpAlgorithm = null;
	private BMAlgorithm bmAlgorithm = null;
	private int panelNum = 0;
	private int k = 0;
	protected Thread thread = new Thread(this);

	public CodeJSPane() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.WHITE);
	}

	public void reset() {
		bfAlgorithm = BFAlgorithm.parseGson();
		kmpAlgorithm = KMPAlgorithm.parseGson();
		bmAlgorithm = BMAlgorithm.parseGson();
		k = 0;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.CYAN);
		g.setFont(new Font("TimesRoman", Font.ITALIC, 18));
		if (bfAlgorithm != null) {
			switch (panelNum) {
			case 0:
				if (k < bfAlgorithm.getListI().size()) {
					g.fillRect(2, bfAlgorithm.getListRow().get(k) * 20 - 15, 500, 20);
					g.setColor(Color.BLACK);
					for (int i = 0; i < bf.bfStrings.length; i++) {
						g.drawString(bf.bfStrings[i], 5, 20 + i * 20);
					}
				}
				break;
			case 1:
				if (k < kmpAlgorithm.getListI().size()) {
					g.fillRect(2, kmpAlgorithm.getListRow().get(k) * 20 - 15, 1000, 20);
					g.setColor(Color.BLACK);
					for (int i = 0; i < kmp.kmpStr.length; i++) {
						g.drawString(kmp.kmpStr[i], 5, 20 + i * 20);
					}
				}
				break;
			case 2:
				if (k < bmAlgorithm.getListI().size()) {
					g.fillRect(2, bmAlgorithm.getListRow().get(k) * 20 - 15, 1000, 20);
					g.setColor(Color.BLACK);
					for (int i = 0; i < bm.bmStrings.length; i++) {
						g.drawString(bm.bmStrings[i], 5, 20 + i * 20);
					}
				}
				break;
			default:
				break;
			}

		} else {
			switch (panelNum) {
			case 0:
				g.fillRect(2, 20 - 15, 500, 20);
				g.setColor(Color.BLACK);
				for (int i = 0; i < bf.bfStrings.length; i++) {
					g.drawString(bf.bfStrings[i], 5, 20 + i * 20);
				}
				break;
			case 1:
				g.fillRect(2, 5, 500, 20);
				g.setColor(Color.BLACK);
				for (int i = 0; i < kmp.kmpStr.length; i++) {
					g.drawString(kmp.kmpStr[i], 5, 20 + i * 20);
				}
				break;
			case 2:
				g.fillRect(2, 5, 500, 20);
				g.setColor(Color.BLACK);
				for (int i = 0; i < bm.bmStrings.length; i++) {
					g.drawString(bm.bmStrings[i], 5, 20 + i * 20);
				}
				break;
			default:
				break;
			}
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (bfAlgorithm != null) {
			switch (panelNum) {
			case 0:
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
				break;
			case 1:
				if (e.getActionCommand().equals("上一步")) {
					if (k > 0 && k < kmpAlgorithm.getListI().size() - 1) {
						k--;
						repaint();
					}
				}
				if (e.getActionCommand().equals("下一步")) {
					if (k >= 0 && k < kmpAlgorithm.getListI().size() - 2) {
						k++;
						repaint();
					}
				}
				break;
			case 2:
				if (e.getActionCommand().equals("上一步")) {
					if (k > 0 && k < bmAlgorithm.getListJ().size() - 1) {
						k--;
						repaint();
					}
				}
				if (e.getActionCommand().equals("下一步")) {
					if (k >= 0 && k < bmAlgorithm.getListJ().size() - 2) {
						k++;
						repaint();
					}
				}
				break;
			default:
				break;
			}

		}
	}

	public void run() {
		// TODO Auto-generated method stub
		k++;
		repaint();
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getK() {
		return k;
	}

	public int getPanelNum() {
		return panelNum;
	}

	public void setPanelNum(int panelNum) {
		this.panelNum = panelNum;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
		panelNum = tabbedPane.getSelectedIndex();
		k = 0;
		repaint();
	}
}
