import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import java.awt.BorderLayout;

public class test4 implements ActionListener, ChangeListener {

	private JFrame frame;
	private MainDataView mainDataView;
	private ViewPanel viewPanel;
	private CodePanel codePanel;
	private VariablePanel variablePanel;
	private Timer timer = null;
	private int m = 1;
	private MenuBarTool menuBarTool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test4 window = new test4();
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
	public test4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("模式匹配辅助教学工具");
		// 添加菜单栏
		menuBarTool = new MenuBarTool();
		frame.getContentPane().add(menuBarTool, BorderLayout.NORTH);
		// 左右分栏
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setDividerSize(1);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		// 左边栏上下分栏
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.8);
		splitPane_1.setDividerSize(1);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		// 左上栏上下分栏
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setEnabled(false);
		splitPane_2.setDividerSize(0);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setLeftComponent(splitPane_2);
		// 添加主演示区
		viewPanel = new ViewPanel();
		splitPane_2.setRightComponent(viewPanel);
		// 添加数据区
		mainDataView = new MainDataView();
		splitPane_2.setLeftComponent(mainDataView);
		// 添加代码显示区
		codePanel = new CodePanel();
		splitPane.setRightComponent(codePanel);
		// 添加变量显示区
		variablePanel = new VariablePanel();
		splitPane_1.setRightComponent(variablePanel);

		// 添加监听事件
		viewPanel.bfPanel.controlBtnPanel.btnNewButton_3.addActionListener(codePanel);
		viewPanel.bfPanel.controlBtnPanel.btnNewButton.addActionListener(codePanel);
		viewPanel.bfPanel.controlBtnPanel.btnNewButton_1.addActionListener(this);
		viewPanel.bfPanel.controlBtnPanel.btnNewButton_2.addActionListener(this);
		viewPanel.bfPanel.controlBtnPanel.btnNewButton_3.addActionListener(this);
		viewPanel.bfPanel.controlBtnPanel.btnNewButton.addActionListener(this);
		viewPanel.bfPanel.controlBtnPanel.btnNewButton.addActionListener(variablePanel.panel);
		viewPanel.bfPanel.controlBtnPanel.btnNewButton_3.addActionListener(variablePanel.panel);
		viewPanel.addChangeListener(codePanel);
		viewPanel.addChangeListener(variablePanel.panel);

		mainDataView.btnNewButton.addActionListener(this);
		menuBarTool.sample_1.addMenuListener(new sample_1_ActionListener());
		menuBarTool.sample_2.addMenuListener(new sample_1_ActionListener());
		menuBarTool.sample_3.addMenuListener(new sample_1_ActionListener());

	}

	// 示例Jmenu的监听事件处理
	private class sample_1_ActionListener implements MenuListener {

		@Override
		public void menuCanceled(MenuEvent arg0) {
		}

		@Override
		public void menuDeselected(MenuEvent arg0) {
		}

		@Override
		public void menuSelected(MenuEvent arg0) {
			if (arg0.getSource().equals(menuBarTool.sample_1)) {
				mainDataView.textField.setText("aaaaaaaaaaab");
				mainDataView.textField_1.setText("aaab");
			}
			if (arg0.getSource().equals(menuBarTool.sample_2)) {
				mainDataView.textField.setText("abacbcadabacefsd");
				mainDataView.textField_1.setText("abace");
			}
			if (arg0.getSource().equals(menuBarTool.sample_3)) {
				mainDataView.textField.setText("四是四,十是十,十四是十四,四十是四十.");
				mainDataView.textField_1.setText("四十");
			}
		}
	}

	class MyTask extends TimerTask {
		Thread thread1;

		@Override
		public void run() {
			switch (codePanel.getPanelNum()) {
			case 0:
				if (viewPanel.bfPanel.k >= viewPanel.bfPanel.bfAlgorithm.getListI().size()) {
					timer.cancel();
					viewPanel.bfPanel.isStart = 0;
				} else {
					thread1 = new Thread(viewPanel.bfPanel);
				}

				break;
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}

			Thread thread2 = new Thread(codePanel);
			Thread thread3 = new Thread(variablePanel.panel);
			try {
				thread1.start();
				thread1.join();
				thread2.start();
				thread2.join();
				thread3.start();
				thread3.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("更新")) {
			if (viewPanel.bfPanel.isStart == 1) {
				timer.cancel();
				viewPanel.bfPanel.isStart = 0;
			}
			// 这里要添加一个异常检错,不然在数据框没有内容的时候点击更新会出错
			if (mainDataView.textField.getText().equals("") || mainDataView.textField_1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请输入字符串!");
			} else {
				mainDataView.reset();
				codePanel.reset();
				viewPanel.bfPanel.reset();
				variablePanel.panel.reset();
			}

		} else if (e.getActionCommand().equals("开始")) {

			switch (codePanel.getPanelNum()) {
			case 0:
				if (viewPanel.bfPanel.isStart == 0) {
					timer = new Timer();
					timer.schedule(new MyTask(), 0, 600);
					viewPanel.bfPanel.isStart = 1;
				}

				break;
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}
		} else {
			if (viewPanel.bfPanel.isStart == 1) {
				timer.cancel();
				viewPanel.bfPanel.isStart = 0;
			}

		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		timer.cancel();
		viewPanel.bfPanel.isStart = 0;
	}

}
