package com.algaworks.algashop.ordering.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Phone Value Object Tests")
class PhoneTest {

    @Test
    @DisplayName("Should throw NullPointerException when value is null")
    void testConstructorWithNullValue() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Phone(null));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when value is blank")
    void testConstructorWithBlankValue() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Phone(""))
                .withMessage("Phone cannot be blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when value is only spaces")
    void testConstructorWithOnlySpaces() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Phone("   "))
                .withMessage("Phone cannot be blank");
    }

    @Test
    @DisplayName("Should accept a valid phone value")
    void testConstructorWithValidValue() {
        // Given a valid phone
        String validPhone = "111112222";

        // Then should not throw exception
        Phone phone = new Phone(validPhone);
        assertThat(phone).isNotNull();
        assertThat(phone.value()).isEqualTo(validPhone);
    }

    @Test
    @DisplayName("Should return correct toString representation")
    void testToString() {
        // Given a phone
        String phoneValue = "111112222";
        Phone phone = new Phone(phoneValue);

        // Then toString should return the value
        assertThat(phoneValue).isEqualTo(phone.toString());
    }

}

