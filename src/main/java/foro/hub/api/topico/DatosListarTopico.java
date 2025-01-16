package foro.hub.api.topico;


import jakarta.validation.constraints.NotNull;

public record DatosListarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        String fecha,
        String status,
        String autor,
        String curso
) {

    public DatosListarTopico(Topico datoTopico){
        this(
                datoTopico.getId(),
                datoTopico.getTitulo(),
                datoTopico.getMensaje(),
                datoTopico.getFecha(),
                datoTopico.getStatus(),
                datoTopico.getAutor(),
                datoTopico.getCurso());

    }
}
