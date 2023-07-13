package com.codemjz.test.springboot.app.models;

import java.math.BigDecimal;

public class TransaccionDTO {
    /**
     * cuentaOrigenId.
     */
    private Long cuentaOrigenId;
    /**
     * cuentaDestinoId.
     */
    private Long cuentaDestinoId;
    /**
     * monto.
     */
    private BigDecimal monto;

    /**
     *
     * @return bancoId
     */
    public Long getBancoId() {
        return bancoId;
    }

    /**
     *
     * @param setBancoId
     */
    public void setBancoId(final Long setBancoId) {
        this.bancoId = setBancoId;
    }

    /**
     * bancoId.
     */
    private Long bancoId;

    /**
     *
     * @return cuentaOrigenId
     */
    public Long getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    /**
     *
     * @param setCuentaOrigenId
     */
    public void setCuentaOrigenId(final Long setCuentaOrigenId) {
        this.cuentaOrigenId = setCuentaOrigenId;
    }

    /**
     *
     * @return cuentaDestinoId
     */
    public Long getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    /**
     *
     * @param setCuentaDestinoId
     */
    public void setCuentaDestinoId(final Long setCuentaDestinoId) {
        this.cuentaDestinoId = setCuentaDestinoId;
    }

    /**
     *
     * @return monto
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     *
     * @param setMonto
     */
    public void setMonto(final BigDecimal setMonto) {
        this.monto = setMonto;
    }
}
