package com.example.test1;


import javafx.collections.ObservableList;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;


public class HelloController {

    @FXML
    TableView frszTable;
    @FXML
    TableView routeTable;
    private EventTarget target;

    @FXML
    void onClickTableView(MouseEvent event) {
        System.out.println(getValueAt(frszTable));
       // setRouteTable(getValueAt(frszTable));

    }

    public static String getValueAt(TableView table) {
        TablePosition tp = table.getFocusModel().getFocusedCell();
        Object item = table.getItems().get(tp.getRow());
        TableColumn col = tp.getTableColumn();
        String data = (String) col.getCellObservableValue(item).getValue();
        return data;
    }

    public void setFrszTable() {
        TableColumn frszCol = new TableColumn("frsz");
        TableColumn vinCol = new TableColumn("vin");

        frszCol.setCellFactory(TextFieldTableCell.forTableColumn());
        vinCol.setCellFactory(TextFieldTableCell.forTableColumn());


        frszCol.setCellValueFactory(new PropertyValueFactory<Cars, String>("frsz"));
        vinCol.setCellValueFactory(new PropertyValueFactory<Cars, String>("vin"));


        frszTable.getColumns().addAll(frszCol, vinCol);

        DB r = new DB();
        ObservableList data = r.getCars();

        frszTable.setItems(data);

    }

    public void setRouteTable(String frsz) {
        routeTable.getColumns().clear();
        TableColumn vinCol = new TableColumn("Út");

        vinCol.setCellFactory(TextFieldTableCell.forTableColumn());
        vinCol.setCellValueFactory(new PropertyValueFactory<carRoute, String>("route") );


        routeTable.getColumns().addAll(vinCol);
        DB r = new DB();

        ObservableList data = r.getRoutes(frsz);

        routeTable.setItems(data);

    }

// // routeTable
}

