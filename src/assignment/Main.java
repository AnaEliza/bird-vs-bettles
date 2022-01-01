package assignment;

import assignment.factory.ChallengeFactory;

public class Main {

	public static void main(String[] args) {
		new ChallengeFactory().createChallenge().start();
	}

}
