import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ght.control.com.ConcreteBFObserver;
import ght.control.com.ConcreteBMObserver;
import ght.control.com.ConcreteKMPObserver;
import ght.control.com.ConcreteSubject;
import ght.control.com.GetData;
import ght.model.com.BFAlgorithm;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class MainDataView extends JPanel {
	protected JTextField textField;
	protected JTextField textField_1;
	protected JButton btnNewButton;
	private GetData getData;
	private ConcreteSubject concreteSubject;
	private ConcreteBFObserver concreteBFObserver;
	private ConcreteKMPObserver concreteKMPObserver;
	private ConcreteBMObserver concreteBMObserver;

	/**
	 * Create the panel.
	 */
	public MainDataView() {
		init();
		getData = new GetData();
		concreteSubject = new ConcreteSubject();
		concreteBFObserver = new ConcreteBFObserver();
		concreteKMPObserver = new ConcreteKMPObserver();
		concreteBMObserver = new ConcreteBMObserver();
		concreteSubject.addObserver(concreteBFObserver);
		concreteSubject.addObserver(concreteKMPObserver);
		concreteSubject.addObserver(concreteBMObserver);
	}

	public void init() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 40, 40, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel label = new JLabel("主串：");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);

		btnNewButton = new JButton("更新");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);

		JLabel label_1 = new JLabel("子串：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		add(label_1, gbc_label_1);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public void reset() {
		getData.setPatternStr(textField_1.getText());
		getData.setTextStr(textField.getText());
		System.out.println(textField_1.getText());
		concreteSubject.setGetData(getData);
	}

}
