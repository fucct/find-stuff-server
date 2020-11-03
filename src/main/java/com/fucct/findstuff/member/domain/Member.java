package com.fucct.findstuff.member.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fucct.findstuff.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
@Getter
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(max = 20)
    private String nickname;

    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    @Length(max = 20)
    private String password;

    @Enumerated(value = EnumType.STRING)
    private MemberType memberType;
}


