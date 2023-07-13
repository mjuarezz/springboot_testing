package com.codemjz.test.springboot.app;

import com.codemjz.test.springboot.app.models.Banco;
import com.codemjz.test.springboot.app.models.Cuenta;

import java.math.BigDecimal;
import java.util.Optional;

public final class Datos {
    /**
     * Constructor.
     */
    private Datos() {
    }

    /**
     * SALDO_CUENTA_001.
     */
    private static final int SALDO_CUENTA_001 = 1000;
    /**
     * SALDO_CUENTA_002.
     */
    private static final int SALDO_CUENTA_002 = 2000;
    /**
     * SALDO_CUENTA_003.
     */
    private static final int SALDO_CUENTA_003 = 3000;

    /**
     * CUENTA_001.
     */
    public static final Cuenta CUENTA_001 =
            new Cuenta(1L, "Andres", new BigDecimal(SALDO_CUENTA_001));
    /**
     * CUENTA_002.
     */
    public static final Cuenta CUENTA_002 =
            new Cuenta(1L, "Jhon", new BigDecimal(SALDO_CUENTA_002));
    /**
     * CUENTA_003.
     */
    public static final Cuenta CUENTA_003 =
            new Cuenta(1L, "Pedro", new BigDecimal(SALDO_CUENTA_003));
    /**
     * BANCO.
     */
    public static final Banco BANCO =
            new Banco(1L, "El Banco Financiero", 0);

    /**
     *
     * @return Creaccion de CUENTA_001
     */
    public static Optional<Cuenta> crearCuenta001() {
        return Optional.of(
                new Cuenta(1L, "Andres", new BigDecimal(SALDO_CUENTA_001)));
    }
    /**
     *
     * @return Creaccion de CUENTA_002
     */
    public static Optional<Cuenta> crearCuenta002() {
        return Optional.of(
                new Cuenta(1L, "Jhon", new BigDecimal(SALDO_CUENTA_002)));
    }

    /**
     *
     * @return Creaccion de CUENTA_003
     */
    public static Optional<Cuenta> crearCuenta003() {
        return Optional.of(
                new Cuenta(1L, "Pedro", new BigDecimal(SALDO_CUENTA_003)));
    }

    /**
     *
     * @return Creaccion de BANCO
     */
    public static Optional<Banco> crearBanco() {
        return Optional.of(new Banco(1L, "El Banco Financiero", 0));
    }

}
