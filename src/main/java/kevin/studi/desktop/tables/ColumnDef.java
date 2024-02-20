package kevin.studi.desktop.tables;

public class ColumnDef
{
	private final int position;

	private final Class<?> type;

	private final String name;

	public ColumnDef(final int position, final String name, final Class<?> type)
	{
		this.position = position;
		this.name = name;
		this.type = type;
	}

	public Class<?> getType()
	{
		return type;
	}

	public String getName()
	{
		return name;
	}
}
