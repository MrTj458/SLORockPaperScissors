package rpc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import rpc.controller.RPCController;

/**
 * Main panel for the program
 * @author thod0127
 * @version 1.0 03/23/2016
 */
public class RPCPanel extends JPanel
{
	//Setup
	private RPCController baseController;
	private SpringLayout baseLayout;
	private RPCView display;
	
	//Buttons and objects
	private JButton rockButton;
	private JButton paperButton;
	private JButton scissorButton;
	private JToggleButton multiplayToggle;
	
	public RPCPanel(RPCController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		display = new RPCView(this);

		rockButton = new JButton("Rock");
		paperButton = new JButton("Paper");
		scissorButton = new JButton("Scissors");
		multiplayToggle = new JToggleButton("Multiplayer");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Adds all objects to the panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(275, 90));
		this.add(rockButton);
		this.add(paperButton);
		this.add(scissorButton);
		this.add(multiplayToggle);
	}
	
	/**
	 * Puts all objects in their correct places
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, multiplayToggle, 80, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, multiplayToggle, -6, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.NORTH, scissorButton, 0, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.WEST, scissorButton, 90, SpringLayout.EAST, rockButton);
		baseLayout.putConstraint(SpringLayout.NORTH, paperButton, 0, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.WEST, paperButton, 6, SpringLayout.EAST, rockButton);
		baseLayout.putConstraint(SpringLayout.NORTH, rockButton, 45, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rockButton, 10, SpringLayout.WEST, this);
	}
	
	/**
	 * All of the listeners needed by the buttons and objects
	 */
	private void setupListeners()
	{
		rockButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(baseController.getGame().isMultiplayer())
				{
					if(!baseController.getGame().getP1Selection().equals(""))
					{
						baseController.getGame().setP2Selection("rock");
					}
					else
					{
						baseController.getGame().setP1Selection("rock");
					}
					
					if(!baseController.getGame().getP1Selection().equals("") && !baseController.getGame().getP2Selection().equals(""))
					{
						displayWinner();
					}
				}
				else
				{
					baseController.getGame().setP1Selection("rock");
					displayWinner();
				}
			}
		});
		
		paperButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(baseController.getGame().isMultiplayer())
				{
					if(!baseController.getGame().getP1Selection().equals(""))
					{
						baseController.getGame().setP2Selection("paper");
					}
					else
					{
						baseController.getGame().setP1Selection("paper");
					}
					
					if(!baseController.getGame().getP1Selection().equals("") && !baseController.getGame().getP2Selection().equals(""))
					{
						displayWinner();
					}
				}
				else
				{
					baseController.getGame().setP1Selection("paper");
					displayWinner();
				}
			}
		});
		
		scissorButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(baseController.getGame().isMultiplayer())
				{
					if(!baseController.getGame().getP1Selection().equals(""))
					{
						baseController.getGame().setP2Selection("scissors");
					}
					else
					{
						baseController.getGame().setP1Selection("scissors");
					}
					
					if(!baseController.getGame().getP1Selection().equals("") && !baseController.getGame().getP2Selection().equals(""))
					{
						displayWinner();
					}
				}
				else
				{
					baseController.getGame().setP1Selection("scissors");
					displayWinner();
				}
			}
		});
		
		multiplayToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(baseController.getGame().isMultiplayer())
				{
					baseController.getGame().setMultiplayer(false);
				}
				else
				{
					baseController.getGame().setMultiplayer(true);
				}
			}
		});
	}
	
	/**
	 * Gets the winner and displays it in a popup
	 * Also resets the player selections
	 */
	private void displayWinner()
	{
		display.popup(baseController.getGame().getWinner());
		baseController.getGame().setP1Selection("");
		baseController.getGame().setP2Selection("");
	}
}
