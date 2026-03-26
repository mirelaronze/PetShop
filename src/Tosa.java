import java.time.LocalDate;

public class Tosa extends Servico {
    public Tosa(String codigo, TamanhoAnimal tamanhoAnimal, LocalDate data) throws PetShopException {
        super(codigo, tamanhoAnimal, data);
    }

    @Override
    public double calculaPreco() {
        return tamanhoAnimal.getPrecoTosa();
    }

    @Override
    public String toString() {
        return "Tosa{" +
                "codigo='" + codigo + '\'' +
                ", data=" + data +
                ", tamanhoAnimal=" + tamanhoAnimal +
                '}';
    }
}
