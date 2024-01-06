package SpringMSA.catalogs.catalog.service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ResponseCatalogDto {

    private String productId;
    private String productName;
    private Integer stock;
    private Integer totalPrice;
    private LocalDateTime createdAt;

}
