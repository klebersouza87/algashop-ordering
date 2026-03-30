package com.algaworks.algashop.ordering.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Document Value Object Tests")
class DocumentTest {

    @Test
    @DisplayName("Should throw NullPointerException when value is null")
    void testConstructorWithNullValue() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Document(null));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when value is blank")
    void testConstructorWithBlankValue() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Document(""))
                .withMessage("Document cannot be blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when value is only spaces")
    void testConstructorWithOnlySpaces() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Document("   "))
                .withMessage("Document cannot be blank");
    }

    @Test
    @DisplayName("Should accept a valid document value")
    void testConstructorWithValidValue() {
        // Given a valid document
        String validDocument = "12345678901";

        // Then should not throw exception
        Document document = new Document(validDocument);
        assertThat(document).isNotNull();
        assertThat(document.value()).isEqualTo(validDocument);
    }

    @Test
    @DisplayName("Should return correct toString representation")
    void testToString() {
        // Given a document
        String documentValue = "12345678901";
        Document document = new Document(documentValue);

        // Then toString should return the value
        assertThat(documentValue).isEqualTo(document.toString());
    }

}

