package com.pet.depo23.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity

public class Bond {

    @Id @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private String isin;
    private Date offer_date;
    private Date mat_date;
    @Column(columnDefinition = "integer default 1000")
    private Double init_face_value;
    @Column(columnDefinition = "varchar(255) default 'RUR'")
    private String currency_id;
    private Integer coupon_frequency;
    private Double coupon_value;
    private String type;

    public Bond( String code, String name, String isin, Date offer_date, Date mat_date,
                 Double init_face_value, String currency_id, Integer coupon_frequency,
                 Double coupon_value, String type ){
        this.code = code;
        this.name = name;
        this.isin = isin;
        this.offer_date = offer_date;
        this.mat_date = mat_date;
        this.init_face_value = init_face_value;
        this.currency_id = currency_id;
        this.coupon_frequency = coupon_frequency;
        this.coupon_value = coupon_value;
        this.type = type;
    }
 /*   @Override
    public String toString() {
        return "Bond{" + "id=" + this.id + ", name='" + this.name + '\'' + ", isin='" + this.isin + '\'' + '}';
    } */
}
