package kevin.studi.desktop;

import javax.swing.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class EDTHelper
{
	private static final Executor edtThreadExecutor = Executors.newFixedThreadPool(2);

	private EDTHelper()
	{
		// utility class
	}

	public static void inEDT(final Runnable ifInEDT, final Runnable ifNotInEDT)
	{
		if(SwingUtilities.isEventDispatchThread())
		{
			ifInEDT.run();
		}
		else
		{
			SwingUtilities.invokeLater(ifNotInEDT);
		}
	}

	public static void exec(final Runnable r)
	{
		edtThreadExecutor.execute(r);
	}
}
