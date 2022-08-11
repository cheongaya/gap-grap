package com.roovalant.gapgrap.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

@Slf4j
@Configuration
@OpenAPIDefinition(servers = {@Server(url = "${server.servlet.context-path:/}", description = "${spring.application.name:Default Server URL}")})
public class OpenApiConfig {

    private static final String APP_VERSION = "v0.2";

    public static final String AUTHORIZATION_NAME = "X-Authorization";

    @Bean
    public GroupedOpenApi gapGrapGroup() {
        return GroupedOpenApi.builder().group("gapgrap")
                .pathsToMatch("/api/**")
                .packagesToScan("com.roovalant.gapgrap")
                .addOpenApiCustomiser(documentInfo())
                .addOpenApiCustomiser(security())
                .addOpenApiCustomiser(commonResponses())
                .build();
    }

    private OpenApiCustomiser documentInfo() {
        return openApi -> openApi
                .info(new Info().title("GAP GRAP API")
                        .description(String.join("\n",
                                "## GAP GRAP API 사용 방법",
                                "### 0. Before use..",
                                "   - Document 확인 후 사용",
                                "### 1. X-Authorization",
                                "   - API 우측 자물쇠 아이콘 유무로 확인",
                                "   - 필요시, 'Authorize'에 Bearer token 입력하여 인증")
                        )
                        .contact(new Contact().name("담당자 이름").email("abc@gmail.com"))
                        .version(APP_VERSION)
                );
    }

    private OpenApiCustomiser security() {
        return openApi -> openApi/*.addSecurityItem(new SecurityRequirement().addList(AUTHORIZATION_NAME))*/
                .getComponents().addSecuritySchemes(AUTHORIZATION_NAME, new SecurityScheme()
                        .name("X-Authorization")
                        .description("Enter the token with the Bearer Prefix. (eg 'Bearer {jwt}')")
                        .type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.HEADER));
    }

    private OpenApiCustomiser commonResponses() {
        return openApi -> openApi.getPaths().entrySet().stream()
                .forEach(stringPathItemEntry -> stringPathItemEntry.getValue().readOperations().forEach(operation -> {

                    ApiResponses apiResponses = operation.getResponses();
                    if (!apiResponses.isEmpty()) return;

                    // Common
                    addApiResponses(apiResponses, "500");

                    // Add 401,403 if security attribute is present
                    if (!ObjectUtils.isEmpty(operation.getSecurity())) {
                        addApiResponses(apiResponses, "401", "403");
                    }

                    // Add response code according to method name
                    if (operation.getOperationId().startsWith("getAll")) {
                        addApiResponses(apiResponses, "200");
                    } else if (operation.getOperationId().startsWith("get")) {      // 200, 404
                        addApiResponses(apiResponses, "200", "404");
                    } else if (operation.getOperationId().startsWith("create")) {   // 201, 400
                        addApiResponses(apiResponses, "201", "400");
                    } else if (operation.getOperationId().startsWith("update")) {   // 200, 400
                        addApiResponses(apiResponses, "200", "400");
                    } else if (operation.getOperationId().startsWith("handle")) {   // 200, 422
                        addApiResponses(apiResponses, "200", "422");
                    } else if (operation.getOperationId().startsWith("delete")) {   // 204
                        addApiResponses(apiResponses, "204");
                    } else {    // Default 200, 400, 404
                        addApiResponses(apiResponses, "200", "400", "404");
                    }
                }));
    }

    private void addApiResponses(ApiResponses apiResponses, String... statusCodes) {
        for (String statusCode : statusCodes) {
            Integer code = Integer.parseInt(statusCode);
            apiResponses
                    .addApiResponse(statusCode, new ApiResponse().description(HttpStatus.valueOf(code).getReasonPhrase()));
        }
    }
}
