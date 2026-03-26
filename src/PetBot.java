import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PetBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Servico> servicos =  new ArrayList<>();
        boolean lojaAberta = true;

        System.out.println("===CHATBOT PETSHOP===");
        System.out.println("Primeiro, como posso te chamar?");
        String nome = sc.nextLine();
        System.out.println("\nOlá, " + nome + "! Vou te ajudar com os registros de hoje.");

        while (lojaAberta) {
            System.out.println("O que desja fazer agora?");
            System.out.println("==MENU==");
            System.out.println("1: Banho | 2: Tosa | 3: Hotel | 0: Fechar Loja");
            System.out.println("Opção: ");
            String opcao = sc.nextLine();

            if(opcao.equals("0")) {
                lojaAberta = false;
                continue;
            }
            try {
                System.out.println("Digite o código do servico: ");
                String codigo = sc.nextLine();

                System.out.println("Porte do animal (pequeno, médio ou grande): ");
                TamanhoAnimal tamanho = TamanhoAnimal.valueOf(sc.nextLine().toUpperCase());

                switch (opcao) {
                    case "1":
                        System.out.println("Tamanho do pelo(curto, médio ou longo): ");
                        TamanhoPelo pelo = TamanhoPelo.valueOf(sc.nextLine().toUpperCase());
                        servicos.add(new Banho(codigo, tamanho, LocalDate.now(), pelo));
                        System.out.println("Banho registrado");
                        break;
                    case "2":
                        servicos.add(new Tosa(codigo, tamanho, LocalDate.now()));
                        System.out.println("Tosa registrada");
                        break;
                    case "3":
                        System.out.println("Quantidade de horas: ");
                        int hrs = Integer.parseInt(sc.nextLine());
                        servicos.add(new Hotelzinho(codigo, tamanho, LocalDate.now(), hrs));
                        System.out.println("Estadia registrada");
                        break;
                    default:
                        System.out.println("Essa opção não existe " + nome + "!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro! Você digitou um porte ou pelo que não existe no sistema");
            } catch (PetShopException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());

            }

        }
        fecharLoja(servicos, nome);
        sc.close();

    }

    public static void fecharLoja(ArrayList<Servico> lista, String nome) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Relatório de encerramento - " + nome);
        System.out.println("=".repeat(40));

        double total = 0;
        for(Servico s: lista) {
            double valor = s.calculaPreco();
            total += valor;
            System.out.printf("[%s] - %-10s | R$ %.2f%n",s.getCodigo(), s.getClass().getSimpleName(), valor);
        }
        System.out.println("-".repeat(40));
        System.out.printf("Faturamento total do dia: R$ %.2f%n", total);
        System.out.println("=".repeat(40));
        System.out.println("Até a próxima! :)");
    }
}
