package com.codemjz.test.springboot.app;

import com.codemjz.test.springboot.app.models.Banco;
import com.codemjz.test.springboot.app.models.Cuenta;

import java.math.BigDecimal;
import java.util.Optional;

public class Datos {
    public static final Cuenta CUENTA_001 = new Cuenta(1L,"Andres",new BigDecimal(1000));
    public static final Cuenta CUENTA_002 = new Cuenta(1L,"Jhon",new BigDecimal(2000));
    public static final Cuenta CUENTA_003 = new Cuenta(1L,"Pedro",new BigDecimal(3000));
    public static final Banco BANCO = new Banco(1L,"El Banco Financiero",0);

    public static Optional<Cuenta> crearCuenta001() {
        return Optional.of(new Cuenta(1L,"Andres",new BigDecimal(1000)));
    }
    public static Optional<Cuenta> crearCuenta002() {
        return Optional.of(new Cuenta(1L,"Jhon",new BigDecimal(2000)));
    }

    public static Optional<Cuenta> crearCuenta003() {
        return Optional.of(new Cuenta(1L,"Pedro",new BigDecimal(3000)));
    }

    public static Optional<Banco> crearBanco() {
        return Optional.of(new Banco(1L,"El Banco Financiero",0));
    }

}
