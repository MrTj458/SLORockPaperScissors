package rpc.model;

/**
 * Calculates the winners of the game
 * @author thod0127
 * @version 1.1 03/23/2016
 */
public class RockPaperScissors
{
	private String p1Selection;
	private String p2Selection;
	private boolean isMultiplayer;
	private int wins;
	private int losses;
	private int ties;
	
	public RockPaperScissors()
	{
		p1Selection = "";
		p2Selection = "";
		isMultiplayer = false;
	}
	
	/**
	 * @return The winner of the round. This should be called from outside methods.
	 */
	public String getWinner()
	{
		String winner = "";
		
		if(isMultiplayer)
		{
			winner = getMultiplayerWinner();
		}
		else
		{
			winner = getSingleplayerWinner();
		}
		
		return winner;
	}
	
	/**
	 * @return The winner of a multiplayer game.
	 */
	private String getMultiplayerWinner()
	{
		String winner = "";
		
		if(p1Selection.equals("rock") && p2Selection.equals("rock"))
		{
			winner = "It's a tie!";
		}
		else if(p1Selection.equals("rock") && p2Selection.equals("paper"))
		{
			winner = "Player 2 wins!";
		}
		else if(p1Selection.equals("rock") && p2Selection.equals("scissors"))
		{
			winner = "Player 1 wins!";
		}
		else if(p1Selection.equals("paper") && p2Selection.equals("rock"))
		{
			winner = "Player 1 Wins!";
		}
		else if(p1Selection.equals("paper") && p2Selection.equals("paper"))
		{
			winner = "It's a tie!";
		}
		else if(p1Selection.equals("paper") && p2Selection.equals("scissors"))
		{
			winner = "Player 2 wins!";
		}
		else if(p1Selection.equals("scissors") && p2Selection.equals("rock"))
		{
			winner = "Player 2 wins!";
		}
		else if(p1Selection.equals("scissors") && p2Selection.equals("paper"))
		{
			winner = "Player 1 wins!";
		}
		else if(p1Selection.equals("scissors") && p2Selection.equals("scissors"))
		{
			winner = "It's a tie!";
		}
		
		return winner;
	}
	
	/**
	 * @return The winner between the player selection and a random selection
	 */
	private String getSingleplayerWinner()
	{
		String winner = "";
		
		int botSelection = (int) (Math.random() * 3);
		
		if(botSelection == 0)
		{
			p2Selection = "rock";
		}
		else if(botSelection == 1)
		{
			p2Selection = "paper";
		}
		else if(botSelection == 2)
		{
			p2Selection = "scissors";
		}
		
		if(p1Selection.equals("rock") && p2Selection.equals("rock"))
		{
			winner = "It's a tie!";
			ties++;
		}
		else if(p1Selection.equals("rock") && p2Selection.equals("paper"))
		{
			winner = "The bot wins!";
			losses++;
		}
		else if(p1Selection.equals("rock") && p2Selection.equals("scissors"))
		{
			winner = "You win!";
			wins++;
		}
		else if(p1Selection.equals("paper") && p2Selection.equals("rock"))
		{
			winner = "You win!";
			wins++;
		}
		else if(p1Selection.equals("paper") && p2Selection.equals("paper"))
		{
			winner = "It's a tie!";
			ties++;
		}
		else if(p1Selection.equals("paper") && p2Selection.equals("scissors"))
		{
			winner = "The bot wins!";
			wins++;
		}
		else if(p1Selection.equals("scissors") && p2Selection.equals("rock"))
		{
			winner = "The bot wins!";
			losses++;
		}
		else if(p1Selection.equals("scissors") && p2Selection.equals("paper"))
		{
			winner = "You win!";
			wins++;
		}
		else if(p1Selection.equals("scissors") && p2Selection.equals("scissors"))
		{
			winner = "It's a tie!";
			ties++;
		}
		else
		{
			winner = "Unknown winner";
		}
		
		return winner;
	}

	public String getP1Selection()
	{
		return p1Selection;
	}

	public void setP1Selection(String p1Selection)
	{
		this.p1Selection = p1Selection;
	}

	public String getP2Selection()
	{
		return p2Selection;
	}

	public void setP2Selection(String p2Selection)
	{
		this.p2Selection = p2Selection;
	}

	public boolean isMultiplayer()
	{
		return isMultiplayer;
	}

	public void setMultiplayer(boolean isMultiplayer)
	{
		this.isMultiplayer = isMultiplayer;
	}

	public int getWins()
	{
		return wins;
	}

	public void setWins(int wins)
	{
		this.wins = wins;
	}

	public int getLosses()
	{
		return losses;
	}

	public void setLosses(int loses)
	{
		this.losses = loses;
	}

	public int getTies()
	{
		return ties;
	}

	public void setTies(int ties)
	{
		this.ties = ties;
	}
}
