package com.codemjz.test.springboot.app.repositories;

import com.codemjz.test.springboot.app.models.Banco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BancoRepository extends JpaRepository<Banco, Long> {
}
