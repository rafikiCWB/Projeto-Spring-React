package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.devsuperior.dsvendas.dto.SaleSumDTO;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
        //obj é um apelido para cada objeto seller que eu estou bucando no banco
            // ponto. significa agrupar
    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
            + " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupBySeller();

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
            + " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
