package com.codemjz.test.springboot.app.services;

import com.codemjz.test.springboot.app.models.Cuenta;

import java.math.BigDecimal;
import java.util.List;

public interface CuentaService {
    /**
     *
     * @param id
     * @return cuenta por id
     */
    Cuenta findById(Long id);

    /**
     *
     * @param bancoId
     * @return total transferencia
     */
    int revisarTotalTransferencias(Long bancoId);

    /**
     *
     * @param cuentaId
     * @return saldo de cuenta
     */
    BigDecimal revisarSaldo(Long cuentaId);

    /**
     *
     * @param numeroCuentaOrigen
     * @param numeroCuentaDestino
     * @param monto
     * @param bancoId
     */
    void transferir(Long numeroCuentaOrigen,
                    Long numeroCuentaDestino,
                    BigDecimal monto,
                    Long bancoId);

    /**
     *
     * @return todas las cuentas
     */
    List<Cuenta> findAll();

    /**
     *
     * @param cuenta
     * @return cuenta
     */
    Cuenta save(Cuenta cuenta);

}
