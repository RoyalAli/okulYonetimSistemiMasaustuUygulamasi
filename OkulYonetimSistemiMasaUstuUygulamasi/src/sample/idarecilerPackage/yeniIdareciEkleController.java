package sample.idarecilerPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class yeniIdareciEkleController {
    @FXML
    private Button iptalEtButton;
    @FXML
    private Button ekleButton;
    @FXML
    private TextField adTextField;
    @FXML
    private TextField soyadTextField;
    @FXML
    private TextField tcKimlikNumarasiTextField;
    @FXML
    private TextField pozisyonTextField;
    @FXML
    private TextField idareciNumarasiTextField;

    public void setButton(ActionEvent actionEvent) {
        if (actionEvent.getSource() == iptalEtButton) {
            Stage closeStage = (Stage) iptalEtButton.getScene().getWindow();
            closeStage.close();
        } else if (actionEvent.getSource() == ekleButton) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/royalali/Desktop/OkulYonetimSistemiMasaUstuUygulamasi/src/sample/okulYonetimSistemiVeriTabani.db");
                Statement statement = connection.createStatement();

                statement.execute("insert into idareciler values("+
                        "'"+adTextField.getText()+"',"+
                        "'"+soyadTextField.getText()+"',"+
                        "'"+tcKimlikNumarasiTextField.getText()+"',"+
                        "'"+pozisyonTextField.getText()+"',"+
                        Integer.parseInt(idareciNumarasiTextField.getText())+
                        ")");

                statement.close();
                connection.close();
            }catch (Exception error){
                error.printStackTrace();
            }
            Stage closeStage = (Stage) ekleButton.getScene().getWindow();
            closeStage.close();
        }
    }
}