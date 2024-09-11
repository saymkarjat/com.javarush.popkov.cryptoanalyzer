package org.example.com_javarush_popkov_cryptoanalyzer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Path;

public class CryptoInterfaceController {
    FileManager fileManager;
    File file;
    @FXML
    private Button button;
    @FXML
    private TextField keyEncrypt;
    @FXML
    private TextField outputTextFieldEncrypt;


    @FXML
    protected void onOpenFileButtonClick() {

        // ПО НАЖАТИЮ НА КНОПКУ "ОТКРЫТЬ ФАЙЛ" ИЗ ИНТЕРФЕЙСА (fxml)
        // ВЫЗЫВАЕТСЯ МЕТОД КОНТРОЛЛЕРА onOpenFileButtonClick()
        FileChooser fileChooser = new FileChooser();
        // УСТАНАВЛИВАЕМ ЗАГОЛОВОК ОКНА
        fileChooser.setTitle("ОТКРЫТЬ ФАЙЛ");
        // В МОМЕНТ ВЫБОРА ФАЙЛА ПУТЬ К НЕМУ ЗАПИШЕТСЯ В ПЕРЕМЕННУЮ file
        file = fileChooser.showOpenDialog(new Stage());

        // ВЫВОДИМ ИМЯ ФАЙЛА В КОНСОЛЬ, ИЛИ ИСПОЛЬЗУЕМ ПО НАЗНАЧЕНИЮ
    }

    @FXML
    protected void onEncryptButtonClick() {
        int key = Integer.parseInt(keyEncrypt.getText());
        if (Validator.isValidKey(key)){
            outputTextFieldEncrypt.setText(fileManager.writeFile(Cipher.encrypt(fileManager.readFile(String.valueOf(file)), key), "@/output_text"));
        }
        else outputTextFieldEncrypt.setText("ключ не подходит");
    }

}
