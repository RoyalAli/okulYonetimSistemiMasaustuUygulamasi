package sample.ogretmenlerPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ogretmenlerController implements Initializable {
    @FXML
    private TableView<ogretmenler> tableView;
    @FXML
    private TableColumn<ogretmenler, String> adColumn;
    @FXML
    private TableColumn<ogretmenler, String> soyadColumn;
    @FXML
    private TableColumn<ogretmenler, String> tcKimlikNumarasiColumn;
    @FXML
    private TableColumn<ogretmenler, String> bransColumn;
    @FXML
    private TableColumn<ogretmenler, String> ogretmenNumarasiColumn;
    @FXML
    private Button yenileButton;
    @FXML
    private Button yeniIdareciEkleButton;

    public void setButton(ActionEvent actionEvent){
        if(actionEvent.getSource() == yenileButton){
            Stage closeStage = (Stage) yenileButton.getScene().getWindow();
            closeStage.close();

            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("ogretmenler.fxml"));
                stage.setScene(new Scene(root, 475, 800));
                stage.setResizable(false);
                stage.show();
            }catch (Exception error){
                error.printStackTrace();
            }
        }else if(actionEvent.getSource() == yeniIdareciEkleButton){
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("yeniOgretmenEkle.fxml"));
                stage.setScene(new Scene(root, 500, 350));
                stage.setResizable(false);
                stage.show();
            }catch (Exception error){
                error.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        adColumn.setCellValueFactory(new PropertyValueFactory<>("ad"));
        soyadColumn.setCellValueFactory(new PropertyValueFactory<>("soyad"));
        tcKimlikNumarasiColumn.setCellValueFactory(new PropertyValueFactory<>("tcKimlikNumarasi"));
        bransColumn.setCellValueFactory(new PropertyValueFactory<>("brans"));
        ogretmenNumarasiColumn.setCellValueFactory(new PropertyValueFactory<>("ogretmenNumarasi"));
        tableView.setItems(getOgretmenler());
    }

    public ObservableList<ogretmenler> getOgretmenler() {
        ObservableList<ogretmenler> ogretmenlerinHepsi = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/royalali/Desktop/OkulYonetimSistemiMasaUstuUygulamasi/src/sample/okulYonetimSistemiVeriTabani.db");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            statement.execute("select * from ogretmenler");

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                ogretmenlerinHepsi.add(new ogretmenler(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
            }

            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception error){
            error.printStackTrace();
        }
        return ogretmenlerinHepsi;
    }
}