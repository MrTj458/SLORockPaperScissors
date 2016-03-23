package rpc.view;

import javax.swing.JOptionPane;

/**
 * Displays popups.
 * @author thod0127
 * @version 1.0 03/23/2016
 */
public class RPCView
{
	private RPCPanel center;
	
	public RPCView(RPCPanel center)
	{
		this.center = center;
	}
	
	public void popup(String message)
	{
		JOptionPane.showMessageDialog(center, message);
	}
}
