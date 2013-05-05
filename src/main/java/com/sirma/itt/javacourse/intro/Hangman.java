package com.sirma.itt.javacourse.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Class implementing the game hangman.
 */
public class Hangman {
	private String word;
	private int unguessed;
	private int tryouts;
	private final ArrayList<String> wrongTries = new ArrayList<String>();

	/**
	 * main constructor - initiates try outs to 6 and invokes play().
	 * Invoke it using the "new" keyword to start a new game.
	 * 
	 * @throws IOException
	 *             if an error with the input/output occurs
	 */
	public Hangman() throws IOException {
		tryouts = 6;
		play();
	}

	/**
	 * Reads a word from the console.
	 * 
	 * @return the user input
	 */
	private String inputWord() {
		String word = null;
		System.out.println("Input the word to guess: ");
		java.io.InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		try {
			word = br.readLine();
		} catch (Exception e) {
		}
		return word;
	}

	/**
	 * Reads a string from the console and checks if it contain only one letter
	 * and no numeric/special characters.
	 * 
	 * @return - the letter read from the user
	 */
	private String inputLetter() {
		String letter = null;
		System.out.println("Guess a letter: ");
		java.io.InputStream in = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		try {
			letter = br.readLine();
		} catch (Exception e) {
		}
		if (letter.length() != 1) {
			System.out.println("Please, input a single letter");
			return "NA";
		} else {
			if (!Character.isLetter(letter.charAt(0))) {
				System.out.println("Please, input letters only");
				return "NA";
			}
		}
		return letter;
	}

	/**
	 * Creates a string with the given size consisitng only of asterisk signs.
	 * 
	 * @param size
	 *            is the size of string
	 * @return the newly created string of asterisk signs
	 */
	private String createEmptyWord(int size) {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += "*";
		}
		return str;
	}

	/**
	 * Fills the guessed letters into the hint word and returns it.
	 * 
	 * @param letter
	 *            the letter to be filled in the hint word
	 * @param hintWord
	 *            the current hint word to be modified
	 * @return the new, filled hint word
	 */
	private String fillGuessed(String letter, String hintWord) {
		int index = word.indexOf(letter);
		while (index != -1) {
			hintWord = hintWord.substring(0, index) + letter
					+ hintWord.substring(index + 1);
			unguessed--;
			index = word.indexOf(letter, index + 1);
		}
		return hintWord;
	}

	/**
	 * Contains the main game logic. Waits for a proper user input to continue
	 * the game.
	 */
	private void play() {
		word = inputWord();
		unguessed = word.length();
		String hintWord = createEmptyWord(word.length());
		// loop containing the main game logic
		while (tryouts > 0) {
			String temp = " ";
			// if the user inputs one non-numerical letter, the loop breaks
			while (true) {
				temp = inputLetter();
				if (!"NA".equals(temp)) {
					break;
				}
			}
			String letter = temp;

			if (!word.contains(letter)) {
				if (wrongTries.contains(letter)) {
					System.out.println("You already tried with " + letter
							+ " and it's wrong");
				} else {
					wrongTries.add(letter);
					tryouts--;
					System.out.println("Wrong! You can try " + tryouts
							+ " more times!");
				}
			} else {
				if (!hintWord.contains(letter)) {
					hintWord = fillGuessed(letter, hintWord);
					System.out.println("You guessed! The word so far is: "
							+ hintWord);
					if (unguessed <= 0) {
						System.out.println("--==You won!==--");
						return;
					}
				}
			}
		}
		System.out.println("--==You were hanged!==--");
	}

	public static void main(String[] args) throws IOException {
		new Hangman();
	}
}