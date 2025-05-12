import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConvertirMoneda {
    private String claveApi;

    public ConvertirMoneda(String claveApi) {
        this.claveApi = claveApi;
    }

    public double convertir(String desde, String hacia, double monto) throws Exception{
        String url_str = "https://v6.exchangerate-api.com/v6/" + claveApi + "/latest/" + desde;

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String resultado = jsonobj.get("result").getAsString();
        if (!resultado.equals("success")) {
            throw new Exception("No se pudo obtener la tasa de cambio.");
        }

        JsonObject tasas = jsonobj.getAsJsonObject("conversion_rates");
        double tasa = tasas.get(hacia).getAsDouble();

        return monto * tasa;

    }
}
