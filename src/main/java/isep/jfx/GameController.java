package isep.jfx;

import isep.rpg.Enemy;
import isep.rpg.Game;
import isep.rpg.Hero;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class GameController {

    @FXML
    ListView<String> heroList;
    @FXML
    ListView<String> enemyList;
    @FXML
    Button fightButton;
    @FXML
    Button attack_button;
    @FXML
    Button potion_button;

    // "initialize()" est appelé par JavaFX à l'affichage de la fenêtre
    @FXML
    public void initialize() {
        initHeroSelectionListener();
        updateListViews();
        updateFightButton();
    }

    private void updateListViews() {
        heroList.getItems().setAll(Game.context.getHeroesStatus());
        enemyList.getItems().setAll(Game.context.getEnemiesStatus());
    }

    // L'action du bouton change en fonction de l'état du jeu
    private void updateFightButton() {
        switch (Game.context.status) {
            case START_COMBAT:

                attack_button.setDisable(false);
                potion_button.setDisable(false);
                attack_button.setVisible(false);
                potion_button.setVisible(false);

                fightButton.setText("Lancer le combat !");
                fightButton.setOnAction( event -> {
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                    } );
                break;
            case HERO_TURN:
                attack_button.setVisible(true);
                potion_button.setVisible(true);
                attack_button.setDisable(false);
                potion_button.setDisable(false);

                attack_button.setText("Attaque du héro...");
                attack_button.setOnAction( event -> {
                    Game.context.startHeroTurn();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                } );
                potion_button.setText("Utiliser une potion");
                potion_button.setOnAction( event -> {
                    Game.context.usePotion();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                } );

                break;
            case ENEMY_TURN:
                attack_button.setDisable(true);
                potion_button.setDisable(true);
                attack_button.setVisible(false);
                potion_button.setVisible(false);
                fightButton.setText("Attaque de l'ennemi...");
                fightButton.setOnAction( event -> {
                    Game.context.startEnemyTurn();
                    updateListViews();
                    Game.context.startNextFighterTurn();
                    updateFightButton();
                    } );
                break;
            case END_GAME:
                fightButton.setDisable(true);
                break;
        }
    }

    private void initHeroSelectionListener() {
        heroList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.print(heroList.getSelectionModel().getSelectedIndex());
            }
        });

    }
}
