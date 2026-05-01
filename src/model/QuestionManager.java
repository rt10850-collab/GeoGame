/**
* File: QuestionMnager.java
* Class: CSCI 1302
* Author: Robert Taylor
* Created on: Apr 5, 2026
* Last Modified: Apr 17, 2026
* Description: Stores all questions and relevant information about those questions.
*/

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * - Manages the full bank of trivia questions. - Responsible for loading
 * questions and selecting a random one - at the appropriate difficulty level.
 */
public class QuestionManager {

	private List<Question> questions;
	private Random random;

	/**
	 * - Creates the QuestionManager and loads all questions immediately.
	 */
	public QuestionManager() {
		questions = new ArrayList<>();
		random = new Random();
		loadQuestions();
	}

	/**
	 * - Loads all geography trivia questions into the question bank. - Questions
	 * are hardcoded here — you can add more as needed. - Difficulty: 1 = Easy, 2 =
	 * Normal, 3 = Hard
	 */
	public void loadQuestions() {

		// — Easy Questions (difficulty = 1) —

		questions.add(new Question("What is the capital of France?",
				new String[] { "A. Berlin", "B. Madrid", "C. Paris", "D. Rome" }, 'C', 1));

		questions.add(new Question("Which continent is Australia on?",
				new String[] { "A. Asia", "B. Africa", "C. Europe", "D. Australia/Oceania" }, 'D', 1));

		questions.add(new Question("What is the largest ocean on Earth?",
				new String[] { "A. Atlantic", "B. Indian", "C. Arctic", "D. Pacific" }, 'D', 1));

		questions.add(new Question("Which country has the most people in the world?",
				new String[] { "A. USA", "B. India", "C. Russia", "D. Brazil" }, 'B', 1));

		questions.add(new Question("What is the capital of Japan?",
				new String[] { "A. Beijing", "B. Seoul", "C. Tokyo", "D. Bangkok" }, 'C', 1));

		questions.add(new Question("What is the capital of Germany?",
				new String[] { "A. Munich", "B. Hamburg", "C. Berlin", "D. Frankfurt" }, 'C', 1));

		questions.add(new Question("Which country is the Eiffel Tower located in?",
				new String[] { "A. Italy", "B. Spain", "C. Germany", "D. France" }, 'D', 1));

		questions.add(new Question("What is the smallest country in the world?",
				new String[] { "A. Monaco", "B. San Marino", "C. Vatican City", "D. Liechtenstein" }, 'C', 1));

		questions.add(new Question("Which continent is the Sahara Desert located on?",
				new String[] { "A. Asia", "B. South America", "C. Australia", "D. Africa" }, 'D', 1));

		questions.add(new Question("What is the capital of Australia?",
				new String[] { "A. Sydney", "B. Melbourne", "C. Canberra", "D. Brisbane" }, 'C', 1));

		questions.add(new Question("Which ocean lies between Europe and America?",
				new String[] { "A. Pacific", "B. Indian", "C. Arctic", "D. Atlantic" }, 'D', 1));

		questions.add(new Question("Mount Everest is located in which mountain range?",
				new String[] { "A. Alps", "B. Andes", "C. Himalayas", "D. Rockies" }, 'C', 1));

		questions.add(new Question("What is the capital of Brazil?",
				new String[] { "A. Rio de Janeiro", "B. Sao Paulo", "C. Salvador", "D. Brasilia" }, 'D', 1));

		questions.add(new Question("Which country shares the longest border with the USA?",
				new String[] { "A. Mexico", "B. Russia", "C. Canada", "D. Cuba" }, 'C', 1));

		// — Normal Questions (difficulty = 2) —

		questions.add(new Question("What is the longest river in the world?",
				new String[] { "A. Amazon", "B. Nile", "C. Yangtze", "D. Mississippi" }, 'B', 2));

		questions.add(new Question("Which country does the Amazon River primarily flow through?",
				new String[] { "A. Peru", "B. Colombia", "C. Brazil", "D. Venezuela" }, 'C', 2));

		questions.add(new Question("What is the capital of Canada?",
				new String[] { "A. Toronto", "B. Vancouver", "C. Montreal", "D. Ottawa" }, 'D', 2));

		questions.add(new Question("Which African country has the largest land area?",
				new String[] { "A. Sudan", "B. Libya", "C. Algeria", "D. DRC" }, 'C', 2));

		questions.add(new Question("The Ural Mountains form part of the border between which two continents?",
				new String[] { "A. Asia and Africa", "B. Europe and Asia", "C. Europe and Africa",
						"D. North and South America" },
				'B', 2));

		questions.add(new Question("What is the capital of Argentina?",
				new String[] { "A. Santiago", "B. Buenos Aires", "C. Lima", "D. Montevideo" }, 'B', 2));

		questions.add(new Question("Which country has the longest coastline in the world?",
				new String[] { "A. Russia", "B. Australia", "C. Norway", "D. Canada" }, 'D', 2));

		questions.add(new Question("What is the tallest mountain in Africa?",
				new String[] { "A. Mount Kenya", "B. Mount Kilimanjaro", "C. Mount Elgon", "D. Ras Dashen" }, 'B', 2));

		questions.add(new Question("Which sea separates Europe from Africa?",
				new String[] { "A. Red Sea", "B. Arabian Sea", "C. Mediterranean Sea", "D. Black Sea" }, 'C', 2));

		questions.add(new Question("What is the capital of South Korea?",
				new String[] { "A. Busan", "B. Pyongyang", "C. Beijing", "D. Seoul" }, 'D', 2));

		questions.add(new Question("Which river flows through Egypt?",
				new String[] { "A. Congo", "B. Niger", "C. Nile", "D. Zambezi" }, 'C', 2));

		questions.add(new Question("What is the largest country in South America by area?",
				new String[] { "A. Argentina", "B. Peru", "C. Brazil", "D. Colombia" }, 'C', 2));

		questions.add(new Question("Which country is home to the Great Barrier Reef?",
				new String[] { "A. New Zealand", "B. Philippines", "C. Indonesia", "D. Australia" }, 'D', 2));

		questions.add(new Question("What is the capital of Turkey?",
				new String[] { "A. Istanbul", "B. Ankara", "C. Izmir", "D. Bursa" }, 'B', 2));

		questions.add(new Question("Which mountain range runs along the western coast of South America?",
				new String[] { "A. Rockies", "B. Alps", "C. Himalayas", "D. Andes" }, 'D', 2));

		// — Hard Questions (difficulty = 3) —

		questions.add(new Question("What is the capital of Kazakhstan?",
				new String[] { "A. Almaty", "B. Tashkent", "C. Astana", "D. Bishkek" }, 'C', 3));

		questions.add(
				new Question("Which country is home to the Danakil Depression, one of the hottest places on Earth?",
						new String[] { "A. Somalia", "B. Sudan", "C. Ethiopia", "D. Djibouti" }, 'C', 3));

		questions.add(new Question("What is the smallest country in South America by land area?",
				new String[] { "A. Uruguay", "B. Suriname", "C. Guyana", "D. Ecuador" }, 'B', 3));

		questions.add(new Question("Lake Titicaca sits on the border of which two countries?", new String[] {
				"A. Brazil and Bolivia", "B. Peru and Bolivia", "C. Peru and Chile", "D. Argentina and Chile" }, 'B', 3));

		questions.add(new Question("Which ocean does the Mozambique Channel belong to?",
				new String[] { "A. Atlantic", "B. Pacific", "C. Indian", "D. Southern" }, 'C', 3));

		questions.add(new Question("What is the capital of Kyrgyzstan?",
				new String[] { "A. Almaty", "B. Bishkek", "C. Dushanbe", "D. Tashkent" }, 'B', 3));

		questions.add(new Question("Which country has the most natural lakes in the world?",
				new String[] { "A. Russia", "B. USA", "C. Finland", "D. Canada" }, 'D', 3));

		questions.add(new Question("What is the capital of Burkina Faso?",
				new String[] { "A. Bamako", "B. Niamey", "C. Ouagadougou", "D. Lome" }, 'C', 3));

		questions.add(new Question("Which river forms the border between Zambia and Zimbabwe?",
				new String[] { "A. Congo", "B. Limpopo", "C. Orange", "D. Zambezi" }, 'D', 3));

		questions.add(new Question("What is the smallest country in Asia by land area?",
				new String[] { "A. Singapore", "B. Maldives", "C. Bahrain", "D. Brunei" }, 'B', 3));

		questions.add(new Question("Which country contains the most of the Amazon Rainforest?",
				new String[] { "A. Peru", "B. Colombia", "C. Venezuela", "D. Brazil" }, 'D', 3));

		questions.add(new Question("What is the capital of Eritrea?",
				new String[] { "A. Mogadishu", "B. Asmara", "C. Djibouti", "D. Addis Ababa" }, 'B', 3));

		questions.add(new Question("Which country is the Patagonia region primarily located in?",
				new String[] { "A. Chile", "B. Bolivia", "C. Argentina", "D. Peru" }, 'C', 3));

		questions.add(new Question("What is the longest river in Europe?",
				new String[] { "A. Danube", "B. Rhine", "C. Volga", "D. Thames" }, 'C', 3));

		questions.add(new Question("Which African country has the most pyramids?",
				new String[] { "A. Egypt", "B. Sudan", "C. Ethiopia", "D. Libya" }, 'B', 3));

	}

	/**
	 * - Returns a random question at the given difficulty level. - If no questions
	 * exist at that difficulty, returns null. - - @param difficulty 1 (Easy), 2
	 * (Normal), or 3 (Hard) - @return A randomly selected Question, or null if none
	 * found
	 */
	public Question getRandomQuestion(int difficulty) {

		// Build a list of questions that match the requested difficulty
		List<Question> filtered = new ArrayList<>();
		for (Question q : questions) {
			if (q.getDifficulty() == difficulty) {
				filtered.add(q);
			}
		}

		// Return null if no matching questions were found
		if (filtered.isEmpty()) {
			return null;
		}

		// Pick and return a random question from the filtered list
		int randomIndex = random.nextInt(filtered.size());
		return filtered.get(randomIndex);
	}
}
