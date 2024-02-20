/*
 * Created by JFormDesigner on Tue Feb 20 23:22:39 CET 2024
 */

package kevin.studi.desktop;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import kevin.studi.desktop.details.AvisTableModel;
import kevin.studi.desktop.details.PrescriptionsTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class PatientDetailPanel extends JPanel {
    public PatientDetailPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        label1 = new JLabel();
        tfID = new JTextField();
        label2 = new JLabel();
        tfEMail = new JTextField();
        label3 = new JLabel();
        tfNom = new JTextField();
        label4 = new JLabel();
        tfPrenom = new JTextField();
        label5 = new JLabel();
        tfAddresse = new JTextField();
        label6 = new JLabel();
        tfComplement = new JTextField();
        label7 = new JLabel();
        tfCodePostal = new JTextField();
        scrollPane3 = new JScrollPane();
        avis = new JTable();
        scrollPane4 = new JScrollPane();
        prescriptions = new JTable();

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0, 1.0E-4};

            //---- label1 ----
            label1.setText("ID");
            panel1.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(tfID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label2 ----
            label2.setText("EMail");
            panel1.add(label2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(tfEMail, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label3 ----
            label3.setText("Nom");
            panel1.add(label3, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(tfNom, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label4 ----
            label4.setText("Pr\u00e9nom");
            panel1.add(label4, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(tfPrenom, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label5 ----
            label5.setText("Adresse");
            panel1.add(label5, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(tfAddresse, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label6 ----
            label6.setText("Compl\u00e9ment");
            panel1.add(label6, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(tfComplement, new GridBagConstraints(5, 1, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label7 ----
            label7.setText("Code postal");
            panel1.add(label7, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(tfCodePostal, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(avis);
            }
            panel1.add(scrollPane3, new GridBagConstraints(0, 3, 8, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== scrollPane4 ========
            {
                scrollPane4.setViewportView(prescriptions);
            }
            panel1.add(scrollPane4, new GridBagConstraints(0, 4, 8, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel1;
    private JLabel label1;
    private JTextField tfID;
    private JLabel label2;
    private JTextField tfEMail;
    private JLabel label3;
    private JTextField tfNom;
    private JLabel label4;
    private JTextField tfPrenom;
    private JLabel label5;
    private JTextField tfAddresse;
    private JLabel label6;
    private JTextField tfComplement;
    private JLabel label7;
    private JTextField tfCodePostal;
    private JScrollPane scrollPane3;
    private JTable avis;
    private JScrollPane scrollPane4;
    private JTable prescriptions;
        // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void load(final int idPatient)
    {
        final Optional<JsonObject> optData = RestClient.getInstance().getPatientDetails(idPatient);
        if(optData.isPresent())
        {
            final JsonObject details = (JsonObject) optData.get().values().toArray()[0];

            final JsonObject patientData = details.getJsonObject("sejour").getJsonObject("idPatient");
            tfID.setText(String.valueOf(patientData.getInt("id")));
            tfEMail.setText(getString(patientData, "email"));
            tfPrenom.setText(getString(patientData, "prenom"));
            tfNom.setText(getString(patientData, "nom"));
            tfAddresse.setText(getString(patientData, "adresse"));
            tfComplement.setText(getString(patientData, "adresseComplement"));
            tfCodePostal.setText(getString(patientData, "codePostal"));

            final JsonArray avisData = details.getJsonArray("avis");
            avis.setModel(new AvisTableModel(avisData));

            final JsonArray prescriptionsData = details.getJsonArray("prescriptions");
            prescriptions.setModel(new PrescriptionsTableModel(prescriptionsData));
        }
    }

    private static String getString(final JsonObject patient, final String champ)
    {
        try
        {
            return patient.getString(champ);
        }
        catch(final ClassCastException ignored)
        {
            return "";
        }
    }
}
