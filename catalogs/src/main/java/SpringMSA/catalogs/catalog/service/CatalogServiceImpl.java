package SpringMSA.catalogs.catalog.service;

        import SpringMSA.catalogs.catalog.entity.CatalogEntity;
        import SpringMSA.catalogs.catalog.repository.CatalogRepository;
        import SpringMSA.catalogs.catalog.service.dto.ResponseCatalogDto;
        import lombok.RequiredArgsConstructor;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;
        import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CatalogServiceImpl implements CatalogService{

    private final CatalogRepository catalogRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ResponseCatalogDto> getAllCatalogs() {
        List<CatalogEntity> catalogEntities = catalogRepository.findAll();

        return catalogEntities.stream()
                .map(entity -> ResponseCatalogDto.builder()
                        .productId(entity.getProductId())
                        .productName(entity.getProductName())
                        .stock(entity.getStock())
                        .totalPrice(entity.getUnitPrice() * entity.getStock())
                        .createdAt(entity.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

}
