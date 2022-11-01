package com.example.test1;


import javafx.collections.ObservableList;
request frszimport javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
        if (event.getClickCount() == 2) //Checking double click
        {
            System.out.println("++++++++++++++++++++++!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(frszTable);
        }
    }


    public void setFrszTable() {
        TableColumn frszCol = new TableColumn("frsz");
        TableColumn vinCol = new TableColumn("vin");

        frszCol.setCellFactory(TextFieldTableCell.forTableColumn());
        vinCol.setCellFactory(TextFieldTableCell.forTableColumn());




        frszCol.setCellValueFactory(new PropertyValueFactory<Cars, String>("frsz"));
        vinCol.setCellValueFactory(new PropertyValueFactory<Cars, String>("vin"));

        ActionEvent actionEvent = new ActionEvent();

        frszTable.getColumns().addAll(frszCol,vinCol);

        DB r = new DB();
        ObservableList data = r.getCars();

        frszTable.setItems(data);

    }
    public void setRouteTable(){
        DB r = new DB();
        r.insertData(new Cars("aaa-111","","","","",1,1769.0,55));
        setFrszTable();
    }


}