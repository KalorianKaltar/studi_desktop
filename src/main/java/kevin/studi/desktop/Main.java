package kevin.studi.desktop;

import javax.swing.*;

public class Main
{
	public static void main(final String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		for(final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
		{
			if("nimbus".equalsIgnoreCase(info.getName()))
			{
				UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}

		final MainFrame p = new MainFrame();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SwingUtilities.invokeLater(() ->
		{
			p.setSize(800, 800);
			p.setVisible(true);
			p.setLocationRelativeTo(null);
			p.loadLogin();
		});
	}
}
