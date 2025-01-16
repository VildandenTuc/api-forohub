package foro.hub.api.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private String fecha;
    private String status;
    private String autor;
    private String curso;


    public Long getId() {return id;}

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public String getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public Topico() {
    }

    public Topico(DatosCrearTopico datosCrearTopico) {
        this.titulo = datosCrearTopico.titulo();
        this.mensaje = datosCrearTopico.mensaje();
        this.fecha = datosCrearTopico.fecha();
        this.status = datosCrearTopico.status();
        this.autor = datosCrearTopico.autor();
        this.curso = datosCrearTopico.curso();
    }

    public void actualizarTopico(@Valid DatosListarTopico datosListarTopico) {
        if (datosListarTopico.titulo() != null){
            this.titulo = datosListarTopico.titulo();
        }
        if (datosListarTopico.mensaje() != null){
            this.mensaje = datosListarTopico.mensaje();
        }
        if (datosListarTopico.fecha() != null){
            this.fecha = datosListarTopico.fecha();
        }
        if (datosListarTopico.status() != null){
            this.status = datosListarTopico.status();
        }
       if (datosListarTopico.autor() != null){
           this.autor = datosListarTopico.autor();
       }
       if (datosListarTopico.curso() != null){
           this.curso = datosListarTopico.curso();
       }
    }
}
