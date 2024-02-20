package kevin.studi.desktop.planning;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import kevin.studi.desktop.tables.ColumnDef;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;

public class PlanningTableModel extends AbstractTableModel
{
	public static final Map<Integer, ColumnDef> COLUMNS;

	static
	{
		COLUMNS = new HashMap<>();
		COLUMNS.put(0, new ColumnDef(0, "Identifiant interne", Integer.class));
		COLUMNS.put(1, new ColumnDef(1, "Identifiant patient", Integer.class));
		COLUMNS.put(2, new ColumnDef(2, "Nom patient", String.class));
		COLUMNS.put(3, new ColumnDef(3, "Prénom patient", String.class));
		COLUMNS.put(4, new ColumnDef(4, "Date début", String.class));
		COLUMNS.put(5, new ColumnDef(5, "Date fin", String.class));
		COLUMNS.put(6, new ColumnDef(6, "Motif", String.class));
		COLUMNS.put(7, new ColumnDef(7, "Spécialité", String.class));
		COLUMNS.put(8, new ColumnDef(8, "Médecin", String.class));
	}

	private JsonArray data;

	public PlanningTableModel(final JsonArray data)
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
		final JsonObject patient = row.getJsonObject("idPatient");
		final JsonObject specialite = row.getJsonObject("idSpecialite");
		final JsonObject medecin = row.getJsonObject("idMedecin");

		switch(columnIndex)
		{
			case 0:
				// id
				return row.getInt("id");

			case 1:
				// id patient
				return patient.getInt("id");

			case 2:
				// nom patient
				return patient.getString("nom");

			case 3:
				// prénom patient
				return patient.getString("prenom");

			case 4:
				// date début
				return row.getString("dateDebut");

			case 5:
				// date fin
				return row.getString("dateFin");

			case 6:
				// motif
				return row.getString("motif");

			case 7:
				// specialite
				return specialite.getString("label");

			case 8:
				// médecin
				return medecin.getString("prenom") + " " + medecin.getString("nom");
		}

		return null;
	}

	public JsonObject getPatient(final int rowIndex)
	{
		final JsonObject row = data.getJsonObject(rowIndex);
		return row.getJsonObject("idPatient");
	}
}
