/**
* File: GeoGame.java
* Class: CSCI 1302
* Author: Robert Taylor
* Created on: Apr 5, 2026
* Last Modified: Apr 17, 2026
* Description: core game logic class, tracks player score, retrieves questions from Questions Manager, applies settings from GameSettings.
*/

package model;

/**
 * 
 * - The core game logic class. - Tracks the player’s score, retrieves
 * questions, and processes answers. - Works with GameSettings to apply the
 * correct difficulty and penalties.
 */
public class GeoGame {

	private int score;
	private GameSettings settings;
	private QuestionManager questionManager;

	/**
	 * - Creates a new GeoGame using the provided settings. - Score starts at 0 and
	 * questions are ready to be served. - - @param settings The current game
	 * settings (difficulty, penalty, etc.)
	 */
	public GeoGame(GameSettings settings) {
		this.settings = settings;
		this.questionManager = new QuestionManager();
		this.score = 0;
	}

	/**
	 * - Gets the next question based on the current difficulty in settings. -
	 * - @return A Question at the appropriate difficulty, or null if none available
	 */
	public Question getNextQuestion() {
		return questionManager.getRandomQuestion(settings.getDifficulty());
	}

	/**
	 * - Processes the player’s answer to a question. - Awards points for a correct
	 * answer based on difficulty. - Deducts points for a wrong answer based on
	 * settings. - - Points awarded per difficulty: - Easy = 1 point - Normal = 2
	 * points - Hard = 3 points - - @param question The question that was answered
	 * - @param answer The player’s answer as a char (‘A’, ‘B’, ‘C’, or ‘D’)
	 * - @return A feedback message telling the player if they were right or wrong
	 */
	public String playQuestion(Question question, char answer) {

		if (question.checkAnswer(answer)) {

			// Award points based on how hard the question was
			int pointsEarned = question.getDifficulty();
			score += pointsEarned;
			return "Correct! +" + pointsEarned + " points. Total score: " + score;

		} else {

			// Deduct the penalty set in settings (minimum score is 0)
			int penalty = settings.getWrongAnswerPenalty();
			score -= penalty;

			// Don't let the score drop below zero
			if (score < 0) {
				score = 0;
			}

			String correctLetter = String.valueOf(question.getCorrectOption());
			if (penalty > 0) {
				return "Wrong! The correct answer was " + correctLetter + ". -" + penalty + " points. Total score: "
						+ score;
			} else {
				return "Wrong! The correct answer was " + correctLetter + ". Total score: " + score;
			}

		}
	}

	/**
	 * - Resets the score back to 0. - Useful when the player starts a new game.
	 */
	public void resetScore() {
		score = 0;
	}

	// — Getter —

	public int getScore() {
		return score;
	}
}
