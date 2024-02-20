package kevin.studi.desktop.details;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import kevin.studi.desktop.tables.ColumnDef;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;

public class AvisTableModel extends AbstractTableModel
{
	public static final Map<Integer, ColumnDef> COLUMNS;

	static
	{
		COLUMNS = new HashMap<>();
		COLUMNS.put(0, new ColumnDef(0, "Identifiant interne", Integer.class));
		COLUMNS.put(1, new ColumnDef(1, "Date début", String.class));
		COLUMNS.put(2, new ColumnDef(2, "Date fin", String.class));
		COLUMNS.put(3, new ColumnDef(3, "Motif", String.class));
		COLUMNS.put(4, new ColumnDef(4, "Description", String.class));
		COLUMNS.put(5, new ColumnDef(5, "Spécialité", String.class));
		COLUMNS.put(6, new ColumnDef(6, "Médecin", String.class));
	}

	private JsonArray data;

	public AvisTableModel(final JsonArray data)
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
		final JsonObject sejour = row.getJsonObject("idSejour");
		final JsonObject specialite = sejour.getJsonObject("idSpecialite");
		final JsonObject medecin = sejour.getJsonObject("idMedecin");

		switch(columnIndex)
		{
			case 0:
				// id
				return row.getInt("id");

			case 1:
				// date debut
				return sejour.getString("dateDebut");

			case 2:
				// date fin
				return sejour.getString("dateFin");

			case 3:
				// motif
				return sejour.getString("motif");

			case 4:
				// description
				return row.getString("description");

			case 5:
				// specialite
				return specialite.getString("label");

			case 6:
				// médecin
				return medecin.getString("prenom") + " " + medecin.getString("nom");
		}

		return null;
	}
}
