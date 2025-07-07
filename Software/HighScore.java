import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;
import java.lang.Integer;

public class HighScore {

	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);


		ArrayList<User> scores = new ArrayList<User>();

		Scanner sc = new Scanner(new File("scoring.txt"));


		while (sc.hasNext()){
			String temp = sc.nextLine();

			for(int i = 0; i < temp.length()-2; i++)
			{
				if(temp.substring(i,i+2).equals(": "))
				{
					Integer num1 = new Integer(temp.substring(i+2));

					User tempScore = new User(temp.substring(0, i), num1.intValue());
					scores.add(tempScore);
				}
			}

		}

		sc.close();


		for(int i = 0; i < scores.size(); i++)
		{
			System.out.println(scores.get(i));
		}


		boolean onward = true;
		String entry = "";
		int points = 0;




		while(onward)
		{

			System.out.println("Enter your Username: ");
			entry = s.nextLine();

			int randy = (int)(Math.random()*2+1);
			System.out.println("Guess an integer between 1 and 2: ");
			int guess = s.nextInt();
			s.nextLine();

			while(guess == randy)
			{
				points++;
				System.out.println("Guess an integer between 1 and 2: ");
				guess = s.nextInt();
				s.nextLine();

			}

			if (guess != randy)
			{
				System.out.println("You didnt get the correct number!!! ");
				onward = false;

			}

		}


		User player = new User(entry, points);

		scores.add(player);

		for(int i = 0; i < scores.size(); i++)
		{

			for(int c = 0; c < scores.size()-1; c++)
			{

				if(scores.get(c).getScore() < scores.get(c+1).getScore() )
				{
					User temp = scores.get(c);
					scores.set(c, scores.get(c+1));
					scores.set(c+1, temp);

				}
			}
		}

		scores.remove(scores.size()-1);

		FileWriter f = new FileWriter("scoring.txt");

		PrintWriter scoring = new PrintWriter(f);

		System.out.println("New Order of Highest Scores: ");

		for(int i = 0; i < scores.size(); i++)
		{
			System.out.println(scores.get(i));
			scoring.println(scores.get(i));
		}

		scoring.close();
		f.close();



	}
}