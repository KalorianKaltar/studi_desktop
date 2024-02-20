package kevin.studi.desktop.details;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import kevin.studi.desktop.tables.ColumnDef;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;

public class PrescriptionsTableModel extends AbstractTableModel
{
	public static final Map<Integer, ColumnDef> COLUMNS;

	static
	{
		COLUMNS = new HashMap<>();
		COLUMNS.put(0, new ColumnDef(0, "Medicament", String.class));
		COLUMNS.put(1, new ColumnDef(1, "Posologie", String.class));
		COLUMNS.put(2, new ColumnDef(2, "Date début", String.class));
		COLUMNS.put(3, new ColumnDef(3, "Date fin", String.class));
	}

	private JsonArray data;

	public PrescriptionsTableModel(final JsonArray data)
	{
		this.data = data;
	}

	@Override
	public int getRowCount()
	{
		return data.size();
	}

	@Override
	public int getColumnCount()
	{
		return COLUMNS.size();
	}

	@Override
	public Class<?> getColumnClass(final int columnIndex)
	{
		return COLUMNS.get(columnIndex).getType();
	}

	@Override
	public String getColumnName(final int columnIndex)
	{
		return COLUMNS.get(columnIndex).getName();
	}

	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex)
	{
		final JsonObject row = data.getJsonObject(rowIndex);

		switch (columnIndex)
		{
			case 0:
				// medicament
				return row.getString("medicament");

			case 1:
				// posologie
				return row.getString("posologie");

			case 2:
				// date début
				return row.getString("dateDebut");

			case 3:
				// date fin
				return row.getString("dateFin");
		}

		return null;
	}
}