import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.border.*;
/*import com.symantec.itools.javax.swing.JToolBarSeparator;
import com.symantec.itools.javax.swing.icons.ImageIcon;
import com.symantec.itools.javax.swing.models.StringListModel;
import com.symantec.itools.javax.swing.models.StringTreeModel;*/

/**
 * A basic JFC 1.1 based application.
 */
public class PEOS_GUI extends javax.swing.JFrame
{
    PEOS_Interface  _PEOSInterface;
    String				currentProc = new String();
	boolean				bAutoRun;
	private TreePath	curTreeSelection;
	private int			curTableSelection;

	Object[] tableColNames = {"Sts", "Process ID", "Task ID", "PML Script"};
	public PEOS_GUI()
	{
		_PEOSInterface = null;
		bAutoRun = false;
		curTreeSelection = null;
		curTableSelection = 0;

		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("PEOS Perform Tool");
		setJMenuBar(JMenuBar1);
		getContentPane().setLayout(null);
		setSize(745,544);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(JPanel1);
		JPanel1.setBounds(0,0,744,540);
		JPanel2.setBorder(titledBorder1);
		JPanel2.setLayout(null);
		JPanel1.add(JPanel2);
		JPanel2.setFont(new Font("Dialog", Font.BOLD, 12));
		JPanel2.setBounds(12,12,300,288);
		JCreateBotton.setText("Create");
		JCreateBotton.setActionCommand("Create");
		JCreateBotton.setMnemonic((int)'C');
		JPanel2.add(JCreateBotton);
		JCreateBotton.setBounds(108,252,84,25);
		JScrollPane1.setOpaque(true);
		JPanel2.add(JScrollPane1);
		JScrollPane1.setBounds(12,24,276,216);
		JList1.setModel(stringListModel);
		JScrollPane1.getViewport().add(JList1);
		JList1.setBounds(0,0,273,213);
		JPanel3.setBorder(titledBorder2);
		JPanel3.setLayout(null);
		JPanel1.add(JPanel3);
		JPanel3.setBounds(324,12,408,516);
		JPanel3.add(JScrollPane3);
		JScrollPane3.getViewport().setFont(new Font("Dialog", Font.PLAIN, 12));
		JScrollPane3.setBounds(12,24,384,306);
		JTree1.setModel(stringTreeModel1);
		JScrollPane3.getViewport().add(JTree1);
		JTree1.setBounds(0,0,381,303);
		JPanel3.add(JScrollPane4);
		JScrollPane4.setBounds(23,48,337,60);
		JRunButton.setText("Run");
		JRunButton.setActionCommand("Run");
		JRunButton.setMnemonic((int)'R');
		JPanel3.add(JRunButton);
		JRunButton.setBounds(300,348,57,25);
		JPanel3.add(JTabbedPane1);
		JTabbedPane1.setBounds(12,360,384,144);
		JTabbedPane1.add(JScrollPane5);
		JScrollPane5.setBounds(2,27,379,114);
		JTextArea1.setEditable(false);
		JScrollPane5.getViewport().add(JTextArea1);
		JTextArea1.setBounds(0,0,376,111);
		JTextArea1.setVisible(false);
//		JTabbedPane1.setSelectedComponent(JTextArea1);
//		JTabbedPane1.setSelectedIndex(0);
		JTabbedPane1.setTitleAt(0,"");
		JPanel4.setBorder(titledBorder3);
		JPanel4.setLayout(null);
		JPanel1.add(JPanel4);
		JPanel4.setBounds(12,312,300,216);
		JSuspendButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		JSuspendButton.setText("Suspend");
		JSuspendButton.setActionCommand("Suspend");
		JSuspendButton.setMnemonic((int)'S');
		JPanel4.add(JSuspendButton);
		JSuspendButton.setBounds(12,180,84,25);
		JScrollPane2.setOpaque(true);
		JPanel4.add(JScrollPane2);
		JScrollPane2.setBounds(12,24,276,144);
		JScrollPane2.getViewport().add(JTable1);
		JTable1.setBounds(0,0,273,0);
		JResumeButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		JResumeButton.setText("Resume");
		JResumeButton.setActionCommand("Resume");
		JResumeButton.setMnemonic((int)'R');
		JResumeButton.setEnabled(false);
		JPanel4.add(JResumeButton);
		JResumeButton.setBounds(108,180,84,25);
		JDoneButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		JDoneButton.setText("Done");
		JDoneButton.setActionCommand("Done");
		JDoneButton.setMnemonic((int)'D');
		JPanel4.add(JDoneButton);
		JDoneButton.setBounds(204,180,84,25);
		//$$ JMenuBar1.move(168,552);
		connectionMenu.setText("Connection");
		connectionMenu.setActionCommand("File");
		connectionMenu.setMnemonic((int)'C');
		JMenuBar1.add(connectionMenu);
		connectItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.Event.CTRL_MASK));
		connectItem.setText("Connect");
		connectItem.setActionCommand("Connect");
		connectItem.setMnemonic((int)'C');
		connectionMenu.add(connectItem);
		disconnectItem.setEnabled(false);
		disconnectItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		disconnectItem.setText("Disconnect");
		disconnectItem.setActionCommand("Diconnect");
		disconnectItem.setMnemonic((int)'D');
		connectionMenu.add(disconnectItem);
		connectionMenu.add(JSeparator1);
		JMenuItem1.setEnabled(false);
		JMenuItem1.setText("Logout");
		JMenuItem1.setActionCommand("Logout");
		JMenuItem1.setMnemonic((int)'L');
		connectionMenu.add(JMenuItem1);
		connectionMenu.add(JSeparator3);
		exitItem.setText("Exit");
		exitItem.setActionCommand("Exit");
		exitItem.setMnemonic((int)'X');
		connectionMenu.add(exitItem);
		optionMenu.setText("Running Mode");
		optionMenu.setActionCommand("Edit");
		optionMenu.setMnemonic((int)'R');
		JMenuBar1.add(optionMenu);
		JRadioButtonMenuItem1.setText("Run until need attention");
		JRadioButtonMenuItem1.setActionCommand("Run until need attention");
		JRadioButtonMenuItem1.setMnemonic((int)'S');
		optionMenu.add(JRadioButtonMenuItem1);
		JRadioButtonMenuItem2.setText("Signle step");
		JRadioButtonMenuItem2.setActionCommand("Signle step");
		JRadioButtonMenuItem2.setMnemonic((int)'I');
		optionMenu.add(JRadioButtonMenuItem2);
		JCheckBoxMenuItem1.setText("Strict error checking");
		JCheckBoxMenuItem1.setActionCommand("Diagnosis On");
		optionMenu.add(JCheckBoxMenuItem1);
		helpMenu.setText("Help");
		helpMenu.setActionCommand("Help");
		helpMenu.setMnemonic((int)'H');
		JMenuBar1.add(helpMenu);
		aboutItem.setText("About...");
		aboutItem.setActionCommand("About...");
		aboutItem.setMnemonic((int)'A');
		helpMenu.add(aboutItem);
		//$$ stringListModel.move(0,552);
		//$$ stringTreeModel1.move(48,552);
		//}}

		//{{INIT_MENUS
		//}}

		//{{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		connectItem.addActionListener(lSymAction);
		disconnectItem.addActionListener(lSymAction);
		exitItem.addActionListener(lSymAction);
		aboutItem.addActionListener(lSymAction);
		JCreateBotton.addActionListener(lSymAction);
		JDoneButton.addActionListener(lSymAction);
		JSuspendButton.addActionListener(lSymAction);
		JResumeButton.addActionListener(lSymAction);
		JRunButton.addActionListener(lSymAction);
		JRadioButtonMenuItem1.addActionListener(lSymAction);
		JRadioButtonMenuItem2.addActionListener(lSymAction);
		JMenuItem1.addActionListener(lSymAction);
		SymFocus aSymFocus = new SymFocus();
		JTree1.addFocusListener(aSymFocus);
		JTable1.addFocusListener(aSymFocus);
		//}}

        JRadioButtonMenuItem1.setSelected(bAutoRun);
        JRadioButtonMenuItem2.setSelected(!bAutoRun);
    
		JTable1.setModel(tableModel1);
		for (int iCol = 0; iCol < tableColNames.length; iCol++)
			tableModel1.addColumn(tableColNames[iCol]);
		TableColumn sts = JTable1.getColumn(tableColNames[0]);
		TableCellRenderer renderer = sts.getHeaderRenderer();
		Component comp = renderer.getTableCellRendererComponent(
						  			JTable1, sts.getHeaderValue(), 
						  			false, false, 0, 0);
		int stsWidth = comp.getPreferredSize().width;
		sts.setMinWidth(stsWidth);
		sts.setMaxWidth(stsWidth);
		JTable1.sizeColumnsToFit(0);

	    JTree1.setRootVisible(false);
	    JTree1.setShowsRootHandles(false);
//    	JTree1.setClientProperty("JTree.lineStyle", "Angled");
//	    JTree1.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

//		JTable1.setColumnSelectionAllowed(false);
//		JTable1.setCellSelectionAllowed(false);
//		JTable1.setRowSelectionAllowed(true);
		JTable1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		init();
	}

    /**
     * Creates a new instance of PEOS_GUI with the given title.
     * @param sTitle the title for the new frame.
     * @see #PEOS_GUI()
     */
	public PEOS_GUI(String sTitle)
	{
		this();
		setTitle(sTitle);
	}
	
	/**
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new PEOS_GUI and makes it visible.
	 */
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    /*
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    */

			//Create a new instance of our application's frame, and make it visible.
			PEOS_GUI peos = new PEOS_GUI();
			peos.setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

    /**
     * Notifies this component that it has been added to a container
     * This method should be called by <code>Container.add</code>, and 
     * not by user code directly.
     * Overridden here to adjust the size of the frame if needed.
     * @see java.awt.Container#removeNotify
     */
	public void addNotify()
	{
		// Record the size of the window prior to calling parents addNotify.
		Dimension size = getSize();
		
		super.addNotify();
		
		if (frameSizeAdjusted)
			return;
		frameSizeAdjusted = true;
		
		// Adjust size of frame according to the insets and menu bar
		javax.swing.JMenuBar menuBar = getRootPane().getJMenuBar();
		int menuBarHeight = 0;
		if (menuBar != null)
		    menuBarHeight = menuBar.getPreferredSize().height;
		Insets insets = getInsets();
		setSize(insets.left + insets.right + size.width, insets.top + insets.bottom + size.height + menuBarHeight);
	}

	// Used by addNotify
	boolean frameSizeAdjusted = false;

	//{{DECLARE_CONTROLS
	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JPanel JPanel2 = new javax.swing.JPanel();
	javax.swing.JButton JCreateBotton = new javax.swing.JButton();
	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JList JList1 = new javax.swing.JList();
	javax.swing.JPanel JPanel3 = new javax.swing.JPanel();
	javax.swing.JScrollPane JScrollPane3 = new javax.swing.JScrollPane();
	javax.swing.JTree JTree1 = new javax.swing.JTree();
	javax.swing.JScrollPane JScrollPane4 = new javax.swing.JScrollPane();
	javax.swing.JButton JRunButton = new javax.swing.JButton();
	javax.swing.JTabbedPane JTabbedPane1 = new javax.swing.JTabbedPane();
	javax.swing.JScrollPane JScrollPane5 = new javax.swing.JScrollPane();
	javax.swing.JTextArea JTextArea1 = new javax.swing.JTextArea();
	javax.swing.JPanel JPanel4 = new javax.swing.JPanel();
	javax.swing.JButton JSuspendButton = new javax.swing.JButton();
	javax.swing.JScrollPane JScrollPane2 = new javax.swing.JScrollPane();
	javax.swing.JTable JTable1 = new javax.swing.JTable();
	javax.swing.JButton JResumeButton = new javax.swing.JButton();
	javax.swing.JButton JDoneButton = new javax.swing.JButton();
	javax.swing.JMenuBar JMenuBar1 = new javax.swing.JMenuBar();
	javax.swing.JMenu connectionMenu = new javax.swing.JMenu();
	javax.swing.JMenuItem connectItem = new javax.swing.JMenuItem();
	javax.swing.JMenuItem disconnectItem = new javax.swing.JMenuItem();
	javax.swing.JSeparator JSeparator1 = new javax.swing.JSeparator();
	javax.swing.JMenuItem JMenuItem1 = new javax.swing.JMenuItem();
	javax.swing.JSeparator JSeparator3 = new javax.swing.JSeparator();
	javax.swing.JMenuItem exitItem = new javax.swing.JMenuItem();
	javax.swing.JMenu optionMenu = new javax.swing.JMenu();
	javax.swing.JRadioButtonMenuItem JRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
	javax.swing.JRadioButtonMenuItem JRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
	javax.swing.JCheckBoxMenuItem JCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
	javax.swing.JMenu helpMenu = new javax.swing.JMenu();
	javax.swing.JMenuItem aboutItem = new javax.swing.JMenuItem();
	javax.swing.border.TitledBorder titledBorder1 = new javax.swing.border.TitledBorder("List of Models");
	javax.swing.border.TitledBorder titledBorder2 = new javax.swing.border.TitledBorder("List of non-Running Processes");
	javax.swing.border.TitledBorder titledBorder3 = new javax.swing.border.TitledBorder("List of Running Processes");
	//}}

	StringTreeModel stringTreeModel1 = new StringTreeModel();
	StringListModel stringListModel = new StringListModel();
	javax.swing.table.DefaultTableModel tableModel1 = new javax.swing.table.DefaultTableModel();
	
	//{{DECLARE_MENUS
	//}}

	//
	void init()
	{
	    try
	    {
		    if (invokeLogin())
		    {
		        Hashtable RetVal = _PEOSInterface.getProcState();
		        parseRetValHashtable(RetVal);
		        repaint();
		    }
	        setAccesses();
		}
		catch (Exception e)
		{
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Initialization",JOptionPane.ERROR_MESSAGE);
		}
	}
		
    boolean invokeLogin()
    {
        boolean bRet = false;
        try
        {
		    JLoginDialog JLoginDialog1 = new JLoginDialog(this);
		    JLoginDialog1.setModal(true);
		    JLoginDialog1.show();
		    if (!JLoginDialog1._bCancel)
		    {
                _PEOSInterface.setDiagnosis(false);		// depend on the server
                Vector modelList = _PEOSInterface.getModelList();
			    fillModelList(modelList);
				disconnectItem.setEnabled(true);
 				connectItem.setEnabled(false);
 			    JMenuItem1.setEnabled(true);
 				
 				bRet = true;
		    }
		}
		catch (Exception e)
		{
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "While Login",JOptionPane.ERROR_MESSAGE);
		    bRet = false;    
		}
		finally
		{
		    return bRet;
		}
    }
   
   void setAccesses()
   {
        boolean bEnable = (_PEOSInterface != null);
        optionMenu.setEnabled(bEnable);
   }
   
	void exitApplication()
	{
		try {
	    	// Beep
	    	Toolkit.getDefaultToolkit().beep();
	    	// Show a confirmation dialog
	    	int reply = JOptionPane.showConfirmDialog(this, 
	    	                                          "Do you really want to exit?", 
	    	                                          "PEOS Perform Tool - Exit" , 
	    	                                          JOptionPane.YES_NO_OPTION, 
	    	                                          JOptionPane.QUESTION_MESSAGE);
			// If the confirmation was affirmative, handle exiting.
			if (reply == JOptionPane.YES_OPTION)
			{
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
			}
		} catch (Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "While exit",JOptionPane.ERROR_MESSAGE);
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == PEOS_GUI.this)
				PEOS_GUI_windowClosing(event);
		}
	}

	void PEOS_GUI_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		PEOS_GUI_windowClosing_Interaction1(event);
	}

	void PEOS_GUI_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			_PEOSInterface.disconnect();
		    
			this.exitApplication();
		} catch (Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Close window",JOptionPane.ERROR_MESSAGE);
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == disconnectItem)
				disconnectItem_actionPerformed(event);
			if (object == exitItem)
				exitItem_actionPerformed(event);
			else if (object == aboutItem)
				aboutItem_actionPerformed(event);
			else if (object == JCreateBotton)
				JCreateBotton_actionPerformed(event);
			else if (object == JDoneButton)
				JDoneButton_actionPerformed(event);
			else if (object == JSuspendButton)
				JSuspendButton_actionPerformed(event);
			else if (object == JResumeButton)
				JResumeButton_actionPerformed(event);
			else if (object == JRunButton)
				JRunButton_actionPerformed(event);
			else if (object == connectItem)
				connectItem_actionPerformed(event);
			else if (object == JRadioButtonMenuItem1)
				JRadioButtonMenuItem1_actionPerformed(event);
			else if (object == JRadioButtonMenuItem2)
				JRadioButtonMenuItem2_actionPerformed(event);
			else if (object == JMenuItem1)
				JMenuItem1_actionPerformed(event);
			
		}
	}

	void connectItem_actionPerformed(java.awt.event.ActionEvent event)
	{
		connectItem_actionPerformed_Interaction1(event);
	}

	void connectItem_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
		try {
			// JLoginDialog Create with owner and show as modal
			{
			    if (invokeLogin())
			    {
				    JList1.updateUI();
				    Hashtable RetVal = _PEOSInterface.getProcState();
				    displayLists(RetVal);
                }
                setAccesses();
			}
		} catch (Exception e) {
				String msg = "Get exception: " + e;
				JOptionPane.showMessageDialog(this, msg, "Connect",JOptionPane.ERROR_MESSAGE);
		}
	}

	void disconnectItem_actionPerformed(java.awt.event.ActionEvent event)
	{
		disconnectItem_actionPerformed_Interaction1(event);
		// to do: code goes here.
	}

	void disconnectItem_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
		try 
		{
			_PEOSInterface.disconnect();
			_PEOSInterface = null;
            setAccesses();
            disconnectItem.setEnabled(false);
 			connectItem.setEnabled(true);
 			JMenuItem1.setEnabled(false);

			fillModelList(null);
			JList1.updateUI();
			displayLists(null);
//?? set to blank			JTextArea1.

		} catch (Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Disconnect",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void JMenuItem1_actionPerformed(java.awt.event.ActionEvent event)
	{
	    try
	    {
		    _PEOSInterface.PEOS_logout();
            disconnectItem.setEnabled(true);
 		    connectItem.setEnabled(true);
		    fillModelList(null);
		    JList1.updateUI();
		    displayLists(null);
 		}
 		catch (Exception e)
 		{
 			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Login",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void exitItem_actionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		exitItem_actionPerformed_Interaction1(event);
	}

	void exitItem_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
		try {
			_PEOSInterface.disconnect();
			this.exitApplication();
		} catch (Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Exit",JOptionPane.ERROR_MESSAGE);
		}
	}

	void aboutItem_actionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		aboutItem_actionPerformed_Interaction1(event);
	}

	void aboutItem_actionPerformed_Interaction1(java.awt.event.ActionEvent event) {
		try {
			// JAboutDialog Create with owner and show as modal
			{
				JAboutDialog JAboutDialog1 = new JAboutDialog(this);
				JAboutDialog1.setModal(true);
				JAboutDialog1.show();
			}
		} catch (Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "About",JOptionPane.ERROR_MESSAGE);
		}
	}

	void JCreateBotton_actionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		JCreateBotton_actionPerformed_Interaction1(event);
	}

	void JCreateBotton_actionPerformed_Interaction1(java.awt.event.ActionEvent event)
	{
		try {
			int iSel = JList1.getSelectedIndex();
			String sel = (String) stringListModel.getElementAt(iSel);
			Hashtable retVal = _PEOSInterface.PEOS_execModel(sel);
			displayLists(retVal);
		
		} catch (java.lang.Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Create a process",JOptionPane.ERROR_MESSAGE);
		}
	}

	void JDoneButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		JDoneButton_actionPerformed_Interaction1(event);
	}

	void JDoneButton_actionPerformed_Interaction1(java.awt.event.ActionEvent event)
	{
		try {
			int idx = JTable1.getSelectedRow();
			execCommand(new String("done"), 
							(String) JTable1.getValueAt(idx, 1), 
							(String) JTable1.getValueAt(idx, 2));
		} catch (java.lang.Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Done a process",JOptionPane.ERROR_MESSAGE);
		}
	}

	void JSuspendButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		JSuspendButton_actionPerformed_Interaction2(event);
	}

	void JSuspendButton_actionPerformed_Interaction2(java.awt.event.ActionEvent event)
	{
		try {
			int idx = JTable1.getSelectedRow();
			String state = (String) JTable1.getValueAt(idx, 0);
			if (state.compareTo("R") == 0)
			{
				execCommand(new String("suspend"), 
								(String) JTable1.getValueAt(idx, 1), 
								(String) JTable1.getValueAt(idx, 2));
			}
//??		else
//				beep;

		} catch (java.lang.Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Suspend a process",JOptionPane.ERROR_MESSAGE);
		}
	}

	void JResumeButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		JResumeButton_actionPerformed_Interaction1(event);
	}

	void JResumeButton_actionPerformed_Interaction1(java.awt.event.ActionEvent event)
	{
		try {
			int idx = JTable1.getSelectedRow();
			String state = (String) JTable1.getValueAt(idx, 0);
			if (state.compareTo("S") == 0)
			{
				execCommand(new String("run"),
								(String) JTable1.getValueAt(idx, 1), 
								(String) JTable1.getValueAt(idx, 2));
			}
//??		else
//				beep;
		} catch (java.lang.Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Resume a process",JOptionPane.ERROR_MESSAGE);
		}
	}

	void JRunButton_actionPerformed(java.awt.event.ActionEvent event)
	{
		// to do: code goes here.
			 
		JRunButton_actionPerformed_Interaction1(event);
	}

	void JRunButton_actionPerformed_Interaction1(java.awt.event.ActionEvent event)
	{
		try {
			javax.swing.tree.TreePath path = JTree1.getSelectionModel().getSelectionPath();
			if (JTree1.getRowForPath(path) == 0)
			{
//				JOptionPane.showMessageDiaglog(
//					ControlPanel, this, "select a task of a process!");
				return;
			}
				
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
			DefaultMutableTreeNode	taskNode = null;
			if (!node.isLeaf())
			{
				if (node.getChildCount() > 1)
				{
//					JOptionPane.showMessageDiaglog(
//						ControlPanel, this, "select a task!");
					return;
				}
				else
					taskNode = (DefaultMutableTreeNode) node.getChildAt(0);
			}
			else
			{
				taskNode = node;
				node = (DefaultMutableTreeNode) taskNode.getParent();
			}
			String proc = node.toString();
			String task = taskNode.toString();
			execCommand(new String("run"), proc, task);
		} catch (java.lang.Exception e) {
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Run a process",JOptionPane.ERROR_MESSAGE);
		}
	}

	void fillModelList(Vector models)
	{
		if (models == null)
		{
			stringListModel.removeAllElements();
			return;
		}

		String[] tempString = new String[models.size()];
		for (int i = 0; i < models.size(); i++)
		{
			tempString[i] = (String) models.elementAt(i);
		}
		stringListModel.setItems(tempString);
	}

	void fillAvailableList(Vector avail, Vector error, PEOS_Process finished)
	{
		if ((avail == null) && (error == null) && (finished == null))
		{
			((DefaultMutableTreeNode)stringTreeModel1.getRoot()).removeAllChildren();
		    return;
        }
        
		String[] indents = {"", " ", "  "};
		Vector	items = new Vector();
		if (finished != null)
		{
			items.addElement(new String(indents[0] + "Finished Process"));
			items.addElement(new String(indents[1] + finished._processID 
				+ ", "+ finished._task));
		}
		PEOS_Process    proc;
		if (error != null) 
		{	
			if (error.size() > 0)
			{
				String errMsg;
				items.addElement(new String(indents[0] + "Errors in Processes"));
				for (int i = 0; i < error.size(); i++)
				{
					proc = (PEOS_Process) error.elementAt(i);
					items.addElement(new String(indents[1] + proc._processID
						+ ", " + proc._task));
					errMsg = proc.getErrorMsg();
					items.addElement(new String(indents[2] + errMsg));
				}
			}
		}
		String  procName = new String();
		if (avail != null)
		{	
			if (avail.size() > 0)
			{
				items.addElement(new String(indents[0] + "Available Processes"));
				for (int i = 0; i < avail.size(); i++)
				{
					proc = (PEOS_Process) avail.elementAt(i);
					if (procName.compareTo(proc._processID) == 0)
						items.addElement(new String(indents[2] + proc._task));
					else
					{
						procName = proc._processID;
						items.addElement(new String(indents[1] + proc._processID));
						items.addElement(new String(indents[2] + proc._task));
					}
				}
			}
		}
		String[] tempString = new String[items.size()];
		for (int j = 0; j < items.size(); j++)
		{
			tempString[j] = (String) items.elementAt(j);
		}
		stringTreeModel1.setItems(tempString);		//????
//		JTree1.setFont(new Font("Dialog", Font.BOLD, 12));
		JTree1.getSelectionModel().clearSelection();
		curTreeSelection = null;
 	}

	void fillRunningList(Vector runs)
	{
		int rowCount = tableModel1.getRowCount();
		for (int i = rowCount - 1; i >= 0; i++)
			tableModel1.removeRow(i);

		boolean bResume = false;
		boolean bDone = false;
		boolean bSuspend = false;
		if (runs != null)
		{
			if (runs.size() > 0)
			{
				bDone = true;
				PEOS_Process    proc;
				String[] tempString = new String[4];

				TableColumn pml = JTable1.getColumn(tableColNames[3]);
				int iCol = pml.getModelIndex();
				Component comp;
				int width = 0;
				TableCellRenderer renderer = pml.getHeaderRenderer();
				comp = renderer.getTableCellRendererComponent(
						  			JTable1, pml.getHeaderValue(), 
						  			false, false, 0, 0);
				int maxwd = comp.getPreferredSize().width;
				for (int iRow = 0; iRow < runs.size(); iRow++)
				{
					proc = (PEOS_Process) runs.elementAt(iRow);
					if (proc.getState() == PEOS_Process.STS_RUNNING)
					{
						tempString[0] = "S";
						bResume = true;
					}
					else
					{
						tempString[0] = "R"; 
						bSuspend = true;
					}
					tempString[1] = proc._processID;
					tempString[2] = proc._task;
					tempString[3] = proc.getPMLString();
					tableModel1.addRow(tempString);
					renderer = JTable1.getCellRenderer(iRow, iCol);
					comp = renderer.getTableCellRendererComponent(
						  			JTable1, JTable1.getValueAt(iRow,iCol), 
						  			false, false, iRow, iCol);
					width = comp.getPreferredSize().width;
					maxwd = (width > maxwd) ? width : maxwd;
				}
	//			pml.setMinWidth(maxwd);
	//			JTable1.sizeColumnsToFit(0);
			}
		}
		JDoneButton.setEnabled(bDone);
		JSuspendButton.setEnabled(bSuspend);
		JResumeButton.setEnabled(bResume);
	}

	void execCommand(String cmd, String proc, String task)
	{
		Hashtable retVal = null;
		try
		{
			if (!bAutoRun) 
			{
				retVal = _PEOSInterface.PEOS_execTask(cmd, proc, task);
			}
			else
			{
				String key = new String();
				PEOS_Process    procObj;
				String avail = new String("available");
				String cmdRun = new String("run");
				String cmdDone = new String("done");
				int count = 0;
				if (cmd.compareTo(cmdRun) == 0)	
					retVal = _PEOSInterface.PEOS_execTask(cmd, proc, task);

				while (true)
				{
					retVal = _PEOSInterface.PEOS_execTask(cmdDone, proc, task);
					procObj = null;
					procObj = foundProc(avail, retVal, proc); 
					if (count != 0)
						break;
					else			
						retVal = _PEOSInterface.PEOS_execTask(cmdRun, proc, procObj._task);
				}
			}
			displayLists(retVal);
		}
		catch (Exception e)
		{
			String msg = "Get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "Execute a PEOS command",JOptionPane.ERROR_MESSAGE);
		}
	}

	PEOS_Process foundProc(String key, Hashtable retVal, String procID)
	{
		int count = 0;
		PEOS_Process proc = null;
		Vector list = null;
		if (retVal.containsKey(key))
		{
			list = (Vector) retVal.get(key);
			for (int i = 0; i < list.size(); i++)
			{
				proc = (PEOS_Process) list.elementAt(i);
				if (procID.compareTo(proc._processID) == 0)
					count++;
			}
		}
		if (count == 1)
			return proc;
		else
			return null;
	}

	void parseRetValHashtable(Hashtable retVal)
	{
		try
		{
			Object availObj = null;
			Object errObj = null;
			Object finishedObj = null; 
			String key = new String("available");
			if (retVal.containsKey(key))
				availObj = retVal.get(key);
			key = "error";
			if (retVal.containsKey(key))
				errObj = retVal.get(key);
			key = "done";
			if (retVal.containsKey(key))
				finishedObj = retVal.get(key);
			fillAvailableList((Vector) availObj, 
					(Vector) errObj, (PEOS_Process) finishedObj);

			key = "running";
			if (retVal.containsKey(key))
			{
				fillRunningList((Vector) retVal.get(key));
			}
			else
			{
				fillRunningList(null);
			}
		}
		catch (Exception e)
		{
			String msg = "Get exception: " + e;
            JOptionPane.showMessageDialog(this, msg, "Parse return" ,JOptionPane.ERROR_MESSAGE);
		}
//		JTree1.Expansion();
	}

	void displayLists(Hashtable retVal)
	{
		if (retVal != null)
		{
			parseRetValHashtable(retVal);
		}
		else
		{
			fillAvailableList(null, null, null);
			fillRunningList(null);
		}
		try
		{
			JTree1.updateUI();
		}
		catch (Exception e)
		{
			String msg = "JTree get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "JTree",JOptionPane.ERROR_MESSAGE);
		}
		try
		{
			JTable1.updateUI();
		}
		catch (Exception e)
		{
			String msg = "JTable get exception: " + e;
			JOptionPane.showMessageDialog(this, msg, "JTable",JOptionPane.ERROR_MESSAGE);
		}
	}

	void JRadioButtonMenuItem1_actionPerformed(java.awt.event.ActionEvent event)
	{
		JRadioButtonMenuItem item = (JRadioButtonMenuItem) event.getSource(); // to do: code goes here.
		if (item.isSelected())
			bAutoRun = true;
	}

	void JRadioButtonMenuItem2_actionPerformed(java.awt.event.ActionEvent event)
	{
		JRadioButtonMenuItem item = (JRadioButtonMenuItem) event.getSource(); // to do: code goes here.
		if (item.isSelected())
			bAutoRun = false;
		// to do: code goes here.
	}

	class SymFocus extends java.awt.event.FocusAdapter
	{
		public void focusGained(java.awt.event.FocusEvent event)
		{
			Object object = event.getSource();
			if (object == JTree1)
				JTree1_focusGained(event);
			else if (object == JTable1)
				JTable1_focusGained(event);
		}
	}

	void JTree1_focusGained(java.awt.event.FocusEvent event)
	{
		if (curTreeSelection != null)
		{
			TreeSelectionModel selModel = JTree1.getSelectionModel();
			selModel.setSelectionPath(curTreeSelection);
			selModel.resetRowSelection();
		}
		curTableSelection = JTable1.getSelectedRow();
		JTable1.clearSelection();
	}

	void JTable1_focusGained(java.awt.event.FocusEvent event)
	{
		int rc = JTable1.getRowCount();
		if (rc > 0)
		{
			if (curTableSelection >= rc)
				curTableSelection = 0;
//???			JTable1.setSelectedRow(curTableSelection);
		}	 
		if (!JTree1.getSelectionModel().isSelectionEmpty())
		{
			curTreeSelection = JTree1.getSelectionModel().getSelectionPath();
			JTree1.getSelectionModel().clearSelection();
		}
		else
			curTreeSelection = null;
	}

}
