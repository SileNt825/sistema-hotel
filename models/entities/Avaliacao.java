package sistemaRevervasHotel.models.entities;

public class Avaliacao {
    private int nota;
    private String comentario;
    private User usuario;
    Hospede hospede;
    Quarto quarto;

    public Avaliacao(int nota, String comentario, User usuario, Quarto quarto, Hospede hospede) {
        this.nota = nota;
        this.comentario = comentario;
        this.usuario = usuario;
        this.hospede = hospede;
        this.quarto = quarto;
    }

    public Avaliacao(Hospede nota, Quarto comentario, int usuario, String hotel) {
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "hóspede" + (hospede != null ? hospede.getNome() : "desconhecido") +
                ", quarto='" + (quarto != null ? quarto.getNumero() : "quarto nao encontrado") + '\'' +
                ", usuario=" + usuario +
                ", hospede=" + hospede +
                ", comentário=" + comentario +
                ", nota= " + nota +
                '}';
    }
}
