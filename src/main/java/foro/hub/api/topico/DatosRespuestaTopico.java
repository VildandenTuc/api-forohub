package foro.hub.api.topico;

import jakarta.validation.constraints.NotNull;

public record DatosRespuestaTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        String fecha,
        String status,
        String autor,
        String curso
) {
}
