package manage;

import database.DatabaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Bookmark;
import search.SearchController;

import java.sql.SQLException;

public class Manager extends Application {

    /**
     * Static DatabaseController should be used by every component and there should be only one
     */
    private static DatabaseController databaseController = new DatabaseController("res/data/data.sqlite");

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));
        Parent root = loader.load();
        root.getStylesheets().add("stylesheets/style.css");
        SearchController searchController = loader.getController();
        loadData();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Loads all data from the database into the ArrayLists.
     * Shows all Bookmarks in the @{@link SearchController}s Listview
     *
     * @throws SQLException Failed to load data
     */
    private void loadData() throws SQLException {
        Manager.getDatabaseController().consumerWrapper(Manager.getDatabaseController()::readTags);
        Manager.getDatabaseController().consumerWrapper(Manager.getDatabaseController()::readEnvironemnts);
        Manager.getDatabaseController().consumerWrapper(Manager.getDatabaseController()::readBookmarks);
        Bookmark.showAllBookmarks();
        //TODO: should i move this method calls into the static constructor of Bookmark class?
    }

    public static void main(String[] args) {
        launch(args);
    }


    public static DatabaseController getDatabaseController() {
        return databaseController;
    }
}
