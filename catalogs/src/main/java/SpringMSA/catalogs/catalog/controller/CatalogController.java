package SpringMSA.catalogs.catalog.controller;

import SpringMSA.catalogs.catalog.service.CatalogService;
import SpringMSA.catalogs.catalog.service.dto.ResponseCatalogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/catalog_service")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalogDto>> getAllCatalogs() {
        return ResponseEntity.status(HttpStatus.OK).body(catalogService.getAllCatalogs());
    }

}
