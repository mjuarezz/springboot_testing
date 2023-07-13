package com.codemjz.test.springboot.app.models;

import com.codemjz.test.springboot.app.exceptions.DineroInsuficienteException;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * nombre.
     */
    private String nombre;
    /**
     * saldo.
     */
    private BigDecimal saldo;

    /**
     * constructor.
     */
    public Cuenta() {
    }

    /**
     *
     * @param setId
     * @param setNombre
     * @param setSaldo
     */
    public Cuenta(final Long setId, final String setNombre,
                  final BigDecimal setSaldo) {
        this.id = setId;
        this.nombre = setNombre;
        this.saldo = setSaldo;
    }

    /**
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param setId
     */
    public void setId(final Long setId) {
        this.id = setId;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param setNombre
     */
    public void setNombre(final String setNombre) {
        this.nombre = setNombre;
    }

    /**
     *
     * @return saldo
     */
    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     *
     * @param setSaldo
     */
    public void setSaldo(final BigDecimal setSaldo) {
        this.saldo = setSaldo;
    }

    /**
     *
     * @param monto
     */
    public void debito(final BigDecimal monto) {
        BigDecimal nuevoSaldo = this.saldo.subtract(monto);
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new DineroInsuficienteException(
                    "Dinero insuficiente en la cuenta");
        }
        this.saldo = nuevoSaldo;
    }

    /**
     *
     * @param monto
     */
    public void credito(final BigDecimal monto) {
        this.saldo = this.saldo.add(monto);
    }

    /**
     *
     * @param o
     * @return bool
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(id, cuenta.id)
                && Objects.equals(nombre, cuenta.nombre)
                && Objects.equals(saldo, cuenta.saldo);
    }

    /**
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, saldo);
    }
}
