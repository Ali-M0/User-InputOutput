public class User
{
	private String username = "";
	private int score = 0;

	public User(String u, int s)
	{
		username = u;
		score = s;
	}

	public int getScore()
	{
		return score;
	}
	public String getUser()
	{
		return username;
	}

	public String toString()
	{
		return username+": "+score;
	}
}