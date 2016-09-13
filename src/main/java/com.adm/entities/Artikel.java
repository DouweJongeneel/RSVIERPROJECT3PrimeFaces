/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adm.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albert
 */
@Entity
@Table(name = "artikel")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Artikel.findAll", query = "SELECT a FROM Artikel a"),
	@NamedQuery(name = "Artikel.findByArtikelId", query = "SELECT a FROM Artikel a WHERE a.artikelId = :artikelId"),
	@NamedQuery(name = "Artikel.findByArtikelNaam", query = "SELECT a FROM Artikel a WHERE a.artikelNaam = :artikelNaam"),
	@NamedQuery(name = "Artikel.findByArtikelType", query = "SELECT a FROM Artikel a WHERE a.artikelType = :artikelType"),
	@NamedQuery(name = "Artikel.findByDatumAanmaak", query = "SELECT a FROM Artikel a WHERE a.datumAanmaak = :datumAanmaak"),
	@NamedQuery(name = "Artikel.findByInAssortiment", query = "SELECT a FROM Artikel a WHERE a.inAssortiment = :inAssortiment"),
	@NamedQuery(name = "Artikel.findByVerwachteLevertijd", query = "SELECT a FROM Artikel a WHERE a.verwachteLevertijd = :verwachteLevertijd")})
public class Artikel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "artikelId")
	private Long artikelId;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "artikelNaam")
	private String artikelNaam;
	@Size(max = 255)
    @Column(name = "artikelType")
	private String artikelType;
	@Basic(optional = false)
    @NotNull
    @Column(name = "datumAanmaak")
    @Temporal(TemporalType.TIMESTAMP)
	private Date datumAanmaak;
	@Basic(optional = false)
    @NotNull
    @Column(name = "inAssortiment")
	private boolean inAssortiment;
	@Column(name = "verwachteLevertijd")
	private Integer verwachteLevertijd;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artikelId")
	private Collection<Bestelartikel> bestelartikelCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artikelId")
	private Collection<Prijsartikel> prijsartikelCollection;

	@Transient
	BigDecimal actuelePrijs;

	@Transient
	String artikelAfbeelding;

	public Artikel() {
	}

	public Artikel(Long artikelId) {
		this.artikelId = artikelId;
	}

	public Artikel(Long artikelId, String artikelNaam, Date datumAanmaak, boolean inAssortiment) {
		this.artikelId = artikelId;
		this.artikelNaam = artikelNaam;
		this.datumAanmaak = datumAanmaak;
		this.inAssortiment = inAssortiment;
	}

	public Long getArtikelId() {
		return artikelId;
	}

	public void setArtikelId(Long artikelId) {
		this.artikelId = artikelId;
	}

	public String getArtikelNaam() {
		return artikelNaam;
	}

	public void setArtikelNaam(String artikelNaam) {
		this.artikelNaam = artikelNaam;
	}

	public String getArtikelType() {
		return artikelType;
	}

	public void setArtikelType(String artikelType) {
		this.artikelType = artikelType;
	}

	public Date getDatumAanmaak() {
		return datumAanmaak;
	}

	public void setDatumAanmaak(Date datumAanmaak) {
		this.datumAanmaak = datumAanmaak;
	}

	public boolean getInAssortiment() {
		return inAssortiment;
	}

	public void setInAssortiment(boolean inAssortiment) {
		this.inAssortiment = inAssortiment;
	}

	public Integer getVerwachteLevertijd() {
		return verwachteLevertijd;
	}

	public void setVerwachteLevertijd(Integer verwachteLevertijd) {
		this.verwachteLevertijd = verwachteLevertijd;
	}

	@XmlTransient
	public Collection<Bestelartikel> getBestelartikelCollection() {
		return bestelartikelCollection;
	}

	public void setBestelartikelCollection(Collection<Bestelartikel> bestelartikelCollection) {
		this.bestelartikelCollection = bestelartikelCollection;
	}

	@XmlTransient
	public Collection<Prijsartikel> getPrijsartikelCollection() {
		return prijsartikelCollection;
	}

	public void setPrijsartikelCollection(Collection<Prijsartikel> prijsartikelCollection) {
		this.prijsartikelCollection = prijsartikelCollection;
	}

	public BigDecimal getActuelePrijs() {
		return actuelePrijs;
	}

	public void setActuelePrijs(BigDecimal actuelePrijs) {
		this.actuelePrijs = actuelePrijs;
	}

	public String getArtikelAfbeelding() {
		return artikelAfbeelding;
	}

	public void setArtikelAfbeelding(String artikelAfbeelding) {
		this.artikelAfbeelding = artikelAfbeelding;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (artikelId != null ? artikelId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Artikel)) {
			return false;
		}
		Artikel other = (Artikel) object;
		if ((this.artikelId == null && other.artikelId != null) || (this.artikelId != null && !this.artikelId.equals(other.artikelId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.rsvierproject3.Artikel[ artikelId=" + artikelId + " ]";
	}
	
}
