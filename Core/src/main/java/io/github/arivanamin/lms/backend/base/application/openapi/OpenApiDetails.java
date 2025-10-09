package io.github.arivanamin.lms.backend.base.application.openapi;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public final class OpenApiDetails {

    public static final String APPLICATION_SERVER_URL = "localhost:8080/";

    public static Contact getOpenApiContactDetails () {
        Contact contact = new Contact();
        contact.setEmail("arivanamin@gmail.com");
        contact.setName("Arivan Amin");
        contact.setUrl("https://www.arivan-amin.com");
        return contact;
    }

    public static License getOpenApiLicence () {
        return new License().name("MIT License")
            .url("https://choosealicense.com/licenses/mit/");
    }

    public static String getOpenApiTermsOfService () {
        return "https://www.arivan-amin.com/spring-clean-microservices/terms";
    }
}
