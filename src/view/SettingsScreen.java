/**
* File: SettingsScreen.java
* Class: CSCI 1302
* Author: Robert Taylor
* Created on: Apr 5, 2026
* Last Modified: Apr 17, 2026
* Description: Screen to allow the player to adjust settings.
*/

package view;

import controller.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.GameSettings;

public class SettingsScreen {

	private VBox layout;

	public SettingsScreen(GameSettings settings, GameController controller) {

		// --- Title ---
		Label titleLabel = new Label("Game Settings");
		titleLabel.setFont(Font.font("Impact", FontWeight.BOLD, 26));
		titleLabel.setTextFill(Color.web("#2c3e50"));
		VBox.setMargin(titleLabel, new Insets(0, 0, 5, 0));

		Label subtitleLabel = new Label("Adjust the game to your preference");
		subtitleLabel.setFont(Font.font("Arial", 13));
		subtitleLabel.setTextFill(Color.web("#7f8c8d"));
		VBox.setMargin(subtitleLabel, new Insets(0, 0, 20, 0));

		Separator sep1 = new Separator();
		VBox.setMargin(sep1, new Insets(0, 0, 20, 0));

		// --- Tutorial Toggle ---
		CheckBox tutorialCheckBox = new CheckBox("Show tutorial when starting a game");
		tutorialCheckBox.setSelected(settings.isShowTutorial());
		tutorialCheckBox.setFont(Font.font("Arial", 13));
		tutorialCheckBox.setTextFill(Color.web("#2c3e50"));
		tutorialCheckBox.setOnAction(e -> settings.setShowTutorial(tutorialCheckBox.isSelected()));
		VBox.setMargin(tutorialCheckBox, new Insets(0, 0, 25, 0));

		// --- Difficulty Selector ---
		Label difficultyTitle = new Label("Difficulty");
		difficultyTitle.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		difficultyTitle.setTextFill(Color.web("#2c3e50"));

		Label difficultyValueLabel = new Label(settings.getDifficultyLabel());
		difficultyValueLabel.setFont(Font.font("Arial", 13));
		difficultyValueLabel.setTextFill(Color.web("#7f8c8d"));
		difficultyValueLabel.setMinWidth(60);

		Slider difficultySlider = new Slider(1, 3, settings.getDifficulty());
		difficultySlider.setMajorTickUnit(1);
		difficultySlider.setSnapToTicks(true);
		difficultySlider.setShowTickLabels(true);
		difficultySlider.setShowTickMarks(true);
		difficultySlider.setPrefWidth(280);
		difficultySlider.valueProperty().addListener((obs, oldVal, newVal) -> {
			settings.setDifficulty(newVal.intValue());
			difficultyValueLabel.setText(settings.getDifficultyLabel());
		});

		HBox difficultyRow = new HBox(15, difficultySlider, difficultyValueLabel);
		difficultyRow.setAlignment(Pos.CENTER_LEFT);

		VBox difficultyBox = new VBox(8, difficultyTitle, difficultyRow);
		VBox.setMargin(difficultyBox, new Insets(0, 0, 25, 0));

		// --- Penalty Selector ---
		Label penaltyTitle = new Label("Wrong Answer Penalty");
		penaltyTitle.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		penaltyTitle.setTextFill(Color.web("#2c3e50"));

		Label penaltyValueLabel = new Label(settings.getWrongAnswerPenalty() + " points");
		penaltyValueLabel.setFont(Font.font("Arial", 13));
		penaltyValueLabel.setTextFill(Color.web("#7f8c8d"));
		penaltyValueLabel.setMinWidth(60);

		Slider penaltySlider = new Slider(0, 2, settings.getWrongAnswerPenalty());
		penaltySlider.setMajorTickUnit(1);
		penaltySlider.setSnapToTicks(true);
		penaltySlider.setShowTickLabels(true);
		penaltySlider.setShowTickMarks(true);
		penaltySlider.setPrefWidth(280);
		penaltySlider.valueProperty().addListener((obs, oldVal, newVal) -> {
			settings.setWrongAnswerPenalty(newVal.intValue());
			penaltyValueLabel.setText(newVal.intValue() + " points");
		});

		HBox penaltyRow = new HBox(15, penaltySlider, penaltyValueLabel);
		penaltyRow.setAlignment(Pos.CENTER_LEFT);

		VBox penaltyBox = new VBox(8, penaltyTitle, penaltyRow);
		VBox.setMargin(penaltyBox, new Insets(0, 0, 30, 0));

		Separator sep2 = new Separator();
		VBox.setMargin(sep2, new Insets(0, 0, 25, 0));

		// --- Back Button ---
		Button exitButton = new Button("Back to Menu");
		exitButton.setPrefWidth(160);
		exitButton.setPrefHeight(38);
		exitButton.setFont(Font.font("Arial", FontWeight.BOLD, 13));
		exitButton.setStyle("-fx-background-color: #2c3e50;" + "-fx-text-fill: white;" + "-fx-background-radius: 6;");
		exitButton.setOnMouseEntered(e -> exitButton
				.setStyle("-fx-background-color: #1a252f;" + "-fx-text-fill: white;" + "-fx-background-radius: 6;"));
		exitButton.setOnMouseExited(e -> exitButton
				.setStyle("-fx-background-color: #2c3e50;" + "-fx-text-fill: white;" + "-fx-background-radius: 6;"));
		exitButton.setOnAction(e -> controller.showIntroductionScreen());

		// --- Layout ---
		layout = new VBox(0);
		layout.setAlignment(Pos.TOP_LEFT);
		layout.setPadding(new Insets(50, 60, 50, 60));
		layout.setStyle("-fx-background-color: #f4f6f7;");
		layout.getChildren().addAll(titleLabel, subtitleLabel, sep1, tutorialCheckBox, difficultyBox, penaltyBox, sep2,
				exitButton);
	}

	public VBox getLayout() {
		return layout;
	}
}
