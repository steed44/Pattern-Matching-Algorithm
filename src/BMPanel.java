import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.paint.ght.PaintIndicator;
import com.paint.ght.PaintRect;

import ght.model.com.BMAlgorithm;

public class BMPanel extends JPanel implements Runnable, ActionListener {

	/**
	 * Create the panel.
	 */
	protected BMAlgorithm bmAlgorithm = null;
	protected PaintIndicator pIndicator = null;
	private PaintRect p, q;
	protected int star = 0, k = 0;
	protected Thread t = new Thread(this);
	protected ControlBtnPanel controlBtnPanel;
	protected int isStart = 0;
	private int BmGsNow = -1;

	public BMPanel() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.WHITE);
		controlBtnPanel = new ControlBtnPanel();
		add(controlBtnPanel, BorderLayout.SOUTH);

		controlBtnPanel.btnNewButton.addActionListener(this);
		controlBtnPanel.btnNewButton_3.addActionListener(this);
		controlBtnPanel.btnNewButton.setActionCommand("下一步");
		controlBtnPanel.btnNewButton_1.setActionCommand("暂停");
		controlBtnPanel.btnNewButton_2.setActionCommand("开始");
		controlBtnPanel.btnNewButton_3.setActionCommand("上一步");
	}

	// 复位函数
	public void reset() {
		bmAlgorithm = BMAlgorithm.parseGson();
		pIndicator = null;
		star = 0;
		k = 0;
		BmGsNow = -1;
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (bmAlgorithm != null) {
			if (pIndicator == null) {
				pIndicator = new PaintIndicator(80, 30, 80, 120);
			}
			g.setFont(new Font("宋体", Font.BOLD, 30));
			g.drawString("主串:", 5, 58);
			for (int i = 0; i < bmAlgorithm.gettLength(); i++) {
				p = new PaintRect(String.valueOf(bmAlgorithm.getTextStr().charAt(i)), i * 30 + 80, 30);
				p.drawRwct(g, i);
			}
			g.setFont(new Font("宋体", Font.BOLD, 30));
			g.drawString("字串:", 5, 150);
			for (int i = 0; i < bmAlgorithm.getpLength(); i++) {
				q = new PaintRect(String.valueOf(bmAlgorithm.getPatternStr().charAt(i)), star + i * 30 + 80, 120);
				q.drawRwct(g, i);
			}
			pIndicator.drawIndicatorX(g, "j");
			pIndicator.drawIndicatorX(g, "i");
			// 画bmBc数组（坏字符）
			g.setFont(new Font("宋体", Font.BOLD, 22));
			g.drawString("bmBc[]:", 5, 230);
			if (bmAlgorithm.getListRow().get(k) < 3 || bmAlgorithm.getListRow().get(k) > 18) {
				for (int i = 0; i < bmAlgorithm.getBmBc().size(); i++) {
					if (i <= bmAlgorithm.getListM().get(k)) {
						q = new PaintRect((String.valueOf(bmAlgorithm.getMapStr().get(i))), i * 30 + 80, 190);
						q.drawRwctBc(g);
						q = new PaintRect((String.valueOf(bmAlgorithm.getMapInt().get(i))), i * 30 + 80, 220);
						q.drawRwctBc(g);
					} else {
						q = new PaintRect(" ", i * 30 + 80, 190);
						q.drawRwctBc(g);
						q = new PaintRect(" ", i * 30 + 80, 220);
						q.drawRwctBc(g);
					}
				}
			} else {
				for (int i = 0; i < bmAlgorithm.getBmBc().size(); i++) {
					q = new PaintRect((String.valueOf(bmAlgorithm.getMapStr().get(i))), i * 30 + 80, 190);
					q.drawRwctBc(g);
					q = new PaintRect((String.valueOf(bmAlgorithm.getMapInt().get(i))), i * 30 + 80, 220);
					q.drawRwctBc(g);
				}
			}
			// 画suffix数组
			g.setFont(new Font("宋体", Font.BOLD, 22));
			g.drawString("suffix[]:", 5, 300);
			if (bmAlgorithm.getListRow().get(k) < 4
					|| (bmAlgorithm.getListRow().get(k) > 18 && bmAlgorithm.getListRow().get(k) < 40)) {
				for (int i = bmAlgorithm.getpLength() - 1; i >= 0; i--) {
					if (i >= bmAlgorithm.getListN().get(k) && bmAlgorithm.getListN().get(k) >= 0) {
						q = new PaintRect((String.valueOf(bmAlgorithm.getSuffix()[i])), i * 30 + 97, 270);
						q.drawRwct(g, i);
					} else {
						q = new PaintRect(" ", i * 30 + 97, 270);
						q.drawRwct(g, i);
					}
				}
			} else {
				for (int i = 0; i < bmAlgorithm.getSuffix().length; i++) {
					q = new PaintRect((String.valueOf(bmAlgorithm.getSuffix()[i])), i * 30 + 97, 270);
					q.drawRwct(g, i);
				}
			}

			// 画bmGs数组（好字符）
			g.setFont(new Font("宋体", Font.BOLD, 22));
			g.drawString("bmGs[]:", 5, 375);
			if (bmAlgorithm.getListRow().get(k) == 41 || bmAlgorithm.getListRow().get(k) == 48
					|| bmAlgorithm.getListRow().get(k) == 54) {
				BmGsNow++;
			}
			for (int i = 0; i < bmAlgorithm.getBmGs().length; i++) {
				if (BmGsNow != -1 && bmAlgorithm.getBmGss().get(BmGsNow * bmAlgorithm.getpLength() + i) != -1) {
					q = new PaintRect(
							(String.valueOf(bmAlgorithm.getBmGss().get(BmGsNow * bmAlgorithm.getpLength() + i))),
							i * 30 + 97, 345);
					q.drawRwct(g, i);
				} else {
					q = new PaintRect(" ", i * 30 + 97, 345);
					q.drawRwct(g, i);
				}
			}
		}
	}

	@Override
	public void run() {
		if (k < bmAlgorithm.getListI().size()) {
			star = bmAlgorithm.getListNow().get(++k) * 30;
			pIndicator = new PaintIndicator(bmAlgorithm.getListJ().get(k) * 30 + 80, 30,
					bmAlgorithm.getListI().get(k) * 30 + 80 + star, 120);
			repaint();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (bmAlgorithm != null) {
			if (e.getActionCommand().equals("上一步")) {
				if (k > 0 && k < bmAlgorithm.getListJ().size() - 1) {
					k--;
					star = bmAlgorithm.getListNow().get(k) * 30;
					pIndicator = new PaintIndicator(bmAlgorithm.getListJ().get(k) * 30 + 80, 30,
							bmAlgorithm.getListI().get(k) * 30 + 80 + star, 120);
					if (bmAlgorithm.getListRow().get(k) == 41 || bmAlgorithm.getListRow().get(k) == 48
							|| bmAlgorithm.getListRow().get(k) == 54) {
						BmGsNow -= 2;
					}
					repaint();
				}

			}
			if (e.getActionCommand().equals("下一步")) {
				if (k >= 0 && k < bmAlgorithm.getListJ().size() - 2) {
					k++;
					star = bmAlgorithm.getListNow().get(k) * 30;
					pIndicator = new PaintIndicator(bmAlgorithm.getListJ().get(k) * 30 + 80, 30,
							bmAlgorithm.getListI().get(k) * 30 + 80 + star, 120);
					repaint();
				}
			}
		}
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getK() {
		return k;
	}
}
