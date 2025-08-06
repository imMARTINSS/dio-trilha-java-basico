import java.math.BigDecimal;
import java.util.Random;

public class ContaTerminal {

    private final int numeroConta;
    private final String agencia;
    private final BigDecimal saldo;
    private final Person titular;

    public ContaTerminal(Person titular, BigDecimal saldo){
        this.numeroConta = geradoNumero();
        this.agencia = geradoAgencia();
        this.saldo = saldo;
        this.titular = titular;
    }

    private int geradoNumero(){
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }

    private String geradoAgencia(){
        Random random = new Random();
        var agencia = 1000 + random.nextInt(9000);
        var string = String.valueOf(agencia);
        return String.format("%s-%S", string.substring(0,3), string.charAt(3));
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String exibirInfor(){

        return String.format("\nOlá %S, " +
                "obrigado por criar uma conta em nosso banco, sua agência é %s, " +
                "conta %d e seu saldo %.2f já está disponível para saque.", titular.getName(),getAgencia(),getNumeroConta(), saldo);
    }

    @Override
    public String toString() {
        return String.format("Name:%s | Agência:%s | Numero: %d | Saldo: R$:%.2f",titular.getName(), agencia, numeroConta, saldo);
    }

}