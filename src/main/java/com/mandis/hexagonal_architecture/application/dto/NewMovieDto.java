package com.mandis.hexagonal_architecture.application.dto;

import java.time.LocalDate;

public record NewMovieDto(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        String directorName
) {
}
