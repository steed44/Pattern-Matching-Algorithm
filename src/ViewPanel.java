import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ViewPanel extends JTabbedPane {

	/**
	 * Create the panel.
	 */
	protected BFPanel bfPanel;
	protected KMPPanel kmpPanel;
	protected BMPanel bmPanel;

	public ViewPanel() {
		setTabPlacement(JTabbedPane.BOTTOM);

		bfPanel = new BFPanel();
		kmpPanel = new KMPPanel();
		bmPanel = new BMPanel();

		addTab("BF算法", null, bfPanel, null);
		addTab("KMP算法", null, kmpPanel, null);
		addTab("BM算法", null, bmPanel, null);
	}

}
