package SpringMSA.catalogs.catalog.repository;

import SpringMSA.catalogs.catalog.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
}
