import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.List;

public class UserInterface extends Application{
    private String title= "";
    private TableView<Revision> tableView = new TableView<>();
    private TableColumn<Revision, String> usernameIp = new TableColumn<>("Username/IP");
    private TableColumn<Revision, Integer> numberOfRevisions = new TableColumn<>("# Of Revisions");
    private TableColumn<Revision, String> timestamp = new TableColumn<>("Timestamp");
    private Label alertLabel = new Label("");
    private Label redirectLabel = new Label();
    private Label label = new Label("Enter Wiki Page name:");
    private VBox background = new VBox();
    private HBox wikiNameArea = new HBox(label);

    @Override
    public void start(Stage primaryStage) {
        VBox background = setDesign();
        primaryStage.setScene(new Scene(background, 650,500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private VBox setDesign() {
        TableView<Revision> tableView = addTableView();
        HBox wikiNameArea = addWikiNameArea();
        alertLabel.setTextFill(Color.web("#ff0000"));
        background.getChildren().addAll(wikiNameArea, tableView, alertLabel);

        return background;
    }
    private TableView<Revision> addTableView() {
        usernameIp.setMinWidth(250);
        usernameIp.setMaxWidth(250);
        numberOfRevisions.setMinWidth(148);
        numberOfRevisions.setMaxWidth(148);
        timestamp.setMinWidth(200);
        timestamp.setMaxWidth(200);
        //noinspection unchecked
        tableView.getColumns().addAll(usernameIp, numberOfRevisions, timestamp);

        return tableView;
    }

    private HBox addWikiNameArea() {
        label.setFont(new Font("Times New Roman", 20));
        wikiNameArea.setSpacing(10);
        wikiNameArea.setPadding(new Insets(10,10,10,10));
        wikiNameArea.setStyle("-fx-background-color: #4568d4");
        TextField textField = new TextField();
        Button enterButton = new Button("Enter");
        Button clearButton = new Button("Clear");
        setButtonAction(clearButton,enterButton,textField);
        wikiNameArea.getChildren().addAll(textField, enterButton, clearButton, redirectLabel);

        return wikiNameArea;
    }

    private void setButtonAction(Button clearButton, Button enterButton, TextField textField) {
        enterButton.setOnAction(event -> {
            title = textField.getText();
            if (!title.isEmpty()) {
                addItems();
            }
        });
        clearButton.setOnAction(event -> {
            textField.clear();
            alertLabel.setText("");
        });
    }

    private void addItems() {
        RevisionParser parser = new RevisionParser();
        InterfaceAlert alert = new InterfaceAlert();
        ObservableList<Revision> userData;
        InputStream inputStream = new WikiConnect().connect(title);
        alertLabel.setText(alert.CheckNetAvailable(inputStream));
        redirectLabel.setText("");

        if(inputStream != null){
            List<Revision> revisions = parser.parse(inputStream);
            alertLabel.setText(alert.DoesWikiExist(revisions));
            if (!parser.newTitle.equals("")) {
                redirectLabel.setText("Redirected to: " + parser.newTitle);
            }
            userData = FXCollections.observableArrayList(revisions);
            usernameIp.setCellValueFactory(new PropertyValueFactory<>("username"));
            timestamp.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
            numberOfRevisions.setCellValueFactory(new PropertyValueFactory<>("numberOfRevisions"));
            tableView.setItems(userData);

        }
    }
}
