package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button okulYonetimSistemiButton;
    @FXML
    private Button anaSayfaButton;
    @FXML
    private Button idarecilerButton;
    @FXML
    private Button ogretmenlerButton;
    @FXML
    private Button ogrencilerButton;
    @FXML
    private Button cikisButton;
    @FXML
    private Button dersProgramlariButton;

    public void setButton(ActionEvent actionEvent) {
        if (actionEvent.getSource() == okulYonetimSistemiButton) {
           try{
               Stage closeStage = (Stage) okulYonetimSistemiButton.getScene().getWindow();
               Stage stage = new Stage();
               Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
               stage.setScene(new Scene(root, 1280, 800));
               stage.setResizable(false);
               stage.show();
               closeStage.close();
           }catch (Exception error){
               error.printStackTrace();
           }
        } else if (actionEvent.getSource() == anaSayfaButton) {
            try {
                Stage closeStage = (Stage) anaSayfaButton.getScene().getWindow();
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                stage.setScene(new Scene(root, 1280, 800));
                stage.setResizable(false);
                stage.show();
                closeStage.close();
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else if (actionEvent.getSource() == idarecilerButton) {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("idarecilerPackage/idareciler.fxml"));
                stage.setScene(new Scene(root, 460, 800));
                stage.setResizable(false);
                stage.show();
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else if (actionEvent.getSource() == ogretmenlerButton) {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("ogretmenlerPackage/ogretmenler.fxml"));
                stage.setScene(new Scene(root, 475, 800));
                stage.setResizable(false);
                stage.show();
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else if (actionEvent.getSource() == ogrencilerButton) {
            try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ogrencilerPackage/ogrenciler.fxml"));
            stage.setScene(new Scene(root, 460, 800));
            stage.setResizable(false);
            stage.show();
        } catch (Exception error) {
            error.printStackTrace();
        }
        } else if (actionEvent.getSource() == cikisButton) {
            try {
                Stage closeStage = (Stage) cikisButton.getScene().getWindow();
                closeStage.close();
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else if (actionEvent.getSource() == dersProgramlariButton) {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("dersProgramlariPackage/dersProgramlari.fxml"));
                stage.setScene(new Scene(root, 620, 876.5));
                stage.setResizable(true);
                stage.show();
            } catch (Exception error) {
                error.printStackTrace();
            }
        }
    }
}