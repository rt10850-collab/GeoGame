/**
* File: IntroductionScreen.java
* Class: CSCI 1302
* Author: Robert Taylor
* Created on: Apr 5, 2026
* Last Modified: Apr 17, 2026
* Description: Introduction Screen, allows user to exit the program, go to the settings screen, and go into the main game
*/

package view;

import controller.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.GameSettings;

public class IntroductionScreen {

	private VBox layout;

	public IntroductionScreen(GameSettings settings, GameController controller) {

		// --- Title ---
		Label titleLabel = new Label("GeoGame");
		titleLabel.setFont(Font.font("Impact", FontWeight.BOLD, 60));
		titleLabel.setTextFill(Color.web("#2c3e50"));
		VBox.setMargin(titleLabel, new Insets(0, 0, 5, 0));

		// --- Subtitle ---
		Label subtitleLabel = new Label("Made by Robert Taylor");
		subtitleLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
		subtitleLabel.setTextFill(Color.web("#7f8c8d"));
		VBox.setMargin(subtitleLabel, new Insets(0, 0, 30, 0));

		// --- Buttons ---
		Button startButton = makeButton("Start");
		Button settingsButton = makeButton("Settings");
		Button exitButton = makeButton("Exit");

		startButton.setOnAction(e -> controller.showGameLoopScreen());
		settingsButton.setOnAction(e -> controller.showSettingsScreen());
		exitButton.setOnAction(e -> controller.exitGame());

		// --- Layout ---
		layout = new VBox(14);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(50));
		layout.setStyle("-fx-background-color: #f4f6f7;");
		layout.getChildren().addAll(titleLabel, subtitleLabel, startButton, settingsButton, exitButton);
	}

	/**
	 * Creates a consistently styled button for the intro screen.
	 */
	private Button makeButton(String text) {
		Button button = new Button(text);
		button.setPrefWidth(220);
		button.setPrefHeight(40);
		button.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		button.setStyle("-fx-background-color: #2c3e50;" + "-fx-text-fill: white;" + "-fx-background-radius: 6;");

		// Hover effect
		button.setOnMouseEntered(e -> button
				.setStyle("-fx-background-color: #1a252f;" + "-fx-text-fill: white;" + "-fx-background-radius: 6;"));
		button.setOnMouseExited(e -> button
				.setStyle("-fx-background-color: #2c3e50;" + "-fx-text-fill: white;" + "-fx-background-radius: 6;"));

		return button;
	}

	public VBox getLayout() {
		return layout;
	}
}
