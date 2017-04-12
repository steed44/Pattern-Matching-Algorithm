import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.paint.gjt.PaintIndicator;

import ght.model.com.BF;
import ght.model.com.BFAlgorithm;
import java.awt.BorderLayout;

public class CodePanel extends JPanel implements Runnable, ActionListener, ChangeListener {

	/**
	 * Create the panel.
	 */
	private BF bf = new BF();
	private BFAlgorithm bfAlgorithm = null;
	private int panelNum = 0;
	private int k = 0;
	protected Thread thread = new Thread(this);

	public CodePanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.WHITE);
	}

	public void reset() {
		bfAlgorithm = BFAlgorithm.parseGson();
		k = 0;
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.CYAN);
		if (bfAlgorithm != null) {
			switch (panelNum) {
			case 0:
				g.fillRect(2, bfAlgorithm.getListRow().get(k) * 20 - 15, 1000, 20);
				g.setFont(new Font("TimesRoman", Font.ITALIC, 18));
				g.setColor(Color.BLACK);
				for (int i = 0; i < bf.bfStrings.length; i++) {
					g.drawString(bf.bfStrings[i], 5, 20 + i * 20);
				}
				break;
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}

		}
		else{
			switch (panelNum) {
			case 0:
				g.fillRect(2, 20 - 15, 1000, 20);
				g.setFont(new Font("TimesRoman", Font.ITALIC, 18));
				g.setColor(Color.BLACK);
				for (int i = 0; i < bf.bfStrings.length; i++) {
					g.drawString(bf.bfStrings[i], 5, 20 + i * 20);
				}
				break;
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {


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

	@Override
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
		repaint();
		// System.out.println(panelNum);
	}

}
