/*
 * Created by JFormDesigner on Tue Feb 20 21:35:51 CET 2024
 */

package kevin.studi.desktop;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Component currentPanel;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        topPanel = new JPanel();
        label1 = new JLabel();

        //======== this ========
        setTitle("H\u00f4pital SoigneMoi!");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== topPanel ========
        {
            topPanel.setPreferredSize(new Dimension(0, 50));
            topPanel.setBackground(new Color(0x007bff));
            topPanel.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText("Bienvenue \u00e0 l'H\u00f4pital SoigneMoi");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Droid Sans", Font.BOLD, 14));
            topPanel.add(label1, BorderLayout.CENTER);
        }
        contentPane.add(topPanel, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel topPanel;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void loadLogin()
    {
        final LoginPanel loginPanel = new LoginPanel();
        loginPanel.getBtnLogin().addActionListener(e -> EDTHelper.exec(() -> onLogin(loginPanel.getTfEmail().getText(), new String(loginPanel.getPassfPassword().getPassword()))));

        load(loginPanel);
    }

    public void loadPlanning()
    {
        final PlanningPanel planningPanel = new PlanningPanel();
        planningPanel.load();

        load(planningPanel);

        label1.setText("Entrée / Sortie du jour");
    }

    private void onLogin(final String username, final String password)
    {
        if(RestClient.getInstance().login(username, password))
        {
            loadPlanning();
        }
    }

    private void load(final Component newPanel)
    {
        EDTHelper.inEDT(() -> {
            if(currentPanel != null)
            {
                remove(currentPanel);
            }

            currentPanel = newPanel;
            add(currentPanel, BorderLayout.CENTER);

            /*invalidate();
            repaint();*/

            // force rafraichissement, on devrait utiliser invalidate() et repaint()
            setSize(getWidth() + 1, getHeight());
            setSize(getWidth() - 1, getHeight());
        }, () -> load(newPanel));
    }
}
