package isep.jfx;

import isep.rpg.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

public class MainController {



    @FXML
    ListView<String> teamList;
    @FXML
    Button addHealer;
    @FXML
    Button addMage;
    @FXML
    Button addWarrior;
    @FXML
    Button addHunter;

    @FXML
    protected void onStartButtonClick() throws IOException {
        // Affiche la fenêtre principale du jeu
        FXMLLoader fxmlLoader = new FXMLLoader
                (MainApplication.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainApplication.stage.setScene(scene);
        MainApplication.stage.show();
    }

    @FXML
    public void initialize() {
        Game.playGame();
        updateTeamListView();
    }

    private void updateTeamListView() {
        teamList.getItems().setAll(Game.context.getHeroesStatus());
    }

}
