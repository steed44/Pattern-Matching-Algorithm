import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class test2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2 window = new test2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//添加菜单栏
		MenuBarTool menuBarTool = new MenuBarTool();
		menuBarTool.setBounds(0, 0, 784, 28);
		frame.getContentPane().add(menuBarTool);
		
		//添加主显示窗口
		ViewPanel viewPanel = new ViewPanel();
		viewPanel.setBounds(-2, 27, 622, 401);
		frame.getContentPane().add(viewPanel);
		
		//添加代码显示窗口
		CodePanel codePanel = new CodePanel();
		codePanel.setBounds(621, 27, 163, 534);
		frame.getContentPane().add(codePanel);
		
		//添加变量显示窗口
		VariablePanel variablePanel = new VariablePanel();
		variablePanel.setBounds(0, 427, 622, 134);
		frame.getContentPane().add(variablePanel);
	}

}
