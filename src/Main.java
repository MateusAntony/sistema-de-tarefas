import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        while(true){
            System.out.println("/n------Gerenciador de tarefa--------");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Login");
            System.out.println("3. Adicionar tarefa");
            System.out.println("4. Listar tarefas");
            System.out.println("5. Logout");
            System.out.println("6. Sair");
            System.out.println("7. Editar tarefa");
            System.out.println("8. Excluir tarefa");

            System.out.print("Escolha uma opção: ");
            int op= scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nome de usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    if (sistema.cadastroUsuario(nome, senha)) {
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("Usuário já existe.");
                    }
                    break;

                case 2:
                    System.out.print("Nome de usuário: ");
                    nome = scanner.nextLine();
                    System.out.print("Senha: ");
                    senha = scanner.nextLine();
                    if (sistema.login(nome, senha)) {
                        System.out.println("Login realizado com sucesso!");
                    } else {
                        System.out.println("Nome de usuário ou senha incorretos.");
                    }
                    break;

                case 3:
                    System.out.print("Título da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    if (sistema.addTarefa(titulo, descricao)) {
                        System.out.println("Tarefa adicionada!");
                    } else {
                        System.out.println("Erro: Nenhum usuário logado.");
                    }
                    break;

                case 4:
                    var tarefas = sistema.listagem();
                    if (tarefas == null) {
                        System.out.println("Erro: Nenhum usuário logado.");
                    } else if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("\n--- Suas Tarefas ---");
                        for (Tarefa tarefa : tarefas) {
                            System.out.println(tarefa);
                        }
                    }
                    break;

                case 5:
                    sistema.logout();
                    System.out.println("Logout realizado.");
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                case 7:
                    System.out.print("Título da tarefa: ");
                    String Atualtitulo = scanner.nextLine();
                    System.out.print("Titulo novo:");
                    String new_titulo=scanner.nextLine();
                    System.out.println("Descrição nova:");
                    String new_descricao=scanner.nextLine();
                    if (sistema.editTarefa(Atualtitulo,new_titulo, new_descricao)) {
                        System.out.println("Tarefa editada!");
                    }
                    else{
                        System.out.println("Erro ao editar tarefa");
                    }
                    break;

                case 8:
                    System.out.print("Titulo:");
                    String titulo_excluir = scanner.nextLine();
                    if (sistema.deleteTarefa(titulo_excluir)) {
                        System.out.println("Tarefa excluida!");
                    }
                    else {
                        System.out.println("Erro ao excluir tarefa");

                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

     }
}