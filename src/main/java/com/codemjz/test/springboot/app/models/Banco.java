package com.codemjz.test.springboot.app.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "bancos")
public class Banco {
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
     * total transferencia.
     */
    @Column(name = "total_transferencia")
    private int totalTransferencia;

    /**
     * constructor.
     */
    public Banco() {
    }

    /**
     *
     * @param setId
     * @param setNombre
     * @param setTotalTransferencia
     */
    public Banco(final Long setId, final String setNombre,
                 final int setTotalTransferencia) {
        this.setId(setId);
        this.setNombre(setNombre);
        this.setTotalTransferencia(setTotalTransferencia);
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
     * @return total transferencia
     */
    public int getTotalTransferencia() {
        return totalTransferencia;
    }

    /**
     *
     * @param setTotalTransferencia
     */
    public void setTotalTransferencia(final int setTotalTransferencia) {
        this.totalTransferencia = setTotalTransferencia;
    }
}
