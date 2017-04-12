import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuBarTool extends JMenuBar {

	public MenuBarTool() {
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar);
		
		JMenu menu = new JMenu("打开");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("开始");
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("示例");
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("编辑");
		menuBar.add(menu_2);
	}

}
