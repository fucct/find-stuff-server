package com.fucct.findstuff.common;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Embeddable
@NoArgsConstructor
@Getter
public class ImageUrl {

    @NotBlank
    private String url;
}
