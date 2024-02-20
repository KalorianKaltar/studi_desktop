/*
 * Created by JFormDesigner on Tue Feb 20 21:53:53 CET 2024
 */

package kevin.studi.desktop;

import java.awt.*;
import javax.swing.*;

public class LoginPanel extends JPanel {
    public LoginPanel() {
        initComponents();
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public JPasswordField getPassfPassword() {
        return passfPassword;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        form = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        tfEmail = new JTextField();
        label3 = new JLabel();
        passfPassword = new JPasswordField();
        btnLogin = new JButton();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        //======== form ========
        {
            form.setMaximumSize(new Dimension(200, 200));
            form.setPreferredSize(new Dimension(200, 200));
            form.setMinimumSize(new Dimension(200, 200));
            form.setLayout(new GridBagLayout());
            ((GridBagLayout)form.getLayout()).columnWeights = new double[] {1.0};

            //---- label1 ----
            label1.setText("Connexion");
            label1.setFont(new Font("Noto Sans", Font.BOLD, 14));
            form.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label2 ----
            label2.setText("E-mail");
            form.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(10, 0, 0, 0), 0, 0));

            //---- tfEmail ----
            tfEmail.setText("s.r@studisoignemoi.fr");
            form.add(tfEmail, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label3 ----
            label3.setText("Mot-de-Passe");
            form.add(label3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(10, 0, 0, 0), 0, 0));

            //---- passfPassword ----
            passfPassword.setText("temp_123");
            form.add(passfPassword, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- btnLogin ----
            btnLogin.setText("Se connecter");
            form.add(btnLogin, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(15, 0, 0, 0), 0, 0));
        }
        add(form, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel form;
    private JLabel label1;
    private JLabel label2;
    private JTextField tfEmail;
    private JLabel label3;
    private JPasswordField passfPassword;
    private JButton btnLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
