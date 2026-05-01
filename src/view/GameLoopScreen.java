/**
* File: GameLoopScreen.java
* Class: CSCI 1302
* Author: Robert Taylor
* Created on: Apr 5, 2026
* Last Modified: Apr 17, 2026
* Description: display for the Game Loop Screen, where main gameplay loop will take place
*/

package view;

import controller.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.GeoGame;
import model.GameSettings;
import model.Question;

public class GameLoopScreen {

	private VBox layout;
	private GeoGame game;
	private TextArea questionArea;
	private Label feedbackLabel;
	private Label scoreLabel;

	public GameLoopScreen(GeoGame game, GameSettings settings, GameController controller) {
		this.game = game;

		// --- Title ---
		Label titleLabel = new Label("GeoGame");
		titleLabel.setFont(Font.font("Impact", FontWeight.BOLD, 28));
		titleLabel.setTextFill(Color.web("#2c3e50"));
		VBox.setMargin(titleLabel, new Insets(0, 0, 5, 0));

		// --- Tutorial Message ---
		Label tutorialLabel = new Label("Answer each question by clicking A, B, C, or D.\n"
				+ "You earn points for correct answers based on difficulty.");
		tutorialLabel.setFont(Font.font("Arial", 13));
		tutorialLabel.setTextFill(Color.web("#7f8c8d"));
		tutorialLabel.setVisible(settings.isShowTutorial());
		VBox.setMargin(tutorialLabel, new Insets(-10, 0, 15, 0));

		Separator sep = new Separator();
		VBox.setMargin(sep, new Insets(0, 0, 20, 0));

		// --- Question Display ---
		questionArea = new TextArea("Loading question...");
		questionArea.setFont(Font.font("Arial", 15));
		questionArea.setWrapText(true);
		questionArea.setEditable(false);
		questionArea.setFocusTraversable(false);
		questionArea.setPrefHeight(165);
		questionArea.setMaxWidth(620);
		questionArea.setStyle("-fx-background-color: #ffffff;" + "-fx-border-color: #d5d8dc;" + "-fx-border-radius: 6;"
				+ "-fx-background-radius: 6;" + "-fx-control-inner-background: #ffffff;");
		VBox.setMargin(questionArea, new Insets(0, 0, 18, 0));

		// --- Answer Buttons ---
		Button buttonA = makeAnswerButton("A");
		Button buttonB = makeAnswerButton("B");
		Button buttonC = makeAnswerButton("C");
		Button buttonD = makeAnswerButton("D");

		buttonA.setOnAction(e -> handleAnswer('A'));
		buttonB.setOnAction(e -> handleAnswer('B'));
		buttonC.setOnAction(e -> handleAnswer('C'));
		buttonD.setOnAction(e -> handleAnswer('D'));

		HBox answerRow = new HBox(15, buttonA, buttonB, buttonC, buttonD);
		answerRow.setAlignment(Pos.CENTER);
		VBox.setMargin(answerRow, new Insets(0, 0, 20, 0));

		// --- Feedback Label ---
		feedbackLabel = new Label("");
		feedbackLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		feedbackLabel.setTextFill(Color.web("#2c3e50"));
		feedbackLabel.setMinHeight(22);
		VBox.setMargin(feedbackLabel, new Insets(0, 0, 5, 0));

		// --- Score Display ---
		scoreLabel = new Label("Score: 0");
		scoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		scoreLabel.setTextFill(Color.web("#2c3e50"));
		VBox.setMargin(scoreLabel, new Insets(0, 0, 20, 0));

		// --- Next / Exit Buttons ---
		Button nextButton = makeNavButton("Next Question");
		Button exitButton = makeNavButton("Exit to Menu");

		nextButton.setOnAction(e -> showNextQuestion());
		exitButton.setOnAction(e -> controller.showIntroductionScreen());

		HBox bottomRow = new HBox(15, nextButton, exitButton);
		bottomRow.setAlignment(Pos.CENTER);

		// --- Main Layout ---
		layout = new VBox(0);
		layout.setAlignment(Pos.TOP_CENTER);
		layout.setPadding(new Insets(35, 50, 35, 50));
		layout.setStyle("-fx-background-color: #f4f6f7;");
		layout.getChildren().addAll(titleLabel, tutorialLabel, sep, questionArea, answerRow, feedbackLabel, scoreLabel,
				bottomRow);

		showNextQuestion();
	}

	/**
	 * Creates a styled answer button (A, B, C, D).
	 */
	private Button makeAnswerButton(String text) {
		Button button = new Button(text);
		button.setPrefWidth(90);
		button.setPrefHeight(38);
		button.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		button.setStyle("-fx-background-color: #2c3e50;" + "-fx-text-fill: white;" + "-fx-background-radius: 6;");
		button.setOnMouseEntered(e -> button
				.setStyle("-fx-background-color: #1a252f;" + "-fx-text-fill: white;" + "-fx-background-radius: 6;"));
		button.setOnMouseExited(e -> button
				.setStyle("-fx-background-color: #2c3e50;" + "-fx-text-fill: white;" + "-fx-background-radius: 6;"));
		return button;
	}

	/**
	 * Creates a styled navigation button (Next / Exit).
	 */
	private Button makeNavButton(String text) {
		Button button = new Button(text);
		button.setPrefWidth(145);
		button.setPrefHeight(38);
		button.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		button.setStyle("-fx-background-color: #bdc3c7;" + "-fx-text-fill: #2c3e50;" + "-fx-background-radius: 6;");
		button.setOnMouseEntered(e -> button
				.setStyle("-fx-background-color: #a1a6a9;" + "-fx-text-fill: #2c3e50;" + "-fx-background-radius: 6;"));
		button.setOnMouseExited(e -> button
				.setStyle("-fx-background-color: #bdc3c7;" + "-fx-text-fill: #2c3e50;" + "-fx-background-radius: 6;"));
		return button;
	}

	public void showNextQuestion() {
		feedbackLabel.setText("");

		Question nextQuestion = game.getNextQuestion();

		if (nextQuestion == null) {
			questionArea.setText("No questions available at this difficulty. Try changing settings.");
			return;
		}

		layout.setUserData(nextQuestion);

		String optionsText = nextQuestion.getQuestionText() + "\n\n";
		for (String option : nextQuestion.getOptions()) {
			optionsText += option + "\n";
		}
		questionArea.setText(optionsText);
	}

	private void handleAnswer(char answer) {
		Question currentQuestion = (Question) layout.getUserData();

		if (currentQuestion == null) {
			return;
		}

		String feedback = game.playQuestion(currentQuestion, answer);
		feedbackLabel.setText(feedback);
		scoreLabel.setText("Score: " + game.getScore());

		layout.setUserData(null);
	}

	public VBox getLayout() {
		return layout;
	}
}
