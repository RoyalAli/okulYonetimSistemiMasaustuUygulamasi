package sample.idarecilerPackage;

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

public class idarecilerController implements Initializable {
    @FXML
    private TableView<idareciler> tableView;
    @FXML
    private TableColumn<idareciler, String> adColumn;
    @FXML
    private TableColumn<idareciler, String> soyadColumn;
    @FXML
    private TableColumn<idareciler, String> tcKimlikNumarasiColumn;
    @FXML
    private TableColumn<idareciler, String> pozisyonColumn;
    @FXML
    private TableColumn<idareciler, String> idareciNumarasiColumn;
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
                Parent root = FXMLLoader.load(getClass().getResource("idareciler.fxml"));
                stage.setScene(new Scene(root, 460, 800));
                stage.setResizable(false);
                stage.show();
            }catch (Exception error){
                error.printStackTrace();
            }
        }else if(actionEvent.getSource() == yeniIdareciEkleButton){
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("yeniIdareciEkle.fxml"));
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
        pozisyonColumn.setCellValueFactory(new PropertyValueFactory<>("pozisyon"));
        idareciNumarasiColumn.setCellValueFactory(new PropertyValueFactory<>("idareciNumarasi"));
        tableView.setItems(getIdareciler());
    }

    public ObservableList<idareciler> getIdareciler() {
        ObservableList<idareciler> idarecilerinHepsi = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/royalali/Desktop/OkulYonetimSistemiMasaUstuUygulamasi/src/sample/okulYonetimSistemiVeriTabani.db");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            statement.execute("select * from idareciler");

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                idarecilerinHepsi.add(new idareciler(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
            }

            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception error){
            error.printStackTrace();
        }
        return idarecilerinHepsi;
    }
}