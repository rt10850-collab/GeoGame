/**
* File: Question.java
* Class: CSCI 1302
* Author: Robert Taylor
* Created on: Apr 5, 2026
* Last Modified: Apr 17, 2026
* Description: Constructs Questions from data given by QuestionManager
*/

package model;

public class Question {

	private String questionText;
	private String[] options; // e.g. {“A. Paris”, “B. London”, “C. Berlin”, “D. Rome”}
	private char correctOption; // e.g. ‘A’, ‘B’, ‘C’, or ‘D’
	private int difficulty; // 1 = Easy, 2 = Normal, 3 = Hard

	/**
	 * - Constructs a Question with all required fields. - - @param questionText The
	 * question being asked - @param options Array of answer choices (should have 4
	 * entries) - @param correctOption The letter of the correct answer (‘A’, ‘B’,
	 * ‘C’, or ‘D’) - @param difficulty Difficulty level: 1 (Easy), 2 (Normal), or 3
	 * (Hard)
	 */
	public Question(String questionText, String[] options, char correctOption, int difficulty) {
		this.questionText = questionText;
		this.options = options;
		this.correctOption = correctOption;
		this.difficulty = difficulty;
	}

	// — Getters —

	public String getQuestionText() {
		return questionText;
	}

	public String[] getOptions() {
		return options;
	}

	public char getCorrectOption() {
		return correctOption;
	}

	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * - Checks whether the given answer matches the correct option. -
	 * Case-insensitive, so ‘a’ and ‘A’ are both accepted. - - @param answer The
	 * player’s answer as a char - @return true if correct, false otherwise
	 */
	public boolean checkAnswer(char answer) {
		return Character.toUpperCase(answer) == Character.toUpperCase(correctOption);
	}
}
