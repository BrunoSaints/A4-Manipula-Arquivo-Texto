import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class manipulaArquivoCsv {
    public final String DELIMITADOR_PONTO_VIRGULA = ";";
    public final String DELIMITADOR_VIRGULA = ",";
    public static void main(String[] args) {
        manipulaArquivoCsv csv = new manipulaArquivoCsv();
        List<List<String>> registroDados = csv.leitura();
        csv.imprimeDados(registroDados);
    }
    public List<List<String>> registroDados = new ArrayList<>();
    try {
        File arquivo = new File("dados/dadosclientes.csv");
        Scanner sc = new Scanner(arquivo);
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            registroDados.add(getRegistroDaLinha(linha));
        }
    } catch (FileNotFoundException ex) {
        System.out.printf("Erro na abertura do arquivo: %s.%n", ex.getMessage());
        System.exit(0);
    }
    return registroDados;
}