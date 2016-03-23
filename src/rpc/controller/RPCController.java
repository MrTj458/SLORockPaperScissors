package rpc.controller;

import rpc.model.RockPaperScissors;
import rpc.view.RPCFrame;

/**
 * Main controller for the program.
 * @author thod0127
 * @version 1.0 03/23/2016
 */
public class RPCController
{
	private RockPaperScissors game;
	private RPCFrame baseFrame;
	
	public RPCController()
	{
		game = new RockPaperScissors();
		baseFrame = new RPCFrame(this);
	}
	
	public RockPaperScissors getGame()
	{
		return game;
	}
}
