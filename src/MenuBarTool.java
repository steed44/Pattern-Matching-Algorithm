import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MenuBarTool extends JMenuBar {

	private JMenuBar menuBar;
	protected JMenu check;
	protected JMenuItem BF_Item, KMP_Item, BM_Item;
	protected JCheckBoxMenuItem speed1, speed2, speed3, speed4, speed5;
	protected int speedX = 500,selectX = 2;
	protected JMenu sample_1, sample_2, sample_3;
	protected JMenuItem sample_1_1, sample_1_2;
	protected JMenuItem sample_2_1, sample_2_2;
	protected JMenuItem sample_3_1, sample_3_2;
	protected JMenu sample, speed, help;

	public MenuBarTool() {

		menuBar = new JMenuBar();
		add(menuBar);

		// 添加查看菜单
		check = new JMenu("查看");
		menuBar.add(check);
		BF_Item = new JMenuItem("BF算法");
		check.add(BF_Item);
		KMP_Item = new JMenuItem("KMP算法");
		check.add(KMP_Item);
		BM_Item = new JMenuItem("BM算法");
		check.add(BM_Item);

		// 添加示例菜单,以及菜单下的子菜单
		sample = new JMenu("示例");
		menuBar.add(sample);
		sample_1 = new JMenu("1");
		sample_1.setActionCommand("1");
		sample_2 = new JMenu("2");
		sample_2.setActionCommand("2");
		sample_3 = new JMenu("3");
		sample_3.setActionCommand("3");
		sample.add(sample_1);
		sample_1_1 = new JMenuItem("主串:aaaaaaaaaaab");
		sample_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		sample_1_2 = new JMenuItem("字串:aaab");
		sample_1_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		sample_1.add(sample_1_1);
		sample_1.add(sample_1_2);
		sample_1_1.setEnabled(false);
		sample_1_2.setEnabled(false);

		sample.add(sample_2);
		sample_2_1 = new JMenuItem("主串:abacbcadabacefsd");
		sample_2_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		sample_2_2 = new JMenuItem("字串:abace");
		sample_2_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		sample_2.add(sample_2_1);
		sample_2.add(sample_2_2);
		sample_2_1.setEnabled(false);
		sample_2_2.setEnabled(false);

		sample.add(sample_3);
		sample_3_1 = new JMenuItem("主串:四是四,十是十,十四是十四,四十是四十.");
		sample_3_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		sample_3_2 = new JMenuItem("字串:四十");
		sample_3_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		sample_3.add(sample_3_1);
		sample_3.add(sample_3_2);
		sample_3_1.setEnabled(false);
		sample_3_2.setEnabled(false);

		// 添加变速菜单
		speed = new JMenu("调速");
		menuBar.add(speed);
		speed1 = new JCheckBoxMenuItem("0.2s");
		speed.add(speed1);
		speed2 = new JCheckBoxMenuItem("0.5s");
		speed2.setSelected(true);
		speed.add(speed2);
		speed3 = new JCheckBoxMenuItem("1.0s");
		speed.add(speed3);
		speed4 = new JCheckBoxMenuItem("1.5s");
		speed.add(speed4);
		speed5 = new JCheckBoxMenuItem("2.0s");
		speed.add(speed5);

		// 添加编辑菜单
		help = new JMenu("帮助");
		menuBar.add(help);
		
		dealActionListener();

	}
	/**
	 * 使菜单栏成为单选框
	 */
	public void dealSelected(){
		switch(selectX){
		case 1:
			speed2.setSelected(false);
			speed3.setSelected(false);
			speed4.setSelected(false);
			speed5.setSelected(false);
			break;
		case 2:
			speed1.setSelected(false);
			speed3.setSelected(false);
			speed4.setSelected(false);
			speed5.setSelected(false);
			break;
		case 3:
			speed2.setSelected(false);
			speed1.setSelected(false);
			speed4.setSelected(false);
			speed5.setSelected(false);
			break;
		case 4:
			speed2.setSelected(false);
			speed3.setSelected(false);
			speed1.setSelected(false);
			speed5.setSelected(false);
			break;
		case 5:
			speed2.setSelected(false);
			speed3.setSelected(false);
			speed4.setSelected(false);
			speed1.setSelected(false);
			break;
		default:
			break;
		}
		
	}
	public void dealActionListener(){
		BF_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File("Introduction/BF算法详解.docx"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		KMP_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File("Introduction/kmp算法详解.docx"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		BM_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File("Introduction/BM算法详解.docx"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		speed1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speedX = 200;
				selectX = 1;
				dealSelected();
			}
		});
		speed2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speedX = 500;
				selectX = 2;
				dealSelected();
			}
		});
		speed3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speedX = 1000;
				selectX = 3;
				dealSelected();
			}
		});
		speed4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speedX = 1500;
				selectX = 4;
				dealSelected();
			}
		});
		speed5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speedX = 2000;
				selectX = 5;
				dealSelected();
			}
		});
	}
}
