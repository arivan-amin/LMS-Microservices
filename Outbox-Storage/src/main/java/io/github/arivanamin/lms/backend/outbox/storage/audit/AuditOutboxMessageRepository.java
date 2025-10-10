package io.github.arivanamin.lms.backend.outbox.storage.audit;

import io.github.arivanamin.lms.backend.base.core.outbox.OutboxMessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuditOutboxMessageRepository extends JpaRepository<JpaAuditOutboxMessage, UUID> {

    List<JpaAuditOutboxMessage> findAllByStatus (OutboxMessageStatus status);
}
