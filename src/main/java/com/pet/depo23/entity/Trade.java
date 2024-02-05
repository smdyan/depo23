package com.pet.depo23.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.lang.Long;

@Entity
@DynamicUpdate
@Table( name="trades" )
public class Trade implements Serializable{
    @Version
    private long version;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long  id;
    @Column( name = "tradeDate" )
    private LocalDate   tradeDate;
    @Column( name="accountId" )
    private String      accountId;
    @Column( name="secId", nullable = false )
    private String      secId;
    @Column( name="tradeType" )
    private String      tradeType;
    @Column( name="qty" )
    private Integer     qty;
    @Column( name="price" )
    private BigDecimal  price;
    public Trade(){}
    public Long       getId(){ return this.id; }
    public void       setId( Long id ){ this.id = id; }
    public void       setTradeDate( LocalDate tradeDate ){ this.tradeDate = tradeDate; }
    public LocalDate  getTradeDate(){ return this.tradeDate; }
    public void       setAccountId( String accountId ){ this.accountId = accountId; }
    public String     getAccountId(){ return this.accountId; }
    public void       setSecId( String secId ){ this.secId = secId; }
    public String     getSecId(){ return this.secId; }
    public void       setTradeType( String tradeType ){ this.tradeType = tradeType; }
    public String     getTradeType(){ return this.tradeType; }
    public void       setQty( Integer qty ){ this.qty = qty; }
    public Integer    getQty(){ return this.qty; }
    public void       setPrice( BigDecimal price ){ this.price = price; }
    public BigDecimal getPrice(){ return this.price; }
}
