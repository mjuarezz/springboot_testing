package com.codemjz.test.springboot.app.controller;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;
import com.codemjz.test.springboot.app.models.Cuenta;
import com.codemjz.test.springboot.app.models.CuentaDTO;
import com.codemjz.test.springboot.app.models.TransaccionDTO;
import com.codemjz.test.springboot.app.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    /**
     * cuentaService.
     */
    @Autowired
    private CuentaService cuentaService;

    /**
     *
     * @param id
     * @return cuentaService por id
     */
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Cuenta detalle(@PathVariable final Long id) {
        return cuentaService.findById(id);
    }

    /**
     *
     * @param dto
     * @return ResponseEntity Transeferencia OK
     */
    @PostMapping("/transferir")
    public ResponseEntity<Object> transferir(
            @RequestBody final TransaccionDTO dto) {
        cuentaService.transferir(dto.getCuentaOrigenId(),
                dto.getCuentaDestinoId(),
                dto.getMonto(),
                dto.getBancoId());
        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", "OK");
        response.put("mensaje", "Transferencia realizada con exito!");
        response.put("transaccion", dto);
        return ResponseEntity.ok(response);
    }

    /**
     *
     * @return todas las cuentas
     */
    @GetMapping
    @ResponseStatus(OK)
    public List<Cuenta> listar() {
        return cuentaService.findAll();
    }

    /**
     *
     * @param cuentaDTO
     * @return cuenta guardada
     */
    @PostMapping
    @ResponseStatus(CREATED)
    public Cuenta guardar(@RequestBody final CuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta(
                cuentaDTO.getIdDto(),
                cuentaDTO.getNombreDto(),
                cuentaDTO.getSaldoDto());
        return cuentaService.save(cuenta);
    }
}
