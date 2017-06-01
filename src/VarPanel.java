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
import ght.model.com.BMAlgorithm;
import ght.model.com.KMPAlgorithm;

public class VarPanel extends JPanel implements Runnable, ActionListener, ChangeListener {

	/**
	 * Create the panel.
	 */
	private BFAlgorithm bfAlgorithm = null;
	private KMPAlgorithm kmpAlgorithm = null;
	private BMAlgorithm bmAlgorithm = null;
	int charY = 20, charX = 5;
	int panelNum = 0;
	int k = 0,k1 = 0, k2 = 0;
	int wideth;

	/**
	 * 面板切换时，会重置，无法保存其他面板已经执行到的步骤，更改K可以实现
	 */
	public VarPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.WHITE);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		g.setColor(Color.BLACK);

		int m = 0;
		int a = 0;
		g.setColor(Color.BLACK);
		g.setFont(new Font("宋体", Font.ITALIC, 20));
		g.fillRect(580, 0, 1, 600);
		g.drawString("主串长度:", 585, charY);
		
		g.drawString("子串长度:", 585, charY + 22);
		g.drawString("匹配次数:", 585, charY + 44);
		g.drawString("匹配结果:", 585, charY + 66);
		
		if (bfAlgorithm != null) {
			g.drawString(String.valueOf(bfAlgorithm.getTextStrLength()), 680, charY);
			g.drawString(String.valueOf(bfAlgorithm.getPatternStrLength()), 680, charY+22);
			if(kmpAlgorithm.isTrue()){
				g.drawString("成功", 680, charY+66);
			}else{
				g.drawString("失败", 680, charY+66);
			}
			switch (panelNum) {
			case 0:
				g.setColor(Color.CYAN);
				if (k != 0) {
					if (k > 20) {
						m = k % 20 + (k / 20 - 1) * 20;
						g.fillRect(charX + 25 * 20 + 50, 0, 25, 600);
					} else {
						m = 0;
						g.fillRect(charX + 25 * k + 50, 0, 25, 600);
					}
				}
				g.setColor(Color.BLACK);
				for (; m < k; m++, a++) {
					g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
					g.drawString(String.valueOf(bfAlgorithm.getListI().get(m)), charX + 25 * a + 80, charY);
					g.drawString(String.valueOf(bfAlgorithm.getListCharI().get(m)), charX + 25 * a + 80, charY + 22);
					g.drawString(String.valueOf(bfAlgorithm.getListJ().get(m)), charX + 25 * a + 80, charY + 44);
					g.drawString(String.valueOf(bfAlgorithm.getListCharJ().get(m)), charX + 25 * a + 80, charY + 66);
				}
				g.drawString(String.valueOf(bfAlgorithm.getTimes()), 680, charY+44);
				break;
			case 1:
				g.setColor(Color.CYAN);
				if (k1 != 0) {
					if (k1 > 20) {
						m = k1 % 20 + (k1 / 20 - 1) * 20;
						g.fillRect(charX + 25 * 20 + 50, 0, 25, 600);
					} else {
						m = 0;
						g.fillRect(charX + 25 * k1 + 50, 0, 25, 600);
					}
				}
				g.setColor(Color.BLACK);
				for (; m < k1; m++, a++) {
					g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
					if (kmpAlgorithm.getListJ().get(m) >= 0) {
						g.drawString(String.valueOf(kmpAlgorithm.getListI().get(m)), charX + 25 * a + 80, charY);
						g.drawString(String.valueOf(kmpAlgorithm.getListCharI().get(m)), charX + 25 * a + 80,
								charY + 22);
						g.drawString(String.valueOf(kmpAlgorithm.getListJ().get(m)), charX + 25 * a + 80, charY + 44);
						g.drawString(String.valueOf(kmpAlgorithm.getListCharJ().get(m)), charX + 25 * a + 80,
								charY + 66);
						if(kmpAlgorithm.getListJ().get(m) == kmpAlgorithm.getNext().length){
							g.drawString(String.valueOf(kmpAlgorithm.getNext()[kmpAlgorithm.getListJ().get(m)-1]),
									charX + 25 * a + 80, charY + 88);
						}else{
							g.drawString(String.valueOf(kmpAlgorithm.getNext()[kmpAlgorithm.getListJ().get(m)]),
									charX + 25 * a + 80, charY + 88);
						}
					}
				}
				g.drawString(String.valueOf(kmpAlgorithm.getTimes()), 680, charY+44);
				break;
			case 2:
				g.setColor(Color.CYAN);
				if (k2 != 0) {
					if (k2 > 20) {
						m = k2 % 20 + (k2 / 20 - 1) * 20;
						g.fillRect(charX + 25 * 20 + 50, 0, 25, 600);
					} else {
						m = 0;
						g.fillRect(charX + 25 * k2 + 50, 0, 25, 600);
					}
				}
				g.setColor(Color.BLACK);
				for (; m < k2; m++, a++) {
					g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
					if (bmAlgorithm.getListI().get(m) >= 0) {
						g.drawString(String.valueOf(bmAlgorithm.getListI().get(m)), charX + 25 * a + 80, charY);
						g.drawString(String.valueOf(bmAlgorithm.getListCharI().get(m)), charX + 25 * a + 80,
								charY + 22);
					}
					if (bmAlgorithm.getListJ().get(m) >= 0) {
						g.drawString(String.valueOf(bmAlgorithm.getListJ().get(m)), charX + 25 * a + 80, charY + 44);
						g.drawString(String.valueOf(bmAlgorithm.getListCharJ().get(m)), charX + 25 * a + 80,
								charY + 66);
					}
					if (bmAlgorithm.getListN().get(m) >= 0) {
						g.drawString(String.valueOf(bmAlgorithm.getSuffix()[bmAlgorithm.getListN().get(m)]),
								charX + 25 * a + 80, charY + 88);
					}
					if (bmAlgorithm.getBmGsToListL().get(m) >= 0) {
						g.drawString(String.valueOf(bmAlgorithm.getBmGsToListL().get(m)), charX + 25 * a + 80,
								charY + 110);
					}
				}
				g.drawString(String.valueOf(bmAlgorithm.getTimes()), 680, charY+44);
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
			g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
			g.drawString("i", charX + 40, charY);
			g.drawString("charAt(i)", charX, charY + 22);
			g.drawString("j", charX + 40, charY + 44);
			g.drawString("charAt(j)", charX, charY + 66);
			g.drawString("suffix[n]", charX, charY + 88);
			g.drawString("bmGs[l]", charX, charY + 110);
			// setPreferredSize(new Dimension(getWidth(), 150));
			// setSize(getWidth(), 150); // 两句一起写才有效果，不知道为什么
			break;
		default:
			break;
		}

	}

	public void reset() {
		bfAlgorithm = BFAlgorithm.parseGson();
		kmpAlgorithm = KMPAlgorithm.parseGson();
		bmAlgorithm = BMAlgorithm.parseGson();
		k = 0;
		k1 = 0;
		k2 = 0;
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// if (bfAlgorithm != null) {
		// if (e.getActionCommand().equals("上一步")) {
		// if (k > 0 && k < bfAlgorithm.getListI().size() - 1) {
		// k--;
		// repaint();
		// }
		//
		// }
		// if (e.getActionCommand().equals("下一步")) {
		// if (k >= 0 && k < bfAlgorithm.getListI().size() - 2) {
		// k++;
		// repaint();
		// }
		//
		// }
		//
		// }
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
					if (k1 > 0 && k1 < kmpAlgorithm.getListI().size() - 1) {
						k1--;
						repaint();
					}
				}
				if (e.getActionCommand().equals("下一步")) {
					if (k1 >= 0 && k1 < kmpAlgorithm.getListI().size() - 2) {
						k1++;
						repaint();
					}
				}
				break;
			case 2:
				if (e.getActionCommand().equals("上一步")) {
					if (k2 > 0 && k2 < bmAlgorithm.getListJ().size() - 1) {
						k2--;
						repaint();
					}
				}
				if (e.getActionCommand().equals("下一步")) {
					if (k2 >= 0 && k2 < bmAlgorithm.getListJ().size() - 2) {
						k2++;
						repaint();
					}
				}
				break;
			default:
				break;
			}

		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		switch (panelNum) {
		case 0:
			k++;
			break;
		case 1:
			k1++;
			break;
		case 2:
			k2++;
			break;
		default:
			break;
		}
		repaint();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
		panelNum = tabbedPane.getSelectedIndex();
//		k = 0;
		repaint();
	}

}
