import java.time.LocalDate;
import java.util.Objects;

public abstract class Servico  {
    protected String codigo;
    protected TamanhoAnimal tamanhoAnimal;
    protected LocalDate data;

    public Servico(String codigo, TamanhoAnimal tamanhoAnimal, LocalDate data) throws PetShopException{
        if(codigo == null || codigo.trim().isEmpty()) {
            throw new PetShopException("O código não pode ser vazio");
        }
        if(tamanhoAnimal == null) {
            throw new PetShopException("O tamanho do animal precisa ser informado");
        }
        if(data == null) {
            throw new PetShopException("A data precisa ser informada");
        }
        this.codigo = codigo;
        this.tamanhoAnimal = tamanhoAnimal;
        this.data = data;
    }

    public abstract double calculaPreco();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws PetShopException {
        if(codigo == null || codigo.trim().isEmpty()) {
            throw new PetShopException("O código não pode ser vazio");
        }
        this.codigo = codigo;
    }

    public TamanhoAnimal getTamanhoAnimal() throws PetShopException {
        if(tamanhoAnimal == null) {
            throw new PetShopException("O tamanho do animal precisa ser informado");
        }
        return tamanhoAnimal;
    }

    public void setTamanhoAnimal(TamanhoAnimal tamanhoAnimal) {
        this.tamanhoAnimal = tamanhoAnimal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws PetShopException{
        if(data == null) {
            throw new PetShopException("A data precisa ser informada");
        }
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(codigo, servico.codigo) && Objects.equals(data, servico.data) && tamanhoAnimal == servico.tamanhoAnimal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, data, tamanhoAnimal);
    }

    @Override
    public String toString() {
        return "Servico{" +
                "codigo='" + codigo + '\'' +
                ", data=" + data +
                ", tamanhoAnimal=" + tamanhoAnimal +
                '}';
    }
}
