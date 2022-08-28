package com.roovalant.gapgrap.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * The Apt entity
 *
 * @author: DEVROOT
 * @since: 2022.08.27
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id: 유저 식별자
     */
    @Id
    @NotNull
    @Size(max = 40)
    @Column(name = "id", length = 40, unique = true, nullable = false)
    private String id;

    /**
     * name: 이름
     */
    @Size(max = 255)
    @Column(name = "name", length = 255)
    private String name;

    /**
     * nickname: 닉네임
     */
    @NotNull
    @Size(max = 255)
    @Column(name = "nickname", length = 255)
    private String nickname;

    /**
     * email: 이메일
     */
    @NotNull
    @Size(max = 255)
    @Convert(converter = AES256Converter.class)
    @Column(name = "email", length = 255, unique = true, nullable = false)
    private String email;

    /**
     * phone: 휴대폰 번호
     */
    @Builder.Default
    @Size(max = 255)
    @Convert(converter = AES256Converter.class)
    @Column(name = "phone", length = 255/*, nullable = false*/)
    private String phone = "";

    /**
     * createAt: 가입일시
     */
    @Builder.Default
    @NotNull
    @Column(name = "create_at", nullable = false)
    private Instant createAt = Instant.now();

    /**
     * leaveAt: 탈퇴일자(yyyy-MM-dd HH:mm:ss)
     */
    @Builder.Default
    @Size(max = 40)
    @Column(name = "leave_at", length = 40)
    private String leaveAt = "";

    /**
     * kakaoId: 카카오 회원 식별자
     */
    @Builder.Default
    @NotNull
    @Size(max = 255)
    @Column(name = "kakao_id", length = 255, nullable = false)
    private String kakaoId = "";

    /**
     * appleId: Apple 회원 식별자
     */
    @Builder.Default
    @NotNull
    @Size(max = 255)
    @Column(name = "apple_id", length = 255, nullable = false)
    private String appleId = "";

    /**
     * imageUrl: 이미지 URL
     */
    @Size(max = 255)
    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Builder.Default
    @Column(name = "mb_today_login")
    private Instant lastLogin = Instant.now();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
