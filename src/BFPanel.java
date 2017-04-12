import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.google.gson.Gson;
import com.paint.gjt.PaintIndicator;
import com.paint.gjt.PaintRect;

import ght.model.com.BFAlgorithm;

import java.awt.BorderLayout;

public class BFPanel extends JPanel implements Runnable, ActionListener {

	/**
	 * Create the panel.
	 */
	protected BFAlgorithm bfAlgorithm = null;
	protected PaintIndicator pIndicator = null;
	private PaintRect p, q;
	protected int star = 0, k = 0;
	protected Thread t = new Thread(this);
	protected ControlBtnPanel controlBtnPanel;
	protected int isStart = 0;

	public BFPanel() {

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

	//复位函数
	public void reset() {
		bfAlgorithm = BFAlgorithm.parseGson();
		pIndicator = null;
		star = 0;
		k = 0;
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (bfAlgorithm != null) {
			if (pIndicator == null) {
				pIndicator = new PaintIndicator(0, 30, 0, 90);
			}

			for (int i = 0; i < bfAlgorithm.getTextStrLength(); i++) {
				p = new PaintRect(bfAlgorithm.getTextStr().charAt(i), i * 30, 30);
				p.drawRwct(g);
			}
			for (int i = 0; i < bfAlgorithm.getPatternStrLength(); i++) {
				q = new PaintRect(bfAlgorithm.getPatternStr().charAt(i), star + i * 30, 90);
				q.drawRwct(g);
			}
			pIndicator.drawTextIndicator(g);
			pIndicator.drawPatternIndicator(g);
		}
	}

	public void runStart() {
		++k;
		star = bfAlgorithm.getListNow().get(k) * 30;
		pIndicator = new PaintIndicator(bfAlgorithm.getListI().get(k) * 30, 30,
				bfAlgorithm.getListJ().get(k) * 30 + star, 90);
		System.out.println("bf1");
		repaint();
	}

	@Override
	public void run() {

		star = bfAlgorithm.getListNow().get(++k) * 30;
		pIndicator = new PaintIndicator(bfAlgorithm.getListI().get(k) * 30, 30,
				bfAlgorithm.getListJ().get(k) * 30 + star, 90);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (bfAlgorithm != null) {
			if (e.getActionCommand().equals("上一步")) {
				if (k > 0 && k < bfAlgorithm.getListI().size() - 1) {
					k--;
					star = bfAlgorithm.getListNow().get(k) * 30;
					pIndicator = new PaintIndicator(bfAlgorithm.getListI().get(k) * 30, 30,
							bfAlgorithm.getListJ().get(k) * 30 + star, 90);
					repaint();
				}

			}
			if (e.getActionCommand().equals("下一步")) {
				if (k >= 0 && k < bfAlgorithm.getListI().size() - 2) {
					k++;
					star = bfAlgorithm.getListNow().get(k) * 30;
					pIndicator = new PaintIndicator(bfAlgorithm.getListI().get(k) * 30, 30,
							bfAlgorithm.getListJ().get(k) * 30 + star, 90);
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