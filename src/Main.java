import br.com.conversor.modelos.ConsultaCode;
import br.com.conversor.modelos.Menu;
import br.com.conversor.modelos.Moeda;
import br.com.conversor.modelos.MoedaExchangeRate;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        Menu menuInicial = new Menu();
        System.out.println(menuInicial);
        int consulta = scanner.nextInt();

        while (consulta != 7) {
            ConsultaCode codigoConsulta = new ConsultaCode();
            codigoConsulta.consultar(consulta);

            String address = "https://v6.exchangerate-api.com/v6/cb14e69b9b23aa1a56afad3f/pair/" + codigoConsulta.getBaseCode() + "/" + codigoConsulta.getTargetCode();

            try{
                // request
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                // response
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                MoedaExchangeRate moedaExchageRate = gson.fromJson(json, MoedaExchangeRate.class);

                Moeda moeda1 = new Moeda(moedaExchageRate);

                System.out.println("Digite o valor que deseja converter: ");
                moeda1.setValorConversao(scanner.nextDouble());

                System.out.println(moeda1);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Menu novoMenu = new Menu();
            System.out.println(novoMenu);
            consulta = scanner.nextInt();
        }
    }
}