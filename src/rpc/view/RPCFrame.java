package rpc.view;

import javax.swing.JFrame;
import rpc.controller.RPCController;

/**
 * Main frame for the GUI
 * @author thod0127
 * @version 1.0 03/23/2016
 */
public class RPCFrame extends JFrame
{
	private RPCController basecontroller;
	private RPCPanel basePanel;
	
	public RPCFrame(RPCController baseController)
	{
		this.basecontroller = baseController;
		basePanel = new RPCPanel(basecontroller);
		
		setupFrame();
	}
	
	/**
	 * Sets up the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Rock Paper Scissors");
		this.setSize(285, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}
