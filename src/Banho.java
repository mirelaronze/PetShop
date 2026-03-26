import java.time.LocalDate;

public class Banho extends Servico {
    private TamanhoPelo tamanhoPelo;

    public Banho(String codigo, TamanhoAnimal tamanhoAnimal, LocalDate data, TamanhoPelo tamanhoPelo) {
        super(codigo, tamanhoAnimal, data);
        this.tamanhoPelo = tamanhoPelo;
    }

    @Override
    public double calculaPreco() {
        return tamanhoAnimal.getPrecoBaseBanho() + tamanhoPelo.getAdicional();
    }

}
