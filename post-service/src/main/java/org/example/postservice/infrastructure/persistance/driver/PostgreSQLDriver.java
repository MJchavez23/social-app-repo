package org.example.postservice.infrastructure.persistance.driver;

import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgreSQLDriver extends JpaRepository {
}
