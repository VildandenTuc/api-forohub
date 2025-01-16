package foro.hub.api.controller;

import foro.hub.api.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ITopicoRepository iTopicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> crearTopico(@RequestBody @Valid DatosCrearTopico datosCrearTopico,
                                      UriComponentsBuilder uriComponentsBuilder){
        Topico topico = iTopicoRepository.save(new Topico(datosCrearTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarTopico>> listarTopicos(@PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(iTopicoRepository.findAll(paginacion).map(DatosListarTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListarTopico> listarTopicoPorId(@PathVariable @Valid Long id) {
        DatosListarTopico topico = iTopicoRepository.findById(id)
                .map(DatosListarTopico::new)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado con el ID: " + id));
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosListarTopico datosListarTopico) {
        Topico topico = iTopicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado con el ID: " + id));

        topico.actualizarTopico(datosListarTopico);
        iTopicoRepository.save(topico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()));
    }

    //Eliminación fisica de un topico usando deleteById
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        if (!iTopicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico no encontrado con el ID: " + id);
        }
        iTopicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
