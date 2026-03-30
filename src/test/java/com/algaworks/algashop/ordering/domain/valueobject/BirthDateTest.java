package com.algaworks.algashop.ordering.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("BirthDate Value Object Tests")
class BirthDateTest {

    @Test
    @DisplayName("Should calculate age correctly")
    void testAgeMethod() {
        // Given a birth date from 1990
        LocalDate birthDate = LocalDate.of(1990, 7, 5);
        BirthDate bd = new BirthDate(birthDate);

        // When calculating age
        Integer age = bd.age();

        // Then age should be calculated correctly based on today's date
        assertThat(age).isGreaterThan(0);
        // In 2026, someone born in 1990 should be around 35-36 years old
        assertThat(age).isGreaterThanOrEqualTo(35);
    }

    @Test
    @DisplayName("Should throw NullPointerException when value is null")
    void testConstructorWithNullValue() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new BirthDate(null));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when BirthDate is in the future")
    void testConstructorWithFutureDate() {
        // Given a future date
        LocalDate futureDate = LocalDate.now().plusDays(1);

        // Then should throw IllegalArgumentException
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BirthDate(futureDate))
                .withMessage("BirthDate must be a past date");
    }

    @Test
    @DisplayName("Should accept a past date successfully")
    void testConstructorWithValidPastDate() {
        // Given a past date
        LocalDate pastDate = LocalDate.now().minusYears(1);

        // Then should not throw exception
        BirthDate bd = new BirthDate(pastDate);
        assertThat(bd).isNotNull();
        assertThat(bd.value()).isEqualTo(pastDate);
        assertThat(pastDate.toString()).isEqualTo(bd.toString());
    }

}

