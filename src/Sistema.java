import java.util.ArrayList;
import java.util.HashMap;

public class Sistema {

    private HashMap<String, usuario> usuarios = new HashMap<>();
    private usuario usuariologin;
    private HashMap<usuario,ArrayList<Tarefa>> tarefas = new HashMap<>();


    public boolean cadastroUsuario(String nome, String senha){

        if(usuarios.containsKey(nome)) {   //Se o usuário já estiver no HashMap de usuários
            return false;
        }
        //Se não estiver, cadastra

        usuario new_usuario= new usuario(nome,senha);
        usuarios.put(nome,new_usuario);    //Add no hashmap de nome/usuario
        tarefas.put(new_usuario, new ArrayList<>()); //add no haspmap de usuario/lista_tarefas
        return true;
    }

    public boolean login(String nome, String senha){
        usuario usuario_on= usuarios.get(nome);
        if(usuario_on != null && usuario_on.autenticar(senha)){
            usuariologin = usuario_on;
            return true;
        }
        return false;
    }

    public void logout(){
        usuariologin= null;
    }

    //Adicionar tarefas
    public boolean addTarefa(String titulo, String descricao){
        if(usuariologin == null){
            return false;
        }

        Tarefa new_tarefa = new Tarefa(titulo,descricao);
        tarefas.get(usuariologin).add(new_tarefa);
        return true;
    }

    public boolean deleteTarefa(String titulo){
        if(usuariologin == null){
            return false;
        }
        ArrayList<Tarefa> lista_tarefas = tarefas.get(usuariologin);
        for(Tarefa tarefa : lista_tarefas){
            if(tarefa.getTitulo().equalsIgnoreCase(titulo)){
                lista_tarefas.remove(tarefa);
                return true;
            }
        }
        return false;
    }

    public boolean editTarefa(String Atualtitulo,String newTitulo, String newDescricao){
        if(usuariologin == null){
            return false;
        }
        ArrayList<Tarefa> lista_tarefas = tarefas.get(usuariologin);
        for(Tarefa tarefa : lista_tarefas){
            if(tarefa.getTitulo().equalsIgnoreCase(Atualtitulo)){
                tarefa.setTitulo(newTitulo);
                tarefa.setDescricao(newDescricao);
                return true;
            }
        }

        return false;
    }

    //Listar tarefas de um usuário
    public ArrayList<Tarefa> listagem(){
        if(usuariologin == null){
            return null;
        }

        return tarefas.get(usuariologin);
    }

}

