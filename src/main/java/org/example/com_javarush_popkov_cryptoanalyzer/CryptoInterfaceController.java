package org.example.com_javarush_popkov_cryptoanalyzer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;

public class CryptoInterfaceController {
    public static File file;
    @FXML
    public TextField keyDecrypt;
    @FXML
    public TextField outputTextFieldDecrypt;
    @FXML
    public TextField outputTextBruteForce;
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
       try {
           if (!Validator.isFileExists(String.valueOf(file))){
               throw new FileNotFoundException();
           }
       }
       catch (FileNotFoundException e){
           throw new RuntimeException("File not exist");
       }

        // ВЫВОДИМ ИМЯ ФАЙЛА В КОНСОЛЬ, ИЛИ ИСПОЛЬЗУЕМ ПО НАЗНАЧЕНИЮ
        System.out.println(file);
    }

    @FXML
    protected void onEncryptButtonClick() {
        int key = Integer.parseInt(keyEncrypt.getText());
        if (Validator.isValidKey(key)){
            outputTextFieldEncrypt.setText(FileManager.writeFile(Cipher.encrypt(FileManager.readFile(String.valueOf(file)), key), FileManager.DIRECTORY_PATH));
        }
        else outputTextFieldEncrypt.setText("ключ не подходит");
    }

    @FXML
    protected void onDecryptButtonClick() {
        int key = Integer.parseInt(keyDecrypt.getText());
        if (Validator.isValidKey(key)){
            outputTextFieldDecrypt.setText(FileManager.writeFile(Cipher.decrypt(FileManager.readFile(String.valueOf(file)), key), FileManager.DIRECTORY_PATH));
        }
        else outputTextFieldDecrypt.setText("ключ не подходит");
    }
    @FXML
    protected void onBruteForceButtonClick() {
        outputTextBruteForce.setText(FileManager.writeFile(BruteForce.decryptByBruteForce(FileManager.readFile(String.valueOf(file))), FileManager.DIRECTORY_PATH));

    }

}
