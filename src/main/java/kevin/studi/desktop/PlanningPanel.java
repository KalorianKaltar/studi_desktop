/*
 * Created by JFormDesigner on Tue Feb 20 22:14:12 CET 2024
 */

package kevin.studi.desktop;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import kevin.studi.desktop.planning.PlanningTableModel;

import java.awt.*;
import java.util.Optional;
import javax.swing.*;

public class PlanningPanel extends JPanel {
    private PatientDetailPanel detailPanel;

    public PlanningPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        scrollPane1 = new JScrollPane();
        planning = new JTable();

        //======== this ========
        setLayout(new BorderLayout());
        initPlanningTable();

        //======== scrollPane1 ========
        {
            scrollPane1.setMaximumSize(new Dimension(0, 200));
            scrollPane1.setPreferredSize(new Dimension(0, 200));
            scrollPane1.setMinimumSize(new Dimension(0, 200));
            scrollPane1.setViewportView(planning);
        }
        add(scrollPane1, BorderLayout.NORTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JScrollPane scrollPane1;
    private JTable planning;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void initPlanningTable()
    {
        detailPanel = new PatientDetailPanel();
        add(detailPanel, BorderLayout.CENTER);

        planning.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        planning.getSelectionModel().addListSelectionListener(x -> {
            if(!x.getValueIsAdjusting())
            {
                loadDetail();
            }
        });
    }

    public void load()
    {
        final Optional<JsonArray> data = RestClient.getInstance().getPlanning();
	    data.ifPresent(jsonValues -> planning.setModel(new PlanningTableModel(jsonValues)));
    }

    private void loadDetail()
    {
        final JsonObject patient = ((PlanningTableModel)planning.getModel()).getPatient(planning.getSelectedRow());
        if(patient != null)
        {
            detailPanel.load(patient.getInt("id"));
        }
    }
}
