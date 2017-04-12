import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarTool extends JMenuBar {

	private JMenuBar menuBar;
	protected JMenu check;
	protected JMenuItem BF_Item, KMP_Item, BM_Item;
	protected JMenu sample_1, sample_2, sample_3;
	protected JMenuItem sample_1_1, sample_1_2;
	protected JMenuItem sample_2_1, sample_2_2;
	protected JMenuItem sample_3_1, sample_3_2;
	protected JMenu sample, edit, help;

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

		// 添加编辑菜单
		edit = new JMenu("编辑");
		menuBar.add(edit);

		// 添加编辑菜单
		help = new JMenu("帮助");
		menuBar.add(help);

		BF_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		KMP_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		BM_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
