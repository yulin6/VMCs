package handler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import main.Start;
import view.BaseView;
import view.SimulatorControlPanelView;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class SimulatorControlPanelController implements Initializable {

    @FXML
    private Button beginSimulation;
    @FXML
    private Button endSimulation;
    @FXML
    private Button customerPanel;
    @FXML
    private Button maintainerPanel;
    @FXML
    private Button machineryPanel;

//    @FXML
//    protected void onHelloButtonClick() {
//
//    }

//    @FXML
//    public void initialize(Start startObj) {
//
//        List<Panel> activatePanels = startObj.getActivatingPanels();
//        for (Panel panel: activatePanels) {
//            Button button = new Button("Activate " + panel.name);
//            button.setId(panel.name);
//            VBActiveButtons.getChildren().add(button);
//        }
//    }



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println("test");
    }

    public void handleButtonAction(ActionEvent actionEvent) {
        SimulatorControlPanelView view = (SimulatorControlPanelView) Start.views.get("simulatorControlPanelView");
        Button button = (Button)actionEvent.getSource();
        switch (button.getId()) {
            case "beginSimulation":
                beginSimulation();
                break;
            case "endSimulation":
                endSimulation();
                break;
            case "customerPanel":
                if (checkSimulationStatus()) {
                    activePanel("customerPanelView");
                } else {
                    view.createAlert(Alert.AlertType.WARNING, "System hasn't begun the simulation yet!");
                }
                break;
            case "maintainerPanel":
                if (checkSimulationStatus()) {
                    activePanel("maintainerPanelView");
                } else {
                    view.createAlert(Alert.AlertType.WARNING, "System hasn't begun the simulation yet!");
                }
                break;
            case "machineryPanel":
                if (checkSimulationStatus()) {
                    activePanel("machineryPanelView");
                } else {
                    view.createAlert(Alert.AlertType.WARNING, "System hasn't begun the simulation yet!");
                }
                break;
        }
    }

    private boolean checkSimulationStatus() {
        return  Start.jsonMachineConverter.getSimulationStatus();
    }

    private void beginSimulation() {
        Start.jsonMachineConverter.beginSimulation();
    }

    private void endSimulation() {
        Start.jsonMachineConverter.endSimulation();
        Iterator<String> iterator = Start.views.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            if (!key.equals("simulatorControlPanelView")) {
                Start.views.get(key).exit();
            }
        }
    }

    public void activePanel(String viewName) {
        try {
            Start.views.get(viewName).init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

    }

}