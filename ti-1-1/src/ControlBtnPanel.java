import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlBtnPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	protected JButton btnNewButton_3;
	protected JButton btnNewButton_2;
	protected JButton btnNewButton_1;
	protected JButton btnNewButton;
	
	public ControlBtnPanel() {
		setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnNewButton_3 = new JButton("上一步");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton_3);
		
		btnNewButton_2 = new JButton("开始");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("暂停");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(btnNewButton_1);
		
		btnNewButton = new JButton("下一步");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton);

	}

}
