package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="serials")
public class Serial extends AbstractEntity {
    @Column(nullable = false)
    private String nameRus;

    @Column
    private String nameEng;

    @Column(nullable = false)
    private String link;

    @Column
    private Float rateKinopoisk;

    @Column
    private Float rateIMDb;

    @Column
    private Float rateOwn;

    @Column
    private String description;


}
