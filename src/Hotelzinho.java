import java.time.LocalDate;
import java.util.Objects;

public class Hotelzinho extends Servico {
    private int horas;

    public Hotelzinho(String codigo, TamanhoAnimal tamanhoAnimal, LocalDate data, int horas) throws PetShopException {
        super(codigo, tamanhoAnimal, data);
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hotelzinho that = (Hotelzinho) o;
        return horas == that.horas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), horas);
    }

    @Override
    public double calculaPreco() {
        return horas * tamanhoAnimal.getPrecoHoraHotel();
    }

    @Override
    public String toString() {
        return "Hotelzinho{" +
                "horas=" + horas +
                '}';
    }
}

