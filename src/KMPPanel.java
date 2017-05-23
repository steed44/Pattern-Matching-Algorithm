import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.paint.ght.PaintIndicator;
//import com.paint.ght.PaintIndicator;
import com.paint.ght.PaintRect;

import ght.model.com.BFAlgorithm;
import ght.model.com.KMPAlgorithm;

public class KMPPanel extends JPanel implements Runnable, ActionListener {

	/**
	 * Create the panel.
	 */
	protected KMPAlgorithm kmpAlgorithm = null;
	protected PaintIndicator pIndicator = null;
	private PaintRect p, q;
	protected int star = 0, k = 0;
	protected Thread t = new Thread(this);
	protected ControlBtnPanel controlBtnPanel;
	protected int isStart = 0;

	public KMPPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		controlBtnPanel = new ControlBtnPanel();
		add(controlBtnPanel, BorderLayout.SOUTH);

		controlBtnPanel.btnNewButton.addActionListener(this);
		controlBtnPanel.btnNewButton_3.addActionListener(this);
		controlBtnPanel.btnNewButton.setActionCommand("下一步");
		controlBtnPanel.btnNewButton_1.setActionCommand("暂停");
		controlBtnPanel.btnNewButton_2.setActionCommand("开始");
		controlBtnPanel.btnNewButton_3.setActionCommand("上一步");

	}

	public void reset() {
		kmpAlgorithm = KMPAlgorithm.parseGson();
		pIndicator = null;
		star = 0;
		k = 0;
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (kmpAlgorithm != null) {
			if (pIndicator == null || kmpAlgorithm.getListRow().get(k) <= 20) {
				pIndicator = new PaintIndicator(80, 30, 80, 120);
			}
			g.setFont(new Font("宋体", Font.BOLD, 30));
			g.drawString("主串:", 5, 58);
			for (int i = 0; i < kmpAlgorithm.getStr().length(); i++) {
				p = new PaintRect(String.valueOf(kmpAlgorithm.getStr().charAt(i)), i * 30 + 80, 30);
				p.drawRwct(g, i);
			}
			g.setFont(new Font("宋体", Font.BOLD, 30));
			g.drawString("字串:", 5, 150);
			for (int i = 0; i < kmpAlgorithm.getSubstr().length(); i++) {
				q = new PaintRect(String.valueOf(kmpAlgorithm.getSubstr().charAt(i)), star + i * 30 + 80, 120);
				q.drawRwct(g, i);
			}
			pIndicator.drawTextIndicator(g);
			pIndicator.drawPatternIndicator(g);
			//画next数组
			g.setFont(new Font("宋体", Font.BOLD, 22));
			g.drawString("next[]:", 5, 225);
			if (kmpAlgorithm.getListRow().get(k) < 18) {
				for (int i = 0; i < kmpAlgorithm.getSubstr().length(); i++) {
					if (i <= kmpAlgorithm.getListJ().get(k)) {
						q = new PaintRect((String.valueOf(kmpAlgorithm.getNext()[i])), i * 30 + 80, 200);
						q.drawRwct(g, i);
					} else {
						q = new PaintRect(" ", i * 30 + 80, 200);
						q.drawRwct(g, i);
					}
				}
			} else {
				for (int i = 0; i < kmpAlgorithm.getSubstr().length(); i++) {
					q = new PaintRect((String.valueOf(kmpAlgorithm.getNext()[i])), i * 30 + 80, 200);
					q.drawRwct(g, i);
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (kmpAlgorithm != null) {
			if (e.getActionCommand().equals("上一步")) {
				if (k > 0 && k < kmpAlgorithm.getListI().size() - 1) {
					k--;
					star = kmpAlgorithm.getListNow().get(k) * 30;
					pIndicator = new PaintIndicator(kmpAlgorithm.getListI().get(k) * 30 + 80, 30,
							kmpAlgorithm.getListJ().get(k) * 30 + star + 80, 120);
					repaint();
				}

			}
			if (e.getActionCommand().equals("下一步")) {
				if (k >= 0 && k < kmpAlgorithm.getListI().size() - 2) {
					k++;
					star = kmpAlgorithm.getListNow().get(k) * 30;
					pIndicator = new PaintIndicator(kmpAlgorithm.getListI().get(k) * 30 + 80, 30,
							kmpAlgorithm.getListJ().get(k) * 30 + star + 80, 120);
					repaint();
				}
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (k < kmpAlgorithm.getListI().size()) {
			star = kmpAlgorithm.getListNow().get(++k) * 30;
			pIndicator = new PaintIndicator(kmpAlgorithm.getListI().get(k) * 30 + 80, 30,
					kmpAlgorithm.getListJ().get(k) * 30 + 80 + star, 120);
			repaint();
		}
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getK() {
		return k;
	}
}
