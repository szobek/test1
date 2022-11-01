package com.example.test1;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class HelloController {
    @FXML
    Label label;
    @FXML
    TableView frszTable;

    public void setLabel() {
        label.setText("valami");
    }


    public void setFrszTable() {
        TableColumn frszCol = new TableColumn("frsz");
        TableColumn vinCol = new TableColumn("vin");
        frszCol.setCellFactory(TextFieldTableCell.forTableColumn());
        vinCol.setCellFactory(TextFieldTableCell.forTableColumn());
        frszCol.setCellValueFactory(new PropertyValueFactory<Cars, String>("frsz"));
        vinCol.setCellValueFactory(new PropertyValueFactory<Cars, String>("vin"));
        frszTable.getColumns().addAll(frszCol,vinCol);
        DB r = new DB();
        ObservableList data = r.fn();

        frszTable.setItems(data);
    }


}