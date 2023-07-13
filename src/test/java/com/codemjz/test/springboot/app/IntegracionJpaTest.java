package com.codemjz.test.springboot.app;

import com.codemjz.test.springboot.app.models.Cuenta;
import com.codemjz.test.springboot.app.repositories.CuentaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IntegracionJpaTest {
    @Autowired
    CuentaRepository cuentaRepository;

    @Test
    void testFindById() {
        Optional<Cuenta> cuenta = cuentaRepository.findById(1L);
        assertTrue(cuenta.isPresent());
        assertEquals("Andres", cuenta.orElseThrow().getNombre());
    }

    @Test
    void testFindAll() {
        List<Cuenta> lstcuenta = cuentaRepository.findAll();
        System.out.println("VAlor de la lista:");
        System.out.println(Arrays.toString(lstcuenta.toArray()));
        assertFalse(lstcuenta.isEmpty());
        assertEquals(3, lstcuenta.size());
    }


    @Test
    void testFindByIdOtro() {
        Optional<Cuenta> cuenta = cuentaRepository.findById(1L);
        Cuenta objCuenta = cuenta.get();
        System.out.println("id:" + objCuenta.getId() + ", persona:" + objCuenta.getNombre() + ", saldo: " + objCuenta.getSaldo());
        assertTrue(cuenta.isPresent());
        assertEquals("Andres", cuenta.orElseThrow().getNombre());
    }

    @Test
    void testFindByPersona() {
        Optional<Cuenta> cuenta = cuentaRepository.findByNombre("Andres");
        assertTrue(cuenta.isPresent());
        assertEquals("Andres", cuenta.orElseThrow().getNombre());
        assertEquals("1000.00", cuenta.orElseThrow().getSaldo().toPlainString());
    }

    @Test
    void testFindByPersonaThrowException() {
        Optional<Cuenta> cuenta = cuentaRepository.findByNombre("Rod");
        assertThrows(NoSuchElementException.class, cuenta::orElseThrow);
        assertFalse(cuenta.isPresent());
    }

    @Test
    void testFindAllOtro() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        assertFalse(cuentas.isEmpty());
        assertEquals(3, cuentas.size());
    }

    @Test
    void testSave() {
        // Given
        Cuenta cuentaPepe = new Cuenta(null, "Pepe", new BigDecimal("3000"));

        // When
        Cuenta cuenta = cuentaRepository.save(cuentaPepe);

        // Then
        assertEquals("Pepe", cuenta.getNombre());
        assertEquals("3000", cuenta.getSaldo().toPlainString());
//      assertEquals(3, cuenta.getId());
    }

    @Test
    void testUpdate() {
        // Given
        Cuenta cuentaPepe = new Cuenta(null, "Pepe", new BigDecimal("3000"));

        // When
        Cuenta cuenta = cuentaRepository.save(cuentaPepe);

        // Then
        assertEquals("Pepe", cuenta.getNombre());
        assertEquals("3000", cuenta.getSaldo().toPlainString());

        // When
        cuenta.setSaldo(new BigDecimal("3800"));
        Cuenta cuentaActualizada = cuentaRepository.save(cuenta);

        // Then
        assertEquals("Pepe", cuentaActualizada.getNombre());
        assertEquals("3800", cuentaActualizada.getSaldo().toPlainString());
    }

    @Test
    void testDelete() {
        Cuenta cuenta = cuentaRepository.findById(2L).orElseThrow();
        assertEquals("Jhon", cuenta.getNombre());

        cuentaRepository.delete(cuenta);

        assertThrows(NoSuchElementException.class, () -> {
            cuentaRepository.findById(2L).orElseThrow();
        });
        assertEquals(2, cuentaRepository.findAll().size());
    }

    
}
