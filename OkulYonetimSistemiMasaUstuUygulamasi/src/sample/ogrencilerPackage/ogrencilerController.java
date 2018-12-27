package sample.ogrencilerPackage;

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

public class ogrencilerController implements Initializable {
    @FXML
    private TableView<ogrenciler> tableView;
    @FXML
    private TableColumn<ogrenciler, String> adColumn;
    @FXML
    private TableColumn<ogrenciler, String> soyadColumn;
    @FXML
    private TableColumn<ogrenciler, String> tcKimlikNumarasiColumn;
    @FXML
    private TableColumn<ogrenciler, String> sinifColumn;
    @FXML
    private TableColumn<ogrenciler, String> ogrenciNumarasiColumn;
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
                Parent root = FXMLLoader.load(getClass().getResource("ogrenciler.fxml"));
                stage.setScene(new Scene(root, 460, 800));
                stage.setResizable(false);
                stage.show();
            }catch (Exception error){
                error.printStackTrace();
            }
        }else if(actionEvent.getSource() == yeniIdareciEkleButton){
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("yeniOgrenciEkle.fxml"));
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
        sinifColumn.setCellValueFactory(new PropertyValueFactory<>("sinif"));
        ogrenciNumarasiColumn.setCellValueFactory(new PropertyValueFactory<>("ogrenciNumarasi"));
        tableView.setItems(getOgrenciler());
    }

    public ObservableList<ogrenciler> getOgrenciler() {
        ObservableList<ogrenciler> ogrencilerinHepsi = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/royalali/Desktop/OkulYonetimSistemiMasaUstuUygulamasi/src/sample/okulYonetimSistemiVeriTabani.db");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            statement.execute("select * from ogrenciler");

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                ogrencilerinHepsi.add(new ogrenciler(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
            }

            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception error){
            error.printStackTrace();
        }
        return ogrencilerinHepsi;
    }
}