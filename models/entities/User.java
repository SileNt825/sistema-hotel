package sistemaRevervasHotel.models.entities;


public class User {
    private String email;
    private String senha;
    private boolean logado;
    private String nome;


    public User(String email, String senha, boolean logado, String nome) {
        this.email = email;
        this.senha = senha;
        this.logado = false;
        this.nome = nome;
    }
    public User(String email, String senha){
        this.email = email;
        this.senha = senha;
    }
    public User (String nome){
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuário{" +
                "email='" + email +
                ", senha='" + senha +
                ", logado=" + logado +
                '}';
    }
}





