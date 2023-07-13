package com.codemjz.test.springboot.app.services.impl;

import com.codemjz.test.springboot.app.models.Banco;
import com.codemjz.test.springboot.app.models.Cuenta;
import com.codemjz.test.springboot.app.repositories.BancoRepository;
import com.codemjz.test.springboot.app.repositories.CuentaRepository;
import com.codemjz.test.springboot.app.services.CuentaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    /**
     * cuentaRepository.
     */
    private CuentaRepository cuentaRepository;
    /**
     * bancoRepository.
     */
    private BancoRepository bancoRepository;

    /**
     * @param setCuentaRepository
     * @param setBancoRepository
     */
    public CuentaServiceImpl(
            final CuentaRepository setCuentaRepository,
            final BancoRepository setBancoRepository) {
        this.cuentaRepository = setCuentaRepository;
        this.bancoRepository = setBancoRepository;
    }

    /**
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Cuenta findById(final Long id) {
        return cuentaRepository.findById(id).orElseThrow();
    }

    /**
     * @param bancoId
     * @return TotalTransferencia
     */
    @Override
    @Transactional(readOnly = true)
    public int revisarTotalTransferencias(final Long bancoId) {
        Banco banco = bancoRepository.findById(bancoId).orElseThrow();
        return banco.getTotalTransferencia();
    }

    /**
     * @param cuentaId
     * @return saldo de cuenta
     */
    @Override
    @Transactional(readOnly = true)
    public BigDecimal revisarSaldo(final Long cuentaId) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow();
        return cuenta.getSaldo();
    }

    /**
     * @param numeroCuentaOrigen
     * @param numeroCuentaDestino
     * @param monto
     * @param bancoId
     */
    @Override
    @Transactional
    public void transferir(final Long numeroCuentaOrigen,
                           final Long numeroCuentaDestino,
                           final BigDecimal monto,
                           final Long bancoId) {

        Cuenta cuentaOrigen = cuentaRepository.findById(numeroCuentaOrigen)
                .orElseThrow();
        cuentaOrigen.debito(monto);
        cuentaRepository.save(cuentaOrigen);

        Cuenta cuentaDestino = cuentaRepository.findById(numeroCuentaDestino)
                .orElseThrow();
        cuentaDestino.credito(monto);
        cuentaRepository.save(cuentaDestino);

        Banco banco = bancoRepository.findById(bancoId).orElseThrow();
        int totalTransferencias = banco.getTotalTransferencia();
        banco.setTotalTransferencia(++totalTransferencias);
        bancoRepository.save(banco);

    }

    /**
     * @return todas las cuentas
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    /**
     * @param cuenta
     * @return cuenta guardada
     */
    @Override
    @Transactional
    public Cuenta save(final Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }
}
