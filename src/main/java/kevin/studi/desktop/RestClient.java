package kevin.studi.desktop;

import io.devcon5.commons.rest.SimpleRestClient;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;

import java.net.HttpURLConnection;
import java.util.Optional;

public final class RestClient
{
	public static final String BACKEND_URL = "http://kevin.kawaiyume.net";

	private String authToken;

	private RestClient()
	{
		// singleton
	}

	public boolean login(final String username, final String password)
	{
		final JsonObject value = Json.createObjectBuilder()
			.add("username", username)
			.add("password", password)
			.build();

		final SimpleRestClient.Response resp = SimpleRestClient.requestTo(BACKEND_URL + "/api/login_check")
			.acceptJson()
			.sendJson()
			.post(os -> {
				try (JsonWriter w = Json.createWriter(os)) {
					w.writeObject(value);
				}
			});

		if(resp.getStatusCode() == HttpURLConnection.HTTP_OK)
		{
			final JsonObject json = Json.createReader(resp.asInputStream()).readObject();

			authToken = json.getString("token");
			return authToken != null && !authToken.isEmpty();
		}

		return false;
	}

	public Optional<JsonArray> getPlanning()
	{
		final SimpleRestClient.Response resp = SimpleRestClient.requestTo(BACKEND_URL + "/api/secretaire/entree-sortie")
			.auth("Bearer " + authToken)
			.acceptJson()
			.sendJson()
			.get();

		if(resp.getStatusCode() == HttpURLConnection.HTTP_OK)
		{
			final JsonArray json = Json.createReader(resp.asInputStream()).readArray();
			return Optional.ofNullable(json);
		}

		return Optional.empty();
	}

	public Optional<JsonObject> getPatientDetails(final int idPatient)
	{
		final SimpleRestClient.Response resp = SimpleRestClient.requestTo(BACKEND_URL + "/api/secretaire/detail-patient/" + idPatient)
			.auth("Bearer " + authToken)
			.acceptJson()
			.sendJson()
			.get();

		if(resp.getStatusCode() == HttpURLConnection.HTTP_OK)
		{
			final JsonObject json = Json.createReader(resp.asInputStream()).readObject();

			return Optional.ofNullable(json);
		}

		return Optional.empty();
	}

	public static RestClient getInstance()
	{
		return RestClientHolder.INSTANCE;
	}

	private static final class RestClientHolder
	{
		private static final RestClient INSTANCE = new RestClient();

		private RestClientHolder()
		{
		}
	}
}
