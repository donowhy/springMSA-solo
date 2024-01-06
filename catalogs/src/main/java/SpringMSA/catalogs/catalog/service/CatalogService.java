package SpringMSA.catalogs.catalog.service;

import SpringMSA.catalogs.catalog.entity.CatalogEntity;
import SpringMSA.catalogs.catalog.service.dto.ResponseCatalogDto;

import java.util.List;

public interface CatalogService {
    List<ResponseCatalogDto> getAllCatalogs();
}
