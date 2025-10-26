package sistemaRevervasHotel.models.entities;

import java.util.ArrayList;
import java.util.List;


public class SistemaLogin {
    private final List<User> usuarios = new ArrayList<>();
    private User usuarioLogado;

    public boolean autenticar(String email, String senha) {
        for (User users : usuarios) {
            if (users.getEmail().equals(email) && users.getSenha().equals(senha)) {
                users.setLogado(true);
                usuarioLogado = users;
                System.out.println("Login realizado com sucesso!");
                return true;
            }
        }
        System.out.println("Esse usuário não existe. Tente novamente.");
        return false;
    }

    public void registrarUsuario(User usuarioLogado){
        usuarios.add(usuarioLogado);
        usuarioLogado.setLogado(true);
        System.out.println("Usuário cadastrado com sucesso!");
    }
    public User getUsuarioLogado() {
        return usuarioLogado;
    }

    public void logout(){
        if(usuarioLogado != null){

            String email = usuarioLogado.getEmail();
            String firstName = email.split("@")[0];

            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            usuarioLogado.setLogado(false);
            System.out.println("Logout realizado com sucesso. Sentiremos sua falta " + firstName + "!");
            usuarioLogado = null;
        } else {
            System.out.println("Usuário não encontrado para logout.");
        }
    }



    public void listarUsuarios(){
        if(usuarios.isEmpty()){
            System.out.println("Nenhum usuário encontrado.");
            return;
        }
        System.out.println("Usuários cadastrados: ");
        for(User usuario: usuarios){
            System.out.println("- " + usuario.getEmail() + (usuario.isLogado() ? " (logado)" : ""));
        }
    }

}
