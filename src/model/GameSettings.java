/**
* File: GameSettings.java
* Class: CSCI 1302
* Author: Robert Taylor
* Created on: Apr 5, 2026
* Last Modified: Apr 17, 2026
* Description: Stores and manages all configurable settings for the geography trivia game.
*/

package model;

public class GameSettings {

	// Whether to show tutorial text when the game loop starts
	private boolean showTutorial;

	// Difficulty level: 1 = Easy, 2 = Normal, 3 = Hard
	private int difficulty;

	// Points deducted for a wrong answer (0 means no penalty)
	private int wrongAnswerPenalty;

	/**
	 * - Sets up default settings when the game is first launched.
	 */
	public GameSettings() {
		this.showTutorial = true; // Tutorial shown by default
		this.difficulty = 1; // Easy by default
		this.wrongAnswerPenalty = 0; // No penalty by default
	}

	// — Getters and Setters —

	public boolean isShowTutorial() {
		return showTutorial;
	}

	public void setShowTutorial(boolean showTutorial) {
		this.showTutorial = showTutorial;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getWrongAnswerPenalty() {
		return wrongAnswerPenalty;
	}

	public void setWrongAnswerPenalty(int wrongAnswerPenalty) {
		this.wrongAnswerPenalty = wrongAnswerPenalty;
	}

	/**
	 * - Returns the difficulty as a readable string. - Useful for displaying the
	 * current setting on screen.
	 */
	public String getDifficultyLabel() {
		switch (difficulty) {
		case 1:
			return "Easy";
		case 2:
			return "Normal";
		case 3:
			return "Hard";
		default:
			return "Unknown";
		}
	}
}
