package com.example.test1;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;



public class HelloController {

    @FXML
    TableView frszTable;

    @FXML
    public void clickItem(MouseEvent event)
    {
        System.out.println(event.getSource());
    }

    public void setFrszTable() {
        TableColumn frszCol = new TableColumn("frsz");
        TableColumn vinCol = new TableColumn("vin");

        frszCol.setCellFactory(TextFieldTableCell.forTableColumn());
        vinCol.setCellFactory(TextFieldTableCell.forTableColumn());



frszCol.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
    System.out.println("ez választva");
        }
) ;

        frszCol.setCellValueFactory(new PropertyValueFactory<Cars, String>("frsz"));
        vinCol.setCellValueFactory(new PropertyValueFactory<Cars, String>("vin"));
        frszTable.getColumns().addAll(frszCol,vinCol);

        DB r = new DB();
        ObservableList data = r.getCars();

        frszTable.setItems(data);

    }


}

