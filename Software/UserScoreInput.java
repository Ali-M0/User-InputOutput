import java.io.*;
import java.util.Scanner;

public class UserScoreInput {
	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(new File("scoring.txt"));

		while (s.hasNext()){

			String temp = s.nextLine();
			System.out.println(temp);

		}

		s.close();

	}
}