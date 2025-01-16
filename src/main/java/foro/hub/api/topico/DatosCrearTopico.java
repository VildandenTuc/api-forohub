package foro.hub.api.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosCrearTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        String fecha,

        @NotBlank
        String status,

        @NotBlank
        String autor,

        @NotBlank
        String curso

) {
}
