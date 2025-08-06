import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        var name = lerNomeCompleto(scanner);
        var saldo = lerSaldo(scanner);

        ContaTerminal contaTerminal = new ContaTerminal(new Person(name), saldo);
        System.out.println(contaTerminal.exibirInfor());

        scanner.close();
    }
    private static String lerNomeCompleto(Scanner scanner){
        String name = "";
        System.out.println("Por favor, digite seu nome completo:");
        while (true){
            name = scanner.nextLine().strip();
            if(!name.isEmpty()){
                break;
            } else {
                System.out.println("Nome inválido, por favor digite novamente.");
            }
        }
        return name;
    }

    private static BigDecimal lerSaldo(Scanner scanner){
        BigDecimal saldo = BigDecimal.ZERO;
        while (true) {
            System.out.println("Por favor, digite o valor do seu primeiro depósito:");
            try {
                saldo = scanner.nextBigDecimal();
                if (saldo.compareTo(BigDecimal.ZERO) > 0) {
                    break;
                } else {
                    System.out.println("O valor deve ser maior que zero. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Use apenas números (ex: 100.50)");
                scanner.nextLine();
            }
        }
        return saldo;
    }

}




