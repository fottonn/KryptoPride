package ru.airiva.service.da.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.airiva.entities.TlgBotTranslationEntity;

/**
 * @author Ivan
 */
@Repository
public interface TlgBotTranslationRepo extends JpaRepository<TlgBotTranslationEntity, Long> {
}
