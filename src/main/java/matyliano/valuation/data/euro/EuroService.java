package matyliano.valuation.data.euro;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Service
public class EuroService {


    public String dateTime(){
        LocalDateTime today = LocalDateTime.now();

        if(today.getDayOfWeek() == DayOfWeek.SATURDAY){
            today = LocalDateTime.now().minusDays(1);
        }

        if(today.getDayOfWeek() == DayOfWeek.SUNDAY){
            today = LocalDateTime.now().minusDays(2);
        }

        return today.toString();
    }


    public String euroLastApplicableValue() throws IOException {

        LocalDateTime today = LocalDateTime.now();

        if(today.getDayOfWeek() == DayOfWeek.SATURDAY){
            today = LocalDateTime.now().minusDays(1);
        }

        if(today.getDayOfWeek() == DayOfWeek.SUNDAY){
            today = LocalDateTime.now().minusDays(2);
        }

        StringBuffer sentenceBuilder = new StringBuffer();
        String currentDate = today.toString();
        StringBuffer dateBuffer = new StringBuffer("http://api.nbp.pl/api/exchangerates/rates/a/eur/").append(currentDate).append("/?format=json");
        String date = dateBuffer.toString();

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(date);
        HttpResponse execute = httpClient.execute(httpGet);

        String nbpEuroInfo = new BasicResponseHandler().handleResponse(execute);

        JsonParser jsonParser = new JsonParser();
        JsonElement baseJsonElement = jsonParser.parse(nbpEuroInfo);
        JsonObject baseJsonObject = baseJsonElement.getAsJsonObject();
        JsonArray ratesJsonArray = baseJsonObject.get("rates").getAsJsonArray();
        JsonObject ratesJsonObject = ratesJsonArray.get(0).getAsJsonObject();
        String rates = ratesJsonObject.get("mid").getAsString();
        sentenceBuilder.append(rates);

        return sentenceBuilder.toString();
    }
}
